<template>
	<main class="main home">
		<pv-intro-section></pv-intro-section>

		<pv-category-section></pv-category-section>

		<pv-banner-section></pv-banner-section>

		<pv-popular-collection
			:products="products.slice(0, 12)"
			v-if="products"
		></pv-popular-collection>
	</main>
</template>

<script>
import PvIntroSection from '~/components/partials/home/PvIntroSection';
import PvBannerSection from '~/components/partials/home/PvBannerSection';
import PvPopularCollection from '~/components/partials/home/PvPopularCollection';
import PvCategorySection from '~/components/partials/home/PvCategorySection';

import {
	getProductsByAttri,
	getTopSellingProducts,
	getTopRatedProducts
} from '~/utils/service';
import { getCookie } from '~/utils';
import Api, { baseUrl } from '~/api';

export default {
	components: {
		PvIntroSection,
		PvBannerSection,
		PvPopularCollection,
		PvCategorySection
	},
	data: function() {
		return {
			products: [],
			posts: [],
			featuredProducts: [],
			newProducts: [],
			bestProducts: [],
			topRatedProducts: []
		};
	},
	computed: {
		lightBoxMedia: function() {
			let pictures = [];
			for (let i = 0; i < this.posts.length; i++) {
				pictures.push(this.posts[i].picture[0]);
			}
			return pictures.reduce((acc, cur) => {
				return [
					...acc,
					{
						src: `${baseUrl}${cur.url}`,
						thumb: `${baseUrl}${cur.url}`
					}
				];
			}, []);
		}
	},
	mounted: function() {
		Api.get(`${baseUrl}/demo3`)
			.then(response => {
				this.products = response.data.products;
				this.posts = response.data.posts;
				this.featuredProducts = getProductsByAttri(
					response.data.products
				);
				this.newProducts = getProductsByAttri(
					response.data.products,
					'is_new'
				);
				this.bestProducts = getTopSellingProducts(
					response.data.products
				);
				this.topRatedProducts = getTopRatedProducts(
					response.data.products
				);
			})
			.catch(error => ({ error: JSON.stringify(error) }));

		this.timerId = setTimeout(() => {
			if (
				this.$route.path === '/' &&
				getCookie('newsletter') !== 'false'
			) {
				this.$modal.show(
					() =>
						import('~/components/features/modal/PvNewsletterModal'),
					{},
					{
						width: '740',
						height: 'auto',
						adaptive: true,
						class: 'newsletter-modal'
					}
				);
			}
		}, 10000);
	},
	destroyed: function() {
		clearTimeout(this.timerId);
	}
};
</script>