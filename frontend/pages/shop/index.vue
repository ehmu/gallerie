<template>
	<main class="main skeleton-body">
		<nav
			aria-label="breadcrumb"
			class="breadcrumb-nav"
		>

			<div class="container">
				<ol class="breadcrumb">
					<li class="breadcrumb-item">
						<nuxt-link to="/">Home</nuxt-link>
					</li>
					<li class="breadcrumb-item active">Bilder</li>
				</ol>
			</div>
		</nav>
		<div class="container">
			<div class="row">
				<div class="col-lg-9 main-content">

					<pv-product-list-one
						:category-list="categoryList"
						:itemsPerRow="3"
					></pv-product-list-one>
				</div>

				<div
					class="sidebar-overlay"
					@click="hideSidebar"
				></div>
				<aside
					class="sidebar-shop col-lg-3 order-lg-first mobile-sidebar"
					sticky-container
				>
					<div
						v-sticky="isSticky"
						sticky-offset="{top: 75}"
					>
						<pv-sidebar-filter-one
							:category-list="categoryList"
							:featured-products="featuredProducts"
              :shopSizes="shopSizes"
              :shop-colors="shopColors"
						></pv-sidebar-filter-one>

						<div
							class="sidebar-content skeleton-body"
							v-if="featuredProducts.length === 0"
						>
							<aside class="widget"></aside>
							<aside class="widget"></aside>
							<aside class="widget"></aside>
						</div>
					</div>
				</aside>
			</div>

			<div class="mb-4"></div>
		</div>
	</main>
</template>

<script>
import { VueTreeList, Tree } from 'vue-tree-list';
import Sticky from 'vue-sticky-directive';
import PvCarousel from '~/components/features/PvCarousel';
import PvSidebarFilterOne from '~/components/partials/shop/sidebar-filter/PvSidebarFilterOne';
import PvProductListOne from '~/components/partials/shop/product-list/PvProductListOne';
import Api, { baseUrl, currentDemo } from '~/api';
import { baseSlider6 } from '~/utils/data/carousel';

export default {
	directives: {
		Sticky
	},
	components: {
		PvSidebarFilterOne,
		PvProductListOne,
		PvCarousel
	},
	data: function() {
		return {
			categoryList: [],
			featuredProducts: [],
      shopSizes: [],
      shopColors: [],
			baseSlider6: baseSlider6,
			isSticky: false
		};
	},
	mounted: function() {
		this.getCategoryLists();
		this.resizeHandler();
		window.addEventListener('resize', this.resizeHandler, {
			passive: true
		});
	},
	destroyed: function() {
		window.removeEventListener('resize', this.resizeHandler);
	},
	methods: {
		getCategoryLists: function() {
			Api.get(`${baseUrl}/shop/sidebar-list`, {
				params: { demo: currentDemo }
			})
				.then(response => {
					this.categoryList = response.data.sidebarList;
					this.featuredProducts = response.data.featuredProducts;
          this.shopSizes = response.data.shopSizes;
          this.shopColors = response.data.shopColors;
				})
				.catch(error => ({ error: JSON.stringify(error) }));
		},
		resizeHandler: function() {
			this.isSticky = window.innerWidth > 991 ? true : false;
		},
		hideSidebar: function() {
			document.querySelector('body').classList.remove('sidebar-opened');
		}
	}
};
</script>
