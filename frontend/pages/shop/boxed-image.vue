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
					<li class="breadcrumb-item active">Shop</li>
				</ol>
			</div>
		</nav>
		<div class="container">
			<div class="row">
				<div class="col-lg-9 main-content">
					<div class="category-banner pt-0 pb-2">
						<img
							class="slide-bg"
							:src="'./images/home/banners/banner-1.jpg'"
							alt="banner"
							width="1500"
							height="320"
							style="background: #e8e2e2"
						/>
						<div class="category-slide-content pt-1">
							<h2 class="m-b-3">Winter Fashion Trends</h2>
							<h3 class="text-uppercase ml-0">Up to 30% off on Jackets</h3>

							<h5 class="text-uppercase d-inline-block mb-1 pb-2">
								Starting at<span class="coupon-sale-text font2">
									<sup>$</sup>199<sup>99</sup>
								</span>
							</h5>
							<a
								href="javascript:;"
								class="btn btn-dark btn-xl ls-0"
								role="button"
							>Shop Now</a>
						</div>
					</div>

					<pv-product-list-one
						:category-list="categoryList"
						:itemsPerRow="5"
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
							v-if="featuredProducts.length > 0"
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
import PvShopBanner from '~/components/partials/shop/PvShopBanner';
import Api, { baseUrl, currentDemo } from '~/api';
import { baseSlider6 } from '~/utils/data/carousel';

export default {
	directives: {
		Sticky
	},
	components: {
		PvSidebarFilterOne,
		PvProductListOne,
		PvShopBanner
	},
	data: function() {
		return {
			categoryList: [],
			featuredProducts: [],
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