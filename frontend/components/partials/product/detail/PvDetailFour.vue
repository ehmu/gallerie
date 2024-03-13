<template>
	<div class="product-single-details">
		<div class="product-single-header position-relative">
			<div class="row">
				<div class="col-lg-6">
					<h1 class="product-title">{{ product.name }}</h1>
				</div>

			</div>

			<pv-product-nav
				:next-product="nextProduct"
				:prev-product="prevProduct"
				type="extended"
			></pv-product-nav>

			<div class="ratings-container">
				<div class="product-ratings">
					<span
						class="ratings"
						:style="'width:' + product.ratings * 20 + '%'"
					></span>
					<span class="tooltiptext tooltip-top">{{ product.ratings | priceFormat }}</span>
				</div>
				<a
					href="javascript:;"
					class="rating-link"
					v-if="product.reviews > 0"
				>( {{ product.reviews }} Reviews )</a>
				<a
					href="javascript:;"
					class="rating-link"
					v-else
				>( There is no review yet. )</a>
			</div>

			<hr class="short-divider" />

			<div class="row">
				<div class="col-xl-6">
					<div
						class="price-box pb-4 pb-xl-0"
						v-if="product.price"
						key="singlePrice"
					>
						<template v-if="!product.is_sale">
							<span class="product-price">${{ product.price | priceFormat }}</span>
						</template>

						<template v-else>
							<span class="product-price">${{ product.sale_price | priceFormat }}</span>
							<span class="old-price product-price">${{ product.price | priceFormat }}</span>
						</template>
					</div>

					<div
						class="price-box pb-4 pb-xl-0"
						v-else
					>
						<template v-if="minPrice !== maxPrice">
							<span class="product-price">${{ minPrice | priceFormat }} &ndash; ${{ maxPrice | priceFormat }}</span>
						</template>

						<template v-else>
							<span class="product-price">${{ minPrice | priceFormat }}</span>
						</template>
					</div>
				</div>

				<div class="col-xl-6 d-flex flex-column align-items-xl-end">
					<div class="widget-area">
						<div class="widget widget-info">
							<ul class="promote">
								<li>
									<i class="icon-shipped"></i>
									<h4>
										FREE
										<br />SHIPPING
									</h4>
								</li>
								<li>
									<i class="icon-us-dollar"></i>
									<h4>
										100% MONEY
										<br />BACK GUARANTEE
									</h4>
								</li>
								<li>
									<i class="icon-online-support"></i>
									<h4>
										ONLINE
										<br />SUPPORT 24/7
									</h4>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div
			class="product-desc"
			v-if="product.short_description"
		>
			<p>{{ product.short_description }}</p>
		</div>



	</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';
import { VueSlideToggle } from 'vue-slide-toggle';
import PvProductNav from '~/components/partials/product/PvProductNav';
import { baseUrl } from '~/api/index';

export default {
	components: {
		VueSlideToggle,
		PvProductNav
	},
	props: {
		product: Object,
		prevProduct: Object,
		nextProduct: Object
	},
	data: function() {
		return {
			minPrice: 0,
			maxPrice: 0,
			qty: 1,
			currentIndex: 0,
			baseUrl: baseUrl,
			vSizes: [],
			vColors: [],
			curSize: {
				name: null,
				text: null,
				image: null
			},
			curColor: {
				name: null,
				text: null,
				image: null
			},
			tIndex: 0
		};
	},
	computed: {
		...mapGetters('wishlist', ['wishList']),
		curIndex: function() {
			if (this.curColor.name !== null && this.vSizes.length === 0) {
				let index = this.product.variants.findIndex(
					item => item.colors[0].color_name === this.curColor.name
				);
				this.tIndex = index;
				return index;
			}
			if (this.curSize.name !== null && this.vColors.length === 0) {
				let index = this.product.variants.findIndex(
					item => item.size[0].size_name === this.curSize.name
				);
				this.tIndex = index;
				return index;
			}
			if (this.curColor.name !== null && this.curSize.name !== null) {
				let index = this.product.variants.findIndex(
					item =>
						item.colors[0].color_name === this.curColor.name &&
						item.size[0].size_name === this.curSize.name
				);
				this.tIndex = index;
				return index;
			} else {
				return this.tIndex;
			}
		},
		isCartActive: function() {
			if (this.product.stock < parseInt(this.qty)) return false;
			if (this.product.variants.length === 0) return true;
			if (this.curSize.name !== null && this.curColor.name !== null)
				return true;
			if (this.curColor.name !== null && this.vSizes.length === 0)
				return true;
			if (this.curSize.name !== null && this.vColors.length === 0)
				return true;
			return false;
		},
		isWishlisted: function() {
			if (
				this.wishList.findIndex(
					item => item.name === this.product.name
				) > -1
			)
				return true;
			return false;
		},
		isPriceShow: function() {
			if (this.curSize.name !== null && this.curColor.name !== null)
				return true;
			if (this.curColor.name !== null && this.vSizes.length === 0)
				return true;
			if (this.curSize.name !== null && this.vColors.length === 0)
				return true;
			return false;
		}
	},
	mounted: function() {
		if (this.product.variants && !this.product.price) {
			this.minPrice = this.product.variants[0].price;

			this.product.variants.forEach(item => {
				let itemPrice = item.sale_price ? item.sale_price : item.price;
				if (this.minPrice > itemPrice) this.minPrice = itemPrice;
				if (this.maxPrice < itemPrice) this.maxPrice = itemPrice;
			});
		}


	},
	methods: {
		...mapActions('cart', ['addToCart']),
		...mapActions('wishlist', ['addToWishlist']),
		plusQty: function() {
			if (this.qty < this.product.stock) this.qty++;
		},
		minusQty: function() {
			if (this.qty > 1) this.qty--;
		},
		addCart: function() {
			if (this.isCartActive) {
				let saledProduct;
				if (this.product.variants.length > 0) {
					let saledPrice;
					if (this.product.price)
						saledPrice = this.product.sale_price
							? this.product.sale_price
							: this.product.price;
					else {
						saledPrice = this.product.variants[this.curIndex]
							.sale_price
							? this.product.variants[this.curIndex].sale_price
							: this.product.variants[this.curIndex].price;
					}
					saledProduct = {
						...this.product,
						qty: this.qty,
						name:
							this.product.name +
							' - ' +
							this.curColor.name.charAt(0).toUpperCase() +
							this.curColor.name.slice(1) +
							', ' +
							this.curSize.name,
						price: saledPrice
					};
				} else {
					saledProduct = {
						...this.product,
						qty: this.qty,
						price: this.product.sale_price
							? this.product.sale_price
							: this.product.price
					};
				}

				this.addToCart({ product: saledProduct });
			}
		},
		addWishlist: function(e) {
			e.currentTarget.classList.add('load-more-overlay', 'loading');

			setTimeout(() => {
				this.addToWishlist({ product: this.product });
				document
					.querySelector('.wishlist-popup')
					.classList.add('active');

				setTimeout(() => {
					document
						.querySelector('.wishlist-popup')
						.classList.remove('active');
				}, 1000);
			}, 1000);
		},
		isDisabled: function(color, size) {
			if (!color.name || !size.name) return false;

			if (this.vSizes.length === 0) {
				return (
					this.product.variants.findIndex(
						item => item.colors[0].color_name === color.name
					) === -1
				);
			}

			if (this.vColors.length === 0) {
				return (
					this.product.variants.findIndex(
						item => item.size[0].size_name === size.name
					) === -1
				);
			}

			return (
				this.product.variants.findIndex(
					item =>
						item.colors[0].color_name === color.name &&
						item.size[0].size_name === size.name
				) === -1
			);
		},
		toggleColorItem: function(color) {
			if (!this.isDisabled(color, this.curSize)) {
				if (this.curColor === color) {
					this.curColor = { name: null, text: null, image: null };
				} else {
					this.curColor = color;
				}
			}
		},
		toggleSizeItem: function(size) {
			if (!this.isDisabled(this.curColor, size)) {
				if (this.curSize === size) {
					this.curSize = { name: null, text: null, image: null };
				} else {
					this.curSize = size;
				}
			}
		},
		resetValue() {
			this.curColor = { name: null, text: null, image: null };
			this.curSize = { name: null, text: null, image: null };
		},
		changeQty(e) {}
	}
};
</script>
