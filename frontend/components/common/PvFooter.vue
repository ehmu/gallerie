<template>
    <footer class="footer">
        <div class="container">
            <div
                class="footer-top top-border d-flex align-items-center justify-content-between flex-wrap"
            >
                <div class="footer-left widget-newsletter d-md-flex align-items-center">
                    <div class="widget-newsletter-info">
                        <h5
                            class="widget-newsletter-title text-uppercase m-b-1"
                        >subscribe newsletter</h5>
                        <p
                            class="widget-newsletter-content mb-0"
                        >Get all the latest information on Events, Sales and Offers.</p>
                    </div>
                    <form action="#">
                        <div class="footer-submit-wrapper d-flex">
                            <input
                                type="email"
                                class="form-control"
                                placeholder="Email address..."
                                size="40"
                                required
                            />
                            <button type="submit" class="btn btn-dark btn-sm">Subscribe</button>
                        </div>
                    </form>
                </div>
                <div class="footer-right">
                    <div class="social-icons">
                        <a
                            href="javascript:;"
                            class="social-icon social-facebook icon-facebook"
                            
                        ></a>
                        <a
                            href="javascript:;"
                            class="social-icon social-twitter icon-twitter"
                            
                        ></a>
                        <a
                            href="javascript:;"
                            class="social-icon social-instagram icon-instagram"
                            
                        ></a>
                    </div>
                </div>
            </div>

            <div class="footer-middle">
                <div class="row">
                    <div class="col-lg-6 col-xl-4">
                        <div class="widget">
                            <h4 class="widget-title">Contact Info</h4>

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="contact-widget">
                                        <h4 class="widget-title">ADDRESS:</h4>
                                        <a href="javascript:;">1234 Street Name, City, England</a>
                                    </div>
                                </div>

                                <div class="col-sm-6 pl-xl-0">
                                    <div class="contact-widget">
                                        <h4 class="widget-title">PHONE:</h4>
                                        <a href="javascript:;">(123) 456-7890</a>
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <div class="contact-widget email">
                                        <h4 class="widget-title">EMAIL:</h4>
                                        <a href="mailto:mail@example.com">mail@example.com</a>
                                    </div>
                                </div>

                                <div class="col-sm-6 pl-xl-0">
                                    <div class="contact-widget">
                                        <h4 class="widget-title">WORKING DAYS/HOURS:</h4>
                                        <a href="javascript:;">Mon - Sun / 9:00 AM - 8:00 PM</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3 col-xl-4">
                        <div class="widget">
                            <h4 class="widget-title">My Account</h4>
                            <div class="links link-parts row">
                                <ul class="link-part col-xl-4 mb-0">
                                    <li>
                                        <nuxt-link to="/pages/about-us">About Us</nuxt-link>
                                    </li>
                                    <li>
                                        <nuxt-link to="/pages/contact-us">Contact Us</nuxt-link>
                                    </li>
                                    <li>
                                        <nuxt-link to="/pages/account">My Account</nuxt-link>
                                    </li>
                                </ul>
                                <ul class="link-part col-xl-8">
                                    <li class="pl-xl-2 ml-xl-1">
                                        <a href="javascript:;">Orders History</a>
                                    </li>
                                    <li class="pl-xl-2 ml-xl-1">
                                        <a href="javascript:;">Advanced Search</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3 col-xl-4">
                        <div class="widget">
                            <h4 class="widget-title">Main Features</h4>
                            <div class="links link-parts row">
                                <ul class="link-part col-xl-6 mb-0">
                                    <li>
                                        <a href="javascript:;">Super Fast Vue Theme</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">1st Fully working Ajax Theme</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">33 Unique Shop Layouts</a>
                                    </li>
                                </ul>
                                <ul class="link-part col-xl-6 pl-xl-2">
                                    <li>
                                        <a href="javascript:;">Powerful Admin Panel</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Mobile &amp; Retina Optimized</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="footer-bottom d-sm-flex align-items-center">
                <div class="footer-left">
                    <span class="footer-copyright">Porto eCommerce. © 2021. All Rights Reserved</span>
                </div>

                <div class="footer-right ml-auto mt-1 mt-sm-0">
                    <div class="payment-icons mr-0">
                        <span
                            class="payment-icon visa"
                            v-lazy:background-image="'./images/payments/payment-visa.svg'"
                        ></span>
                        <span
                            class="payment-icon paypal"
                            v-lazy:background-image="'./images/payments/payment-paypal.svg'"
                        ></span>
                        <span
                            class="payment-icon stripe"
                            v-lazy:background-image="'./images/payments/payment-stripe.png'"
                        ></span>
                        <span
                            class="payment-icon verisign"
                            v-lazy:background-image="'./images/payments/payment-verisign.svg'"
                        ></span>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</template>

<script>
export default {};
</script>