<template>
  <div class="product-default inner-quickview inner-icon">
    <figure class="img-effect">
      <nuxt-link :to="`/product/default/${product.slug}`">
        <img
          v-for="(item,index) in product.imagePaths.slice(0,2)"
          :key="`related-large-${index}`"
          v-lazy="`${baseUrl}${item}`"
          alt="large-picture"
          :width="item.width"
          :height="item.height"
        />
      </nuxt-link>

      <div class="label-group">
        <div
          class="product-label label-hot"
          v-if="product.is_hot"
        >HOT</div>
        <div
          class="product-label label-sale"
          v-if="product.is_sale && !product.price"
        >Sale</div>
        <div
          class="product-label label-sale"
          v-if="product.is_sale && product.price"
        >-{{ discount }}%</div>
      </div>

      <div class="btn-icon-group">

        <a
          href="javascript:;"
          class="btn-icon btn-add-cart product-type-simple"
          v-if="!isInCart"
          @click="addCart"
        >
          <i class="icon-wishlist-2"></i>
        </a>

        <a
          href="javascript:;"
          class="btn-icon btn-add-cart product-type-simple"
          v-else="isInCart"
          @click="removeFromCart"
        >
          <i class="icon-wishlist"></i>
        </a>

      </div>

      <a
        href="javascript:;"
        class="btn-quickview"
        title="Quick View"
        @click="openQuickview"
      >Schnellansicht</a>

      <div
        class="product-countdown-container"
        v-if="product.until"
      >
        <span class="product-countdown-title">offer ends in:</span>
        <pv-count-down
          class="product-countdown countdown-compact"
          :until="product.until"
          :compact="true"
        ></pv-count-down>
      </div>
    </figure>

    <div class="product-details">
      <div class="category-wrap">
        <div class="category-list">
					<span
            v-for="(cat,index) in product.product_categories"
            :key="`product-category-${index}`"
          >
						<nuxt-link :to="{ path: '/shop', query: { category: cat.slug }}">{{ cat.name }}</nuxt-link>
						<template v-if="index < product.product_categories.length - 1">,</template>
					</span>
        </div>

                <!--nuxt-link
                    to="/pages/cart"
                    class="btn-icon-wish added-wishlist"
                    title="Zur Merkliste"
                    v-if="isInCart"
                >
                    <i class="icon-wishlist-2"></i>
                </nuxt-link-->

                <a
                    href="javascript:;"
                    class="btn-icon-wish"
                    title="Auf die Merkliste"
                    @click="addCart()"
                    v-if="!isInCart"
                >
                    <i class="icon-wishlist-2"></i>
                </a>

                <a
                  href="javascript:;"
                  class="btn-icon-wish added-wishlist"
                  title="Auf die Merkliste"
                  @click="removeFromCart"
                  v-if="isInCart"
                >
                  <i class="icon-wishlist-2"></i>
                </a>

      </div>

      <h3 class="product-title">
        <nuxt-link :to="'/product/default/' + product.slug">{{ product.name }}</nuxt-link>
      </h3>

      <div class="ratings-container">
        <div class="product-ratings">
					<span
            class="ratings"
            :style="{width: product.ratings * 20 + '%'}"
          ></span>

        </div>
      </div>

      <div
        class="price-box"
        v-if="product.price"
        key="singlePrice"
      >
        <template v-if="!product.is_sale">
          <span class="product-price">{{ product.price | priceFormat }}</span>
        </template>

        <template v-else>
          <span class="old-price">{{ product.price | priceFormat }}</span>
          <span class="product-price">{{ product.sale_price | priceFormat }}</span>
        </template>
      </div>

      <!--div
        class="price-box"
        v-else
      >
        <template v-if="minPrice !== maxPrice">
          <span class="product-price">{{ minPrice | priceFormat }} &ndash; ${{ maxPrice | priceFormat }}</span>
        </template>

        <template v-else>
          <span class="product-price">{{ minPrice | priceFormat }}</span>
        </template>
      </div-->
    </div>
  </div>
</template>

<script>
  import PvCountDown from '~/components/features/PvCountDown';
  import { mapGetters, mapActions } from 'vuex';
  import { baseUrl } from '~/api/index';

  export default {
    components: {
      PvCountDown
    },
    props: {
      product: Object,
      adClass: String,
      isActions: {
        type: Boolean,
        default: true
      }
    },
    data: function() {
      return {
        baseUrl: baseUrl,
        minPrice: 0,
        maxPrice: 0,
        discount: 0
      };
    },
    computed: {
      ...mapGetters('wishlist', ['wishList']),
      ...mapGetters('cart', ['cartList']),
    isWishlisted: function() {
      if (
        this.wishList.findIndex(
          item => item.name === this.product.name
      ) > -1
    )
      return true;
      return false;
    },
    isInCart: function() {
      if (
        this.cartList.findIndex(
          item => item.name === this.product.name
      ) > -1
    )
      return true;
      return false;
    }
  },
  mounted: function() {
    if (this.product.is_sale && this.product.price) {
      this.discount =
        ((this.product.price - this.product.sale_price) /
          this.product.price) *
        100;
      this.discount = parseInt(this.discount);
    }

  },
  methods: {
  ...mapActions('wishlist', ['addToWishlist']),
  ...mapActions('cart', ['addToCart', 'removeFromCart',]),
      openQuickview: function() {
      this.$modal.show(
        () => import('~/components/features/product/PvQuickview'),
        { slug: this.product.slug },
        {
          width: '931',
          height: 'auto',
          adaptive: true,
          class: 'quickview-modal'
        }
    );
    },
    addWishlist: function(e) {
      e.currentTarget.classList.add('load-more-overlay', 'loading');

      setTimeout(() => {
        this.addToWishlist({ product: this.product });
      document
        .querySelector('.wishlist-popup')
        .classList.add('active');

      setTimeout(() => {
        document
        .querySelector('.wishlist-popup')
        .classList.remove('active');
    }, 1000);
    }, 1000);
    },
    addCart: function() {
      if (this.product.stock > 0) {
        let saledProduct = { ...this.product };
        if (this.product.is_sale) {
          saledProduct.price = this.product.sale_price;
        }

        this.addToCart({ product: saledProduct });
      }
    }
  }
  };
</script>
