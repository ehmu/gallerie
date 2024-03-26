import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _0d1f80d6 = () => interopDefault(import('../pages/shop/index.vue' /* webpackChunkName: "pages/shop/index" */))
const _5e58f7e5 = () => interopDefault(import('../pages/pages/about-us.vue' /* webpackChunkName: "pages/pages/about-us" */))
const _9747c614 = () => interopDefault(import('../pages/pages/account.vue' /* webpackChunkName: "pages/pages/account" */))
const _4fa66829 = () => interopDefault(import('../pages/pages/blog.vue' /* webpackChunkName: "pages/pages/blog" */))
const _7778c4a7 = () => interopDefault(import('../pages/pages/cart.vue' /* webpackChunkName: "pages/pages/cart" */))
const _202df766 = () => interopDefault(import('../pages/pages/checkout.vue' /* webpackChunkName: "pages/pages/checkout" */))
const _2ecb9c32 = () => interopDefault(import('../pages/pages/contact-us.vue' /* webpackChunkName: "pages/pages/contact-us" */))
const _7a5ed7ce = () => interopDefault(import('../pages/pages/forgot-password.vue' /* webpackChunkName: "pages/pages/forgot-password" */))
const _07137c72 = () => interopDefault(import('../pages/pages/login.vue' /* webpackChunkName: "pages/pages/login" */))
const _546d939f = () => interopDefault(import('../pages/pages/order-complete.vue' /* webpackChunkName: "pages/pages/order-complete" */))
const _f1c9d568 = () => interopDefault(import('../pages/pages/wishlist.vue' /* webpackChunkName: "pages/pages/wishlist" */))
const _2c45a0fb = () => interopDefault(import('../pages/shop/boxed-image.vue' /* webpackChunkName: "pages/shop/boxed-image" */))
const _12068d1e = () => interopDefault(import('../pages/shop/boxed-slider.vue' /* webpackChunkName: "pages/shop/boxed-slider" */))
const _989d7eb0 = () => interopDefault(import('../pages/shop/horizontal-filter-1.vue' /* webpackChunkName: "pages/shop/horizontal-filter-1" */))
const _98814fae = () => interopDefault(import('../pages/shop/horizontal-filter-2.vue' /* webpackChunkName: "pages/shop/horizontal-filter-2" */))
const _a92a08ae = () => interopDefault(import('../pages/shop/infinite-scroll.vue' /* webpackChunkName: "pages/shop/infinite-scroll" */))
const _233a14aa = () => interopDefault(import('../pages/shop/list.vue' /* webpackChunkName: "pages/shop/list" */))
const _94af167a = () => interopDefault(import('../pages/shop/off-canvas.vue' /* webpackChunkName: "pages/shop/off-canvas" */))
const _2d9bfbee = () => interopDefault(import('../pages/shop/right-sidebar.vue' /* webpackChunkName: "pages/shop/right-sidebar" */))
const _11df5234 = () => interopDefault(import('../pages/index.vue' /* webpackChunkName: "pages/index" */))
const _5dcbd80a = () => interopDefault(import('../pages/pages/single/_slug.vue' /* webpackChunkName: "pages/pages/single/_slug" */))
const _e43e7de8 = () => interopDefault(import('../pages/product/center/_slug.vue' /* webpackChunkName: "pages/product/center/_slug" */))
const _50e84820 = () => interopDefault(import('../pages/product/extended/_slug.vue' /* webpackChunkName: "pages/product/extended/_slug" */))
const _37f9ea06 = () => interopDefault(import('../pages/product/fullwidth/_slug.vue' /* webpackChunkName: "pages/product/fullwidth/_slug" */))
const _7b703fbd = () => interopDefault(import('../pages/product/grid/_slug.vue' /* webpackChunkName: "pages/product/grid/_slug" */))
const _de4a77e6 = () => interopDefault(import('../pages/product/left-sidebar/_slug.vue' /* webpackChunkName: "pages/product/left-sidebar/_slug" */))
const _647a49cc = () => interopDefault(import('../pages/product/right-sidebar/_slug.vue' /* webpackChunkName: "pages/product/right-sidebar/_slug" */))
const _71e73c58 = () => interopDefault(import('../pages/product/sticky-both/_slug.vue' /* webpackChunkName: "pages/product/sticky-both/_slug" */))
const _edd6329a = () => interopDefault(import('../pages/product/sticky-cart/_slug.vue' /* webpackChunkName: "pages/product/sticky-cart/_slug" */))
const _a7b8927e = () => interopDefault(import('../pages/product/sticky-info/_slug.vue' /* webpackChunkName: "pages/product/sticky-info/_slug" */))
const _7a5fe601 = () => interopDefault(import('../pages/product/transparent/_slug.vue' /* webpackChunkName: "pages/product/transparent/_slug" */))
const _486f1c5d = () => interopDefault(import('../pages/shop/grid/_type.vue' /* webpackChunkName: "pages/shop/grid/_type" */))
const _47127908 = () => interopDefault(import('../pages/product/_type/_slug.vue' /* webpackChunkName: "pages/product/_type/_slug" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: '',
  linkExactActiveClass: 'active',
  scrollBehavior,

  routes: [{
    path: "/shop",
    component: _0d1f80d6,
    name: "shop"
  }, {
    path: "/pages/about-us",
    component: _5e58f7e5,
    name: "pages-about-us"
  }, {
    path: "/pages/account",
    component: _9747c614,
    name: "pages-account"
  }, {
    path: "/pages/blog",
    component: _4fa66829,
    name: "pages-blog"
  }, {
    path: "/pages/cart",
    component: _7778c4a7,
    name: "pages-cart"
  }, {
    path: "/pages/checkout",
    component: _202df766,
    name: "pages-checkout"
  }, {
    path: "/pages/contact-us",
    component: _2ecb9c32,
    name: "pages-contact-us"
  }, {
    path: "/pages/forgot-password",
    component: _7a5ed7ce,
    name: "pages-forgot-password"
  }, {
    path: "/pages/login",
    component: _07137c72,
    name: "pages-login"
  }, {
    path: "/pages/order-complete",
    component: _546d939f,
    name: "pages-order-complete"
  }, {
    path: "/pages/wishlist",
    component: _f1c9d568,
    name: "pages-wishlist"
  }, {
    path: "/shop/boxed-image",
    component: _2c45a0fb,
    name: "shop-boxed-image"
  }, {
    path: "/shop/boxed-slider",
    component: _12068d1e,
    name: "shop-boxed-slider"
  }, {
    path: "/shop/horizontal-filter-1",
    component: _989d7eb0,
    name: "shop-horizontal-filter-1"
  }, {
    path: "/shop/horizontal-filter-2",
    component: _98814fae,
    name: "shop-horizontal-filter-2"
  }, {
    path: "/shop/infinite-scroll",
    component: _a92a08ae,
    name: "shop-infinite-scroll"
  }, {
    path: "/shop/list",
    component: _233a14aa,
    name: "shop-list"
  }, {
    path: "/shop/off-canvas",
    component: _94af167a,
    name: "shop-off-canvas"
  }, {
    path: "/shop/right-sidebar",
    component: _2d9bfbee,
    name: "shop-right-sidebar"
  }, {
    path: "/",
    component: _11df5234,
    name: "index"
  }, {
    path: "/pages/single/:slug?",
    component: _5dcbd80a,
    name: "pages-single-slug"
  }, {
    path: "/product/center/:slug?",
    component: _e43e7de8,
    name: "product-center-slug"
  }, {
    path: "/product/extended/:slug?",
    component: _50e84820,
    name: "product-extended-slug"
  }, {
    path: "/product/fullwidth/:slug?",
    component: _37f9ea06,
    name: "product-fullwidth-slug"
  }, {
    path: "/product/grid/:slug?",
    component: _7b703fbd,
    name: "product-grid-slug"
  }, {
    path: "/product/left-sidebar/:slug?",
    component: _de4a77e6,
    name: "product-left-sidebar-slug"
  }, {
    path: "/product/right-sidebar/:slug?",
    component: _647a49cc,
    name: "product-right-sidebar-slug"
  }, {
    path: "/product/sticky-both/:slug?",
    component: _71e73c58,
    name: "product-sticky-both-slug"
  }, {
    path: "/product/sticky-cart/:slug?",
    component: _edd6329a,
    name: "product-sticky-cart-slug"
  }, {
    path: "/product/sticky-info/:slug?",
    component: _a7b8927e,
    name: "product-sticky-info-slug"
  }, {
    path: "/product/transparent/:slug?",
    component: _7a5fe601,
    name: "product-transparent-slug"
  }, {
    path: "/shop/grid/:type?",
    component: _486f1c5d,
    name: "shop-grid-type"
  }, {
    path: "/product/:type?/:slug?",
    component: _47127908,
    name: "product-type-slug"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
