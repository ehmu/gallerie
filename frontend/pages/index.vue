<template>
	<main class="main home">
		<pv-intro-section
      :categories="categories"
    ></pv-intro-section>

		<pv-category-section
      :categories="categories"
    ></pv-category-section>

	</main>
</template>

<script>
import PvIntroSection from '~/components/partials/home/PvIntroSection';
import PvCategorySection from '~/components/partials/home/PvCategorySection';

import { getCookie } from '~/utils';
import Api, { baseUrl } from '~/api';

export default {
	components: {
		PvIntroSection,
		PvCategorySection
	},
	data: function() {
		return {
      categories: [],
			posts: []
		};
	},



	mounted: function() {
		Api.get(`${baseUrl}/categories?onlyActive=true`)
			.then(response => {
				this.categories = response.data.categories;
				this.posts = response.data.posts;

			})
			.catch(error => ({ error: JSON.stringify(error) }));

	},
	destroyed: function() {
		clearTimeout(this.timerId);
	}
};
</script>
