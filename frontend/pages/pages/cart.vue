<template>
	<div class="container">
		<ul class="checkout-progress-bar d-flex justify-content-center flex-wrap">
			<li class="active">
				<a href="javascript:;">Merkliste</a>
			</li>
			<li>
				<nuxt-link to="/pages/checkout">Anfrage stellen</nuxt-link>
			</li>
			<li class="disabled">
				<a href="javascript:;">Fertig</a>
			</li>
		</ul>

		<div
			class="row"
			v-if="cartList.length > 0"
			key="noEmpty"
		>
			<div class="col-lg-8">
				<div class="cart-table-container">
					<table class="table table-cart">
						<thead>
							<tr>
								<th class="thumbnail-col"></th>
								<th class="product-col">Name</th>
								<th class="price-col">Beschreibung</th>
								<th class="qty-col"></th>
								<th class="text-right"></th>
							</tr>
						</thead>

						<tbody>
							<tr
								class="product-row"
								v-for="(product,index) in cartItems"
								:key="'cart-product-' + index"
							>
								<td>
									<figure class="product-image-container">
										<nuxt-link
											:to="'/product/default/' + product.slug"
											class="product-image"
										>
											<img
												:src="`${baseUrl}${product.imagePaths[0]}`"
												:width="100"
												:height="100"
												alt="product"
											/>
										</nuxt-link>

										<a
											href="javascript:;"
											class="btn-remove icon-cancel"
											title="Remove Product"
											@click="removeFromCart({name: product.name})"
										></a>
									</figure>
								</td>

								<td class="product-col">
									<h5 class="product-title">
										<nuxt-link :to="'/product/default/' + product.slug">{{ product.name }}</nuxt-link>
									</h5>
								</td>

                <td colspan="3">{{ product.description }}</td>

								<!--td>{{ product.price | priceFormat }}</td>

								<td>
									<pv-quantity-input
										:qty="product.qty"
										:product="product"
										@changeQty="changeQty"
									></pv-quantity-input>
								</td>

								<td class="text-right">
									<span class="subtotal-price">{{ product.price * product.qty | priceFormat }}</span>
								</td-->
							</tr>
						</tbody>

						<tfoot>
							<tr>
								<td
									colspan="5"
									class="clearfix"
								>
									<!--div class="float-left">
										<div class="cart-discount">
											<form action="#">
												<div class="input-group">
													<input
														type="text"
														class="form-control form-control-sm"
														placeholder="Coupon Code"
														required
													/>
													<div class="input-group-append">
														<button
															class="btn btn-sm"
															type="submit"
														>
															Apply
															Coupon
														</button>
													</div>
												</div>
											</form>
										</div>
									</div-->

									<!--div class="float-right">
										<button
											type="submit"
											class="btn btn-shop btn-update-cart"
											@click="updateCart({cartItems: cartItems})"
										>Update Cart</button>
									</div-->
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="cart-summary">
					<h4>WOLLEN SIE MEHR WISSEN?</h4>
          Falls Sie Interesse an meinen Bildern haben und Kontakt mit mir aufnehmen möchten,
          können Sie mir gerne Ihre Auswahl schicken. Klicken Sie hierfür auf "Anfrage stellen"
          und geben Sie anschließend Ihre Kontaktdaten ein. <br>
          Ich melde mich schnellstmöglich bei Ihnen!

					<table class="table table-totals">
						<!--tbody>
							<tr>
								<td>Total</td>
								<td>${{ totalPrice | priceFormat }}</td>
							</tr>

							<tr>
								<td
									colspan="2"
									class="text-left"
								>
									<h4>Shipping</h4>

									<div class="form-group form-group-custom-control">
										<div class="custom-control custom-radio">
											<input
												type="radio"
												class="custom-control-input"
												name="radio"
												checked
											/>
											<label class="custom-control-label">Local pickup</label>
										</div>
									</div>

									<div class="form-group form-group-custom-control mb-0">
										<div class="custom-control custom-radio mb-0">
											<input
												type="radio"
												name="radio"
												class="custom-control-input"
											/>
											<label class="custom-control-label">Flat rate</label>
										</div>
									</div>

									<form action="#">
										<div class="form-group form-group-sm">
											<label>
												Shipping to
												<strong>NY.</strong>
											</label>
											<div class="select-custom">
												<select class="form-control form-control-sm">
													<option value="USA">United States (US)</option>
													<option value="Turkey">Turkey</option>
													<option value="China">China</option>
													<option value="Germany">Germany</option>
												</select>
											</div>
										</div>

										<div class="form-group form-group-sm">
											<div class="select-custom">
												<select class="form-control form-control-sm">
													<option value="NY">New York</option>
													<option value="CA">California</option>
													<option value="TX">Texas</option>
												</select>
											</div>
										</div>

										<div class="form-group form-group-sm">
											<input
												type="text"
												class="form-control form-control-sm"
												placeholder="Town / City"
											/>
										</div>

										<div class="form-group form-group-sm">
											<input
												type="text"
												class="form-control form-control-sm"
												placeholder="ZIP"
											/>
										</div>

										<button
											type="submit"
											class="btn btn-shop btn-update-total"
										>Update Totals</button>
									</form>
								</td>
							</tr>
						</tbody-->

						<!--tfoot>
							<tr>
								<td>Total</td>
								<td>{{ totalPrice | priceFormat }}</td>
							</tr>
						</tfoot-->
					</table>

					<div class="checkout-methods">
						<nuxt-link
							to="/pages/checkout"
							class="btn btn-block btn-dark"
						>
							Anfrage stellen
							<i class="fa fa-arrow-right"></i>
						</nuxt-link>
					</div>
				</div>
			</div>
		</div>

		<div
			class="box-content"
			v-else
		>
			<table
				class="table-cart"
				data-pagination="no"
				data-per-page="5"
				data-page="1"
				data-id
				data-token
			>
				<thead class="d-none">
					<tr>
						<th class="product-thumbnail"></th>

						<th class="product-name">
							<span class="nobr">Product</span>
						</th>

						<th class="product-price">
							<span class="nobr">price</span>
						</th>

						<th class="product-stock-status">
							<span class="nobr">Stock status</span>
						</th>

						<th class="product-add-to-cart">
							<span class="nobr">Actions</span>
						</th>
					</tr>
				</thead>

				<tbody class="cart-items-wrapper">
					<tr class="border-0 py-0">
						<td
							colspan="6"
							class="px-3 py-2 text-center"
						>
							<i class="icon-wishlist-2 cart-empty"></i>
						</td>
					</tr>
					<tr class="border-0 py-0">
						<td
							colspan="6"
							class="px-3 py-2 text-center cart-empty"
						>
							Die Liste ist leer
						</td>
					</tr>
					<tr class="border-0 py-0">
						<td
							colspan="6"
							class="px-3 text-center"
						>
							<nuxt-link
								to="/shop"
								class="btn btn-go-shop"
							>Zur Bildergallerie</nuxt-link>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="mb-6"></div>
	</div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import { baseUrl } from '~/api/index';
import PvQuantityInput from '~/components/features/PvQuantityInput';

export default {
	components: {
		PvQuantityInput
	},
	data: function() {
		return {
			baseUrl: baseUrl,
			cartItems: []
		};
	},
	computed: {
		...mapGetters('cart', ['cartList', 'totalPrice'])
	},
	watch: {
		cartList: function() {
			this.cartItems = this.cartList;
		}
	},
	created: function() {
		this.cartItems = [...this.cartList];
	},
	methods: {
		...mapActions('cart', ['updateCart', 'removeFromCart']),
		changeQty: function(value, product) {
			this.cartItems = this.cartItems.reduce((acc, cur) => {
				if (cur.name === product.name) {
					return [
						...acc,
						{
							...cur,
							qty: value
						}
					];
				} else {
					return [...acc, cur];
				}
			}, []);
		}
	}
};
</script>
