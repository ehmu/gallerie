<template>
	<section class="container">
		<h2 class="section-title ls-n-15 text-center pt-2 m-b-4">Shop By Category</h2>

		<pv-carousel
			class="nav-image-center show-nav-hover nav-outer cats-slider appear-animate"
			:options="categorySlider"
			data-animation-name="fadeInUpShorter"
			data-animation-delay="200"
			data-animation-duration="1000"
			v-animate
		>
			<div class="product-category mb-0 swiper-slide">
				<nuxt-link to="/shop">
					<figure>
						<img
							v-lazy="'./images/home/categories/category-1.jpg'"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>Sunglasses</h3>
						<span>
							<mark class="count">8</mark> products
						</span>
					</div>
				</nuxt-link>
			</div>

			<div class="product-category mb-0 swiper-slide">
				<nuxt-link to="/shop">
					<figure>
						<img
							v-lazy="'./images/home/categories/category-2.jpg'"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>Bags</h3>
						<span>
							<mark class="count">4</mark> products
						</span>
					</div>
				</nuxt-link>
			</div>

			<div class="product-category mb-0 swiper-slide">
				<nuxt-link to="/shop">
					<figure>
						<img
							v-lazy="'./images/home/categories/category-3.jpg'"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>Electronics</h3>
						<span>
							<mark class="count">8</mark> products
						</span>
					</div>
				</nuxt-link>
			</div>

			<div class="product-category mb-0 swiper-slide">
				<nuxt-link to="/shop">
					<figure>
						<img
							v-lazy="'./images/home/categories/category-4.jpg'"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>Fashion</h3>
						<span>
							<mark class="count">11</mark> products
						</span>
					</div>
				</nuxt-link>
			</div>

			<div class="product-category mb-0 swiper-slide">
				<nuxt-link to="/shop">
					<figure>
						<img
							v-lazy="'./images/home/categories/category-6.jpg'"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>Headphone</h3>
						<span>
							<mark class="count">3</mark> products
						</span>
					</div>
				</nuxt-link>
			</div>

			<div class="product-category mb-0 swiper-slide">
				<nuxt-link to="/shop">
					<figure>
						<img
							v-lazy="'./images/home/categories/category-5.jpg'"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>Shoes</h3>
						<span>
							<mark class="count">4</mark> products
						</span>
					</div>
				</nuxt-link>
			</div>
		</pv-carousel>
	</section>
</template>

<script>
import PvCarousel from '~/components/features/PvCarousel';
import { categorySlider } from '~/utils/data/carousel';

export default {
	components: {
		PvCarousel
	},
	data: function() {
		return {
			categorySlider: categorySlider
		};
	}
};
</script>