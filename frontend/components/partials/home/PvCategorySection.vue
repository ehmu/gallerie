<template>
	<section class="container">
		<h2 class="section-title ls-n-15 text-center pt-2 m-b-4">Alle Gallerien</h2>

		<pv-carousel
			class="nav-image-center show-nav-hover nav-outer cats-slider appear-animate"
			:options="categorySlider"
			data-animation-name="fadeInUpShorter"
			data-animation-delay="200"
			data-animation-duration="1000"
			v-animate v-if="categories && categories.length > 0"
		>

			<div v-for="category in categories" class="product-category mb-0 swiper-slide" v-if="categories && categories.length > 0">
				<nuxt-link :to="'/shop?category=' + category.uuid">
					<figure>
						<img
              v-lazy="baseUrl + category.products[0].imagePaths[0]"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>{{category.name}}</h3>
						<span>
							<mark class="count">{{category.products.length}}</mark> Einträge
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
import { baseUrl } from '~/api';

export default {
	components: {
		PvCarousel
	},
  props: {
    categories: []
  },
	data: function() {
		return {
			categorySlider: categorySlider,
      baseUrl: baseUrl
		};
	}
};
</script>
