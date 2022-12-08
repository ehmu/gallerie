<template>
	<section class="container pb-3 mb-1">
		<h2 class="section-title ls-n-15 text-center pb-2 m-b-4">Popular Products</h2>

		<div
			class="row py-4"
			v-if="products.length === 0"
		>
			<div
				class="col-6 col-sm-4 col-md-3 col-xl-2 mb-2"
				v-for="(item) in [1,2,3,4,5,6,7,8,9,10,11,12]"
				:key="'featured' + item"
			>
				<div class="product-loading-overlay"></div>
			</div>
		</div>

		<div class="row py-4">
			<div
				class="col-6 col-sm-4 col-md-3 col-xl-2 appear-animate"
				data-animation-name="fadeIn"
				data-animation-delay="100"
				data-animation-duration="1000"
				v-for="(product,index) in products"
				:key="'featured' + index"
				v-animate
			>
				<pv-product-three :product="product"></pv-product-three>
			</div>
		</div>

		<hr class="mt-3 mb-6" />

		<div class="row feature-boxes-container pt-2">
			<div
				class="col-sm-6 col-lg-3 appear-animate"
				data-animation-name="fadeInRightShorter"
				data-animation-delay="300"
				data-animation-duration="1000"
				v-animate
			>
				<div class="feature-box feature-box-simple text-center">
					<i class="sicon-earphones-alt"></i>

					<div class="feature-box-content p-0">
						<h3 class="text-uppercase">Customer Support</h3>
						<h5>Need Assistence?</h5>

						<p>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec vestibulum magna,
							et dapibus lacus. Lorem ipsum dolor sit amet.
						</p>
					</div>
				</div>
			</div>

			<div
				class="col-sm-6 col-lg-3 appear-animate"
				data-animation-name="fadeInRightShorter"
				data-animation-delay="100"
				data-animation-duration="1000"
				v-animate
			>
				<div class="feature-box feature-box-simple text-center">
					<i class="sicon-credit-card"></i>

					<div class="feature-box-content p-0">
						<h3 class="text-uppercase">Secured Payment</h3>
						<h5>Safe & Fast</h5>

						<p>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec vestibulum magna,
							et dapibus lacus. Lorem ipsum dolor sit amet.
						</p>
					</div>
				</div>
			</div>

			<div
				class="col-sm-6 col-lg-3 appear-animate"
				data-animation-name="fadeInLeftShorter"
				data-animation-delay="100"
				data-animation-duration="1000"
				v-animate
			>
				<div class="feature-box feature-box-simple text-center">
					<i class="sicon-action-undo"></i>

					<div class="feature-box-content p-0">
						<h3 class="text-uppercase">Free Returns</h3>
						<h5>Easy & Free</h5>

						<p>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec vestibulum magna,
							et dapibus lacus. Lorem ipsum dolor sit amet.
						</p>
					</div>
				</div>
			</div>

			<div
				class="col-sm-6 col-lg-3 appear-animate"
				data-animation-name="fadeInLeftShorter"
				data-animation-delay="300"
				data-animation-duration="1000"
				v-animate
			>
				<div class="feature-box feature-box-simple text-center">
					<i class="icon-shipping"></i>

					<div class="feature-box-content p-0">
						<h3 class="text-uppercase">Free Shipping</h3>
						<h5>Orders Over $99</h5>

						<p>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec vestibulum magna,
							et dapibus lacus. Lorem ipsum dolor sit amet.
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
</template>

<script>
import PvCarousel from '~/components/features/PvCarousel';
import PvProductThree from '~/components/features/product/PvProductThree';
import { baseSlider3 } from '~/utils/data/carousel';

export default {
	components: {
		PvCarousel,
		PvProductThree
	},
	props: {
		products: Array
	},
	data: function() {
		return {
			baseSlider3: baseSlider3
		};
	}
};
</script>