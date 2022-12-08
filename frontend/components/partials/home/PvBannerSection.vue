<template>
	<section class="bg-gray banners-section text-center">
		<div class="container py-2">
			<div class="row">
				<div
					class="col-sm-6 col-lg-3 appear-animate"
					data-animation-name="fadeInLeftShorter"
					data-animation-delay="100"
					data-animation-duration="1000"
					v-animate
				>
					<div class="home-banner banner banner-sm-vw mb-2">
						<img
							v-lazy="'./images/home/banners/home-banner1.jpg'"
							width="419"
							height="629"
							image-ratio="150.12"
							alt="Banner"
							style="background: #e8e2e2"
						/>
						<div class="banner-layer banner-layer-bottom text-left">
							<h3 class="m-b-2">Sunglasses Sale</h3>
							<h4 class="m-b-3">See all and find yours</h4>
							<nuxt-link
								to="/shop"
								class="btn btn-dark"
								role="button"
							>Shop By Glasses</nuxt-link>
						</div>
					</div>
				</div>

				<div
					class="col-sm-6 col-lg-3 appear-animate"
					data-animation-name="fadeInLeftShorter"
					data-animation-delay="300"
					data-animation-duration="1000"
					v-animate
				>
					<div class="home-banner banner banner-sm-vw mb-2">
						<img
							v-lazy="'./images/home/banners/home-banner2.jpg'"
							width="419"
							height="629"
							image-ratio="150.12"
							alt="Banner"
							style="background: #fff"
						/>
						<div class="banner-layer banner-layer-top">
							<h3 class="mb-0">Cosmetics Trends</h3>
							<h4 class="m-b-4">Browse in all our categories</h4>
							<nuxt-link
								to="/shop"
								class="btn btn-dark"
								role="button"
							>Shop By Glasses</nuxt-link>
						</div>
					</div>
				</div>

				<div
					class="col-sm-6 col-lg-3 appear-animate"
					data-animation-name="fadeInLeftShorter"
					data-animation-delay="500"
					data-animation-duration="1000"
					v-animate
				>
					<div class="home-banner banner banner-sm-vw mb-2">
						<img
							v-lazy="'./images/home/banners/home-banner3.jpg'"
							width="419"
							height="629"
							image-ratio="150.12"
							alt="Banner"
							style="background: #302e2f"
						/>
						<div class="banner-layer banner-layer-middle">
							<h3 class="text-white m-b-1">Fashion Summer Sale</h3>
							<h4 class="text-white m-b-4">Browse in all our categories</h4>
							<nuxt-link
								to="/shop"
								class="btn btn-light bg-white"
								role="button"
							>Shop By Fashion</nuxt-link>
						</div>
					</div>
				</div>

				<div
					class="col-sm-6 col-lg-3 appear-animate"
					data-animation-name="fadeInLeftShorter"
					data-animation-delay="700"
					data-animation-duration="1000"
					v-animate
				>
					<div class="home-banner banner banner-sm-vw mb-2">
						<img
							v-lazy="'./images/home/banners/home-banner4.jpg'"
							width="419"
							height="629"
							image-ratio="150.12"
							alt="Banner"
							style="background: #fff"
						/>
						<div class="banner-layer banner-layer-bottom banner-layer-boxed">
							<h3 class="m-b-2">UP TO 70% IN ALL BAGS</h3>
							<h4>Starting at $99</h4>
							<nuxt-link
								to="/shop"
								class="btn btn-dark"
								role="button"
							>Shop By Bags</nuxt-link>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</template>

<script>
export default {};
</script>