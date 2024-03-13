<template>
	<section class="container">
		<h2 class="section-title ls-n-15 text-center pt-2 m-b-4">Gallierien</h2>

		<pv-carousel
			class="nav-image-center show-nav-hover nav-outer cats-slider appear-animate"
			:options="categorySlider"
			data-animation-name="fadeInUpShorter"
			data-animation-delay="200"
			data-animation-duration="1000"
			v-animate
		>

			<div v-for="gallerie in gallerien" class="product-category mb-0 swiper-slide">
				<nuxt-link to="/shop">
					<figure>
						<img
							v-lazy="baseUrl + '/dokumente/downloadDokument/' + gallerie.mainImageUuid"
							alt="category"
							width="273"
							height="273"
							style="background: #f4f4f4"
						/>
					</figure>
					<div class="category-content">
						<h3>{{gallerie.name}}</h3>
						<span>
							<mark class="count">{{gallerie.imageUuids.length}}</mark> Einträge
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
    gallerien: Object
  },
	data: function() {
		return {
			categorySlider: categorySlider,
      baseUrl: baseUrl
		};
	}
};
</script>
