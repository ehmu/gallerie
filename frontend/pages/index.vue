<template>
	<main class="main home">
		<pv-intro-section></pv-intro-section>

		<pv-category-section
      :gallerien="gallerien"
    ></pv-category-section>

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
		PvCategorySection
	},
	data: function() {
		return {
		  gallerien: [],
			posts: []
		};
	},



	mounted: function() {
		Api.get(`${baseUrl}/gallerie/gallerien?onlyActive=true`)
			.then(response => {
				this.gallerien = response.data.gallerien;
				this.posts = response.data.posts;

			})
			.catch(error => ({ error: JSON.stringify(error) }));

	},
	destroyed: function() {
		clearTimeout(this.timerId);
	}
};
</script>
