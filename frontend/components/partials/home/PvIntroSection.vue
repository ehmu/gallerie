<template>

  <pv-carousel
    class="home-slider slide-animate nav-big show-nav-hover"
    :options="IntroSlider"
    v-animate v-if="categories && categories.length > 0"
  >

    <div v-for="(category, index) in categories" :key="category.id" class="home-slide home-slide1 banner d-flex align-items-center swiper-slide">
      <img
        class="slide-bg"
        :src="baseUrl + '/dokumente/downloadDokument/' + category.products[0].imageUuids[0]"
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
        <h2>{{category.name}}</h2>
        <h3 class="text-uppercase mb-0">{{category.description}}</h3>
        <h4 class="m-b-4">{{category.name}}</h4>

        <h5 class="text-uppercase">
          Starting at<span class="coupon-sale-text">
						{{category.description}}
					</span>
        </h5>
        <nuxt-link
          to="/shop"
          class="btn btn-dark btn-xl"
          role="button"
        >Mehr anzeigen</nuxt-link>
      </div>
    </div>



  </pv-carousel>
</template>

<script>
import PvCarousel from '~/components/features/PvCarousel';
import { IntroSlider } from '~/utils/data/carousel';
import { baseUrl } from '~/api';

export default {
	components: {
		PvCarousel
	},
  props: {
    categories: Array
  },
	data: function() {
		return {
			IntroSlider: IntroSlider,
      baseUrl: baseUrl
		};
	}
};
</script>
