<template>
	<pv-carousel
		class="home-slider slide-animate nav-big show-nav-hover"
		:options="IntroSlider"
		v-animate
	>
		<div class="home-slide home-slide1 banner d-flex align-items-center swiper-slide">
			<img
				class="slide-bg"
				:src="'./images/home/slider/slide1.jpg'"
				alt="slider image"
				width="1903"
				height="970"
				image-ratio="50.9"
				style="background: #f7f5f8"
			/>
			<div
				class="banner-layer appear-animate"
				data-animation-name="fadeInUpShorter"
				v-animate
			>
				<h2>Winter Fashion Trends</h2>
				<h3 class="text-uppercase mb-0">Get up to 50% off</h3>
				<h4 class="m-b-4">on Jackets</h4>

				<h5 class="text-uppercase">
					Starting at<span class="coupon-sale-text">
						<sup>$</sup>199<sup>99</sup>
					</span>
				</h5>
				<nuxt-link
					to="/shop"
					class="btn btn-dark btn-xl"
					role="button"
				>Shop Now</nuxt-link>
			</div>
		</div>

		<div class="home-slide home-slide2 banner d-flex align-items-center swiper-slide">
			<img
				class="slide-bg"
				:src="'./images/home/slider/slide2.jpg'"
				alt="slider image"
				width="1903"
				height="970"
				image-ratio="50.9"
				style="background: #f7f5f8"
			/>
			<div
				class="banner-layer appear-animate"
				data-animation-name="fadeInUpShorter"
			>
				<h2>New Season Hats</h2>
				<h3 class="text-uppercase rotated-upto-text mb-0">
					<small>Up to</small>20% off
				</h3>

				<hr class="short-thick-divider mb-sm-0 mb-1" />

				<h5 class="text-uppercase d-inline-block mb-2 mb-sm-0">
					Starting at <span>$<em>19</em>99</span>
				</h5>
				<nuxt-link
					to="/shop"
					class="btn btn-dark btn-xl btn-icon-right"
					role="button"
				>
					Shop Now
					<i class="fas fa-long-arrow-alt-right"></i>
				</nuxt-link>
			</div>
		</div>
	</pv-carousel>
</template>

<script>
import PvCarousel from '~/components/features/PvCarousel';
import { IntroSlider } from '~/utils/data/carousel';

export default {
	components: {
		PvCarousel
	},
	data: function() {
		return {
			IntroSlider: IntroSlider
		};
	}
};
</script>
