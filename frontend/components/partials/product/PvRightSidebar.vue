<template>
	<aside
		class="sidebar-product col-lg-3 mobile-sidebar"
		sticky-container
	>
		<div
			class="sidebar-wrapper"
			v-sticky="isSticky"
			sticky-offset="{top: 75}"
		>
			<div class="widget category-banner pt-0 pb-2 mt-0">
				<figure>
					<img
						class="slide-bg"
						src="~/static/images/home/banners/banner-sidebar.jpg"
						alt="banner"
						style="background: #e8e2e2"
						width="332"
						height="660"
					/>
				</figure>
				<div class="category-slide-content">
					<h2 class="m-b-3">Winter Fashion Trends</h2>
					<h3 class="text-uppercase ml-0">Up to 30%</h3>
					<h4 class="text-uppercase ml-0 mb-1">Off on Jackets</h4>
					<h5 class="text-uppercase d-block">Starting at</h5>
					<h3 class="coupon-sale-text font2 ml-0 mt-0">
						<sup>$</sup>199<sup>99</sup>
					</h3>
					<nuxt-link
						to="/shop"
						class="btn btn-dark btn-xl ml-0"
						role="button"
					>Shop Now</nuxt-link>
				</div>
			</div>

			<div class="widget widget-featured">
				<h3 class="widget-title">Featured</h3>

				<div class="widget-body pt-0">
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
					</pv-carousel>
				</div>
			</div>
		</div>
	</aside>
</template>

<script>
import Sticky from 'vue-sticky-directive';
import PvCarousel from '~/components/features/PvCarousel';
import PvSmallProduct from '~/components/features/product/PvSmallProduct';
import { baseSlider1 } from '~/utils/data/carousel';

export default {
	components: {
		PvSmallProduct,
		PvCarousel
	},
	directives: {
		Sticky
	},
	props: {
		featuredProducts: Array
	},
	data: function() {
		return {
			isSticky: false,
			baseSlider1: baseSlider1
		};
	},
	computed: {
		categoryTree: function() {
			return new Tree(this.categoryList);
		}
	},
	mounted: function() {
		this.resizeHandler();
		window.addEventListener('resize', this.resizeHandler, {
			passive: true
		});
	},
	destroyed: function() {
		window.removeEventListener('resize', this.resizeHandler);
	},
	methods: {
		resizeHandler: function() {
			this.isSticky = window.innerWidth > 991 ? true : false;
		}
	}
};
</script>