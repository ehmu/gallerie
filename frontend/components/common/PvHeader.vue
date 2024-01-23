<template>
	<header
		class="header"
		:class="$route.path === '/' ? 'header-transparent' : ''"
	>
		<div class="header-middle sticky-header">
			<div class="container">
				<div class="header-left">
					<button
						class="mobile-menu-toggler mr-2"
						type="button"
						@click="showMobileMenu"
					>
						<i class="fas fa-bars"></i>
					</button>
					<nuxt-link
						to="/"
						class="logo"
					>
						<img
							:src="'./images/logo-black.png'"
							width="101"
							height="40"
							alt="Porto Logo"
						/>
					</nuxt-link>

					<pv-main-menu></pv-main-menu>
				</div>

				<div class="header-right">
					<pv-header-search></pv-header-search>

					<a
						href="javascript:;"
						@click="openLoginModal"
						class="header-icon header-icon-user"
						title="login"
					>
						<i class="icon-user-2"></i>
					</a>

					<nuxt-link
						to="/pages/wishlist"
						class="header-icon"
						title="wishlist"
					>
						<i class="icon-wishlist-2"></i>
					</nuxt-link>

					<pv-cart-menu></pv-cart-menu>
				</div>
			</div>
		</div>
	</header>
</template>

<script>
import PvMainMenu from '~/components/common/partials/PvMainMenu';
import PvCartMenu from '~/components/common/partials/PvCartMenu';
import PvHeaderSearch from '~/components/common/partials/PvHeaderSearch';

document.querySelector('body').classList.add('loaded');

export default {
	components: {
		PvMainMenu,
		PvCartMenu,
		PvHeaderSearch
	},
	data: function() {
		return {
			isHome: {
				type: Boolean,
				default: true
			}
		};
	},
	methods: {
		openLoginModal: function() {
			this.$modal.show(
				() => import('~/components/features/modal/PvLoginModal'),
				{},
				{ width: '525', height: 'auto', adaptive: true }
			);
		},
		showMobileMenu: function() {
			document.querySelector('body').classList.add('mmenu-active');
		},
		showMobileSearch: function(e) {
			let headerSearch = e.currentTarget.closest('.header-search');
			headerSearch.classList.add('show');
			headerSearch
				.querySelector('.header-search-wrapper')
				.classList.add('show');
		}
	}
};
</script>
