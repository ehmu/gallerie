<template>
    <main class="main about">
        <nav aria-label="breadcrumb" class="breadcrumb-nav">
            <div class="container">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <nuxt-link to="/">Home</nuxt-link>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">About Us</li>
                </ol>
            </div>
        </nav>

        <div class="container">
            <div class="page-header pt-3 bg-transparent">
                <div class="container text-left">
                    <h1 class="font4 text-uppercase">The New Way to Success</h1>
                </div>
            </div>

            <div class="container">
                <h2 class="page-intro font-weight-normal">Who we are</h2>
                <div class="row row-bg">
                    <div class="col-md-6">
                        <p class="mb-2">
                            Aliquam consectetur et lorem semper scelerisque. Proin est nibh, vestibulum
                            vitae congue
                            nec,
                            tristique eu justo. Maecenas eu nunc lacinia, porta lorem vitae, viverra velit. Nulla
                            dolor
                            libero, rhoncus quis luctus eu, fermentum sed leo. Morbi ut risus porttitor odio sodales
                            pulvinar. Sed gravida nulla sed sapien vulputate, eget malesuada justo egestas.
                            Pellentesque
                            sem mi, vulputate ac iaculis sit amet, sagittis feugiat dui. Proin non pellentesque leo.
                            Vestibulum varius laoreet posuere. Etiam fringilla diam odio.
                        </p>

                        <p>
                            Nulla felis nibh, bibendum a leo ut, egestas ornare felis. Nam pretium mauris justo, eget
                            commodo est fringilla vel. Proin condimentum, lacus sit amet finibus gravida, sapien
                            ligula
                            mattis leo, sit amet mattis leo lacus sit amet lectus. Nulla facilisi. Etiam porta
                            iaculis
                            velit id pulvinar. Sed dolor odio, eleifend eget aliquam vitae, efficitur vitae dolor.
                            Integer ornare neque ac leo sollicitudin, at vestibulum ante scelerisque. Nullam ut elit
                            sed
                            lorem tempus feugiat in et lectus. Mauris interdum molestie placerat. Nullam dolor nunc,
                            elementum et tincidunt id, vestibulum quis turpis. Integer imperdiet a eros a laoreet.
                            Nam
                            mattis vel ligula non imperdiet. Suspendisse potenti. Fusce purus sem, dapibus eu
                            fermentum
                            eget, aliquam vehicula ligula.
                        </p>
                    </div>

                    <div class="col-md-6">
                        <p class="mb-2">
                            Quisque congue dignissim dui sed luctus. Morbi nec mi vitae magna finibus
                            ullamcorper.
                            Etiam
                            mattis blandit convallis. Suspendisse eu elementum leo. Vestibulum molestie nunc et
                            efficitur egestas. Vivamus arcu lectus, laoreet vel consectetur bibendum, elementum non
                            nunc. Proin porttitor velit odio, ac mattis quam tincidunt eget. Fusce semper nunc eget
                            efficitur efficitur. Nam ullamcorper, enim id tincidunt feugiat, velit mauris fermentum
                            nulla, at tempor eros turpis sit amet massa. Ut a semper lectus, sed hendrerit risus. In
                            hac
                            habitasse platea dictumst. Curabitur venenatis cursus posuere. Praesent turpis nisi,
                            aliquam
                            at facilisis non, sagittis vel urna. Donec diam lorem, feugiat vitae laoreet in,
                            sagittis a
                            lorem.
                        </p>

                        <p>
                            Aliquam consectetur et lorem semper scelerisque. Proin est nibh, vestibulum vitae congue
                            nec,
                            tristique eu justo. Maecenas eu nunc lacinia, porta lorem vitae, viverra velit. Nulla
                            dolor
                            libero, rhoncus quis luctus eu, fermentum sed leo. Morbi ut risus porttitor odio sodales
                            pulvinar. Sed gravida nulla sed sapien vulputate, eget malesuada justo egestas.
                            Pellentesque
                            sem mi, vulputate ac iaculis sit amet, sagittis feugiat dui. Proin non pellentesque leo.
                            Vestibulum varius laoreet posuere. Etiam fringilla diam odio.
                        </p>
                    </div>
                </div>
            </div>

            <div class="history-section pb-3">
                <div class="container">
                    <h1 class="page-title font4">OUR HISTORY</h1>
                    <div class="row row-bg">
                        <div class="col-xl-5 col-lg-6">
                            <PvCarousel
                                class="swiper-carousel about-slider dots-simple"
                                :options="baseSlider9"
                            >
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-1.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-2.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-3.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                            </PvCarousel>
                        </div>

                        <div class="col-xl-7 col-lg-6">
                            <h2>2014</h2>
                            <p class="mb-2">
                                Aliquam consectetur et lorem semper scelerisque. Proin est nibh,
                                vestibulum vitae
                                congue
                                nec, tristique eu justo. Maecenas eu nunc lacinia, porta lorem vitae, viverra velit.
                                Nulla dolor libero, rhoncus quis luctus eu, fermentum sed leo. Morbi ut risus
                                porttitor
                                odio sodales pulvinar. Sed gravida nulla sed sapien vulputate, eget malesuada justo
                                egestas. Pellentesque sem mi, vulputate ac iaculis sit amet, sagittis feugiat dui.
                                Proin
                                non pellentesque leo. Vestibulum varius laoreet posuere. Etiam fringilla diam odio.
                            </p>

                            <p>
                                Nulla felis nibh, bibendum a leo ut, egestas ornare felis. Nam pretium mauris justo,
                                eget
                                commodo est fringilla vel. Proin condimentum, lacus sit amet finibus gravida, sapien
                                ligula mattis leo, sit amet mattis leo lacus sit amet lectus. Nulla facilisi. Etiam
                                porta iaculis velit id pulvinar. Sed dolor odio, eleifend eget aliquam vitae,
                                efficitur
                                vitae dolor. Integer ornare neque ac leo sollicitudin, at vestibulum ante
                                scelerisque.
                                Nullam ut elit sed lorem tempus feugiat in et lectus. Mauris interdum molestie
                                placerat.
                                Nullam dolor nunc, elementum et tincidunt id, vestibulum quis turpis. Integer
                                imperdiet
                                a eros a laoreet. Nam mattis vel ligula non imperdiet. Suspendisse potenti. Fusce
                                purus
                                sem, dapibus eu fermentum eget, aliquam vehicula ligula.
                            </p>
                        </div>
                    </div>

                    <div class="row row-bg">
                        <div class="col-xl-5 col-lg-6">
                            <PvCarousel
                                class="swiper-carousel about-slider dots-simple"
                                :options="baseSlider9"
                            >
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-2.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-3.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-1.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                            </PvCarousel>
                        </div>
                        <div class="col-xl-7 col-lg-6 order-lg-first">
                            <h2>2015</h2>
                            <p class="mb-2">
                                Aliquam consectetur et lorem semper scelerisque. Proin est nibh,
                                vestibulum vitae
                                congue
                                nec, tristique eu justo. Maecenas eu nunc lacinia, porta lorem vitae, viverra velit.
                                Nulla dolor libero, rhoncus quis luctus eu, fermentum sed leo. Morbi ut risus
                                porttitor
                                odio sodales pulvinar. Sed gravida nulla sed sapien vulputate, eget malesuada justo
                                egestas. Pellentesque sem mi, vulputate ac iaculis sit amet, sagittis feugiat dui.
                                Proin
                                non pellentesque leo. Vestibulum varius laoreet posuere. Etiam fringilla diam odio.
                            </p>

                            <p>
                                Nulla felis nibh, bibendum a leo ut, egestas ornare felis. Nam pretium mauris justo,
                                eget
                                commodo est fringilla vel. Proin condimentum, lacus sit amet finibus gravida, sapien
                                ligula mattis leo, sit amet mattis leo lacus sit amet lectus. Nulla facilisi. Etiam
                                porta iaculis velit id pulvinar. Sed dolor odio, eleifend eget aliquam vitae,
                                efficitur
                                vitae dolor. Integer ornare neque ac leo sollicitudin, at vestibulum ante
                                scelerisque.
                                Nullam ut elit sed lorem tempus feugiat in et lectus. Mauris interdum molestie
                                placerat.
                                Nullam dolor nunc, elementum et tincidunt id, vestibulum quis turpis. Integer
                                imperdiet
                                a eros a laoreet. Nam mattis vel ligula non imperdiet. Suspendisse potenti. Fusce
                                purus
                                sem, dapibus eu fermentum eget, aliquam vehicula ligula.
                            </p>
                        </div>
                    </div>

                    <div class="row row-bg">
                        <div class="col-xl-5 col-lg-6">
                            <PvCarousel
                                class="swiper-carousel about-slider dots-simple"
                                :options="baseSlider9"
                            >
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-3.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-2.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                                <div class="about-slider-item swiper-slide">
                                    <img
                                        v-lazy="'./images/home/about/img-1.jpg'"
                                        alt="About image description"
                                        width="576"
                                        height="375"
                                    />
                                </div>
                            </PvCarousel>
                        </div>
                        <div class="col-xl-7 col-lg-6">
                            <h2>2016</h2>
                            <p class="mb-2">
                                Aliquam consectetur et lorem semper scelerisque. Proin est nibh,
                                vestibulum vitae
                                congue
                                nec, tristique eu justo. Maecenas eu nunc lacinia, porta lorem vitae, viverra velit.
                                Nulla dolor libero, rhoncus quis luctus eu, fermentum sed leo. Morbi ut risus
                                porttitor
                                odio sodales pulvinar. Sed gravida nulla sed sapien vulputate, eget malesuada justo
                                egestas. Pellentesque sem mi, vulputate ac iaculis sit amet, sagittis feugiat dui.
                                Proin
                                non pellentesque leo. Vestibulum varius laoreet posuere. Etiam fringilla diam odio.
                            </p>

                            <p>
                                Nulla felis nibh, bibendum a leo ut, egestas ornare felis. Nam pretium mauris justo,
                                eget
                                commodo est fringilla vel. Proin condimentum, lacus sit amet finibus gravida, sapien
                                ligula mattis leo, sit amet mattis leo lacus sit amet lectus. Nulla facilisi. Etiam
                                porta iaculis velit id pulvinar. Sed dolor odio, eleifend eget aliquam vitae,
                                efficitur
                                vitae dolor. Integer ornare neque ac leo sollicitudin, at vestibulum ante
                                scelerisque.
                                Nullam ut elit sed lorem tempus feugiat in et lectus. Mauris interdum molestie
                                placerat.
                                Nullam dolor nunc, elementum et tincidunt id, vestibulum quis turpis. Integer
                                imperdiet
                                a eros a laoreet. Nam mattis vel ligula non imperdiet. Suspendisse potenti. Fusce
                                purus
                                sem, dapibus eu fermentum eget, aliquam vehicula ligula.
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="mb-3"></div>
        </div>
    </main>
</template>

<script>
import PvCarousel from '~/components/features/PvCarousel';
import PvCountTo from '~/components/features/PvCountTo';
import { baseSlider9 } from '~/utils/data/carousel';

export default {
	components: {
		PvCarousel,
		PvCountTo
	},
	data: function() {
		return {
			baseSlider9: baseSlider9
		};
	}
};
</script>