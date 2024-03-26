<template>
	<main class="main main-test">
		<div class="container checkout-container">
			<ul class="checkout-progress-bar d-flex justify-content-center flex-wrap">
				<li>
					<nuxt-link to="/pages/cart">Merkzettel</nuxt-link>
				</li>
				<li class="active">
					<nuxt-link to="/pages/checkout">Anfrage stellen</nuxt-link>
				</li>
				<li  class="active">
					<a href="javascript:;">Bestätigung</a>
				</li>
			</ul>

			<template v-if="cartList.length > 0">

			</template>

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
								<p class="noproduct-msg mb-2">Keine Bilder auf dem Merkzettel vorhanden.</p>
								<i class="icon-wishlist-2 cart-empty"></i>
							</td>
						</tr>
						<tr class="border-0 py-0">
							<td
								colspan="6"
								class="px-3 py-2 text-center wishlist-empty"
							>

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
								>ZUR BILDERGALLERIE</nuxt-link>
							</td>
						</tr>
					</tbody>
				</table>

				<div class="mb-6"></div>
			</div>
		</div>
	</main>
</template>

<script>
import { VueSlideToggle } from 'vue-slide-toggle';
import { mapGetters } from 'vuex';

export default {
	components: {
		VueSlideToggle
	},
	data: function() {
		return {
			loginOpened: false,
			codeOpened: false,
			accountOpened: false,
			addressOpened: false
		};
	},
	computed: {
		...mapGetters('cart', ['cartList', 'totalCount', 'totalPrice'])
	}
};
</script>
