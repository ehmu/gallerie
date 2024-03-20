<template>
	<div class="sidebar-wrapper border-0">
		<div
			class="sidebar-content skeleton-body"
			v-if="categoryList.length === 0"
		>
			<aside class="widget"></aside>
		</div>

		<div
			class="widget widget-product-categories"
			v-else
		>
			<h3 class="widget-title">
				<a
					data-toggle="collapse"
					href="javascript:;"
					@click="catOpened = !catOpened"
					:class="{'collapsed': !catOpened}"
				>Kategorien</a>
			</h3>

			<vue-slide-toggle :open="catOpened">
				<div class="widget-body">
					<vue-tree-list
						:model="categoryTree"
						:default-expanded="false"
					>
						<template v-slot:leafNameDisplay="slotProps">
							<nuxt-link
								:to="{path: $route.path, query: {category: slotProps.model.slug, page: 1}}"
								:class="{active: slotProps.model.slug === currentCategory}"
							>
								{{ slotProps.model.name }}
								<span class="products-count">({{ slotProps.model.counts }})</span>
							</nuxt-link>
						</template>
						<template v-slot:treeNodeIcon>
							<span></span>
						</template>
					</vue-tree-list>
				</div>
			</vue-slide-toggle>
		</div>

		<vue-slide-toggle :open="!isEmptyQuery">
			<div class="widget">
				<nuxt-link
					:to="{path: $router.path}"
					class="btn btn-primary reset-filter-btn router-link-active"
				>Alle Filter zurücksetzen</nuxt-link>
			</div>
		</vue-slide-toggle>

		<div class="widget widget-color">
			<h3 class="widget-title">
				<a
					data-toggle="collapse"
					href="javascript:;"
					@click="colorOpened = !colorOpened"
					:class="{'collapsed': !colorOpened}"
				>Farben</a>
			</h3>

			<vue-slide-toggle :open="colorOpened">
				<div class="widget-body pb-0">
					<ul class="config-swatch-list flex-column">
						<li
							v-for="(item,index) in shopColors"
							:key="'color-filter' + index"
							:class="{active: isActivedColor(item)}"
						>
							<nuxt-link
								:to="colorFilterRoute(item)"
								:style="{backgroundColor: item.color}"
							>
							</nuxt-link>
							<nuxt-link :to="colorFilterRoute(item)">
								<span>{{item.name[0].toUpperCase()}}{{item.name.substr(1)}}</span>
							</nuxt-link>
						</li>
					</ul>
				</div>
			</vue-slide-toggle>
		</div>

		<div class="widget widget-size">
			<h3 class="widget-title">
				<a
					href="javascript:;"
					@click="sizeOpened = !sizeOpened"
					:class="{'collapsed': !sizeOpened}"
				>Größen</a>
			</h3>

			<vue-slide-toggle :open="sizeOpened">
				<div class="widget-body pb-0">
					<ul class="config-size-list">
						<li
							v-for="(item,index) in shopSizes"
							:key="'size-filter' + index"
							:class="{active: isActivedSize(item)}"
						>
							<nuxt-link :to="sizeFilterRoute(item)">{{ item.name }}</nuxt-link>
						</li>
					</ul>
				</div>
			</vue-slide-toggle>
		</div>


		<!-- <div
			class="widget widget-featured"
			v-if="isFeatured"
		>
			<h3 class="widget-title">Featured</h3>

			<div class="widget-body">
				<pv-carousel
					class="widget-featured-products"
					:options="baseSlider1"
				>
					<div class="featured-col swiper-slide">
						<pv-small-product
							:product="product"
							v-for="(product,index) in featuredProducts"
							:key="'featured' + index"
							:is-lazy="false"
						></pv-small-product>
					</div>

					<div class="featured-col swiper-slide">
						<pv-small-product
							:product="product"
							v-for="(product,index) in featuredProducts"
							:key="'featured' + index"
							:is-lazy="false"
						></pv-small-product>
					</div>
				</pv-carousel>
			</div>
		</div> -->

		<!-- <div
			class="widget widget-block"
			v-if="isFeatured"
		>
			<h3 class="widget-title">Custom HTML Block</h3>
			<h5>This is a custom sub-title.</h5>
			<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras non placerat mi. Etiam
				non tellus
			</p>
		</div> -->
	</div>
</template>

<script>
import { VueSlideToggle } from 'vue-slide-toggle';
import { VueTreeList, Tree } from 'vue-tree-list';
import PvCarousel from '~/components/features/PvCarousel';
import PvSmallProduct from '~/components/features/product/PvSmallProduct';
import { shopColors, shopSizes, shopBrands } from '~/utils/data/shop';
import { baseSlider1 } from '~/utils/data/carousel';

export default {
	components: {
		VueSlideToggle,
		VueTreeList,
		PvSmallProduct,
		PvCarousel
	},
	props: {
		categoryList: Array,
		featuredProducts: Array,
    shopColors: Array,
    shopSizes: Array
	},
	data: function() {
		return {
			catOpened: true,
			priceOpenened: true,
			sizeOpened: true,
			colorOpened: true,
			brandOpened: true,
			prices: [0, 1000],
			priceSettings: {
				connect: true,
				step: 50,
				margin: 100,
				range: {
					min: 0,
					max: 1000
				}
			},
			//shopColors: shopColors,
			//shopSizes: shopSizes,
			shopBrands: shopBrands,
			baseSlider1: baseSlider1,
			emptyObject: {},
			isFeatured: true,
			priceReset: true,
			currentCategory: ''
		};
	},
	watch: {
		$route: function() {console.log("fsfsw")
			this.getFlag();

			if (this.$route.query.min_price) {
				this.prices = [
					this.$route.query.min_price,
					this.$route.query.max_price
				];
			} else {
				this.prices = [0, 1000];
			}

			this.priceReset = false;

			this.currentCategory = this.$route.query.category;

			this.$nextTick(function() {
				this.priceReset = true;
			});
		}
	},
	created: function() {
		this.getFlag();

    if (this.$route.query.category) {
      this.currentCategory = this.$route.query.category;
    }

		if (this.$route.query.min_price) {
			this.prices = [
				this.$route.query.min_price,
				this.$route.query.max_price
			];
		} else {
			this.prices = [0, 1000];
		}
	},
	computed: {
		categoryTree: function() {
			return new Tree(this.categoryList);
		},
		priceFilterRoute: function() {
			return {
				path: this.$route.path,
				query: {
					...this.$route.query,
					page: 1,
					max_price: this.prices[1],
					min_price: this.prices[0]
				}
			};
		},
		isEmptyQuery: function() {
			return Object.entries(this.$route.query).length === 0;
		}
	},
	methods: {
		colorFilterRoute: function(item) {
			let selectedColors = this.$route.query.color
				? this.$route.query.color.split(',')
				: [];
			let index = selectedColors.indexOf(item.key);
			if (index > -1) {
				selectedColors.splice(index, 1);
			} else {
				selectedColors.push(item.key);
			}

			return {
				path: this.$route.path,
				query: {
					...this.$route.query,
					page: 1,
					color: selectedColors.toString()
				}
			};
		},
		sizeFilterRoute: function(item) {
			let selectedSizes = this.$route.query.size
				? this.$route.query.size.split(',')
				: [];
			let index = selectedSizes.indexOf(item.key);
			if (index > -1) {
				selectedSizes.splice(index, 1);
			} else {
				selectedSizes.push(item.key);
			}

			return {
				path: this.$route.path,
				query: {
					...this.$route.query,
					size: selectedSizes.toString(),
					page: 1
				}
			};
		},
		brandFilterRoute: function(item) {
			let selectedBrands = this.$route.query.brand
				? this.$route.query.brand.split(',')
				: [];
			let index = selectedBrands.indexOf(item.name);
			if (index > -1) {
				selectedBrands.splice(index, 1);
			} else {
				selectedBrands.push(item.name);
			}

			return {
				path: this.$route.path,
				query: {
					...this.$route.query,
					brand: selectedBrands.toString(),
					page: 1
				}
			};
		},
		isActivedColor: function(item) {
			return (
				this.$route.query.color &&
				this.$route.query.color.split(',').includes(item.key)
			);
		},
		isActivedSize: function(item) {
			return (
				this.$route.query.size &&
				this.$route.query.size.split(',').includes(item.key)
			);
		},
		isActivedBrand: function(item) {
			return (
				this.$route.query.brand &&
				this.$route.query.brand.split(',').includes(item.name)
			);
		},
		getFlag: function() {
			if (this.$route.path.includes('horizontal-filter-1'))
				this.isFeatured = false;
		}
	}
};
</script>
