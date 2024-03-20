package de.trick.gallerie.dto;

import de.trick.gallerie.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {


    private Product product;

    private Product nextProduct;

    private Product previousProduct;

    private List<Product> relatedProducts = new ArrayList<>();

    private List<Product> featuredProducts = new ArrayList<>();

    private List<Product> bestSellingProducts = new ArrayList<>();

    private List<Product> latestProducts = new ArrayList<>();

    private List<Product> topRatedProducts = new ArrayList<>();

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getNextProduct() {
        return nextProduct;
    }

    public void setNextProduct(Product nextProduct) {
        this.nextProduct = nextProduct;
    }

    public Product getPreviousProduct() {
        return previousProduct;
    }

    public void setPreviousProduct(Product previousProduct) {
        this.previousProduct = previousProduct;
    }

    public List<Product> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(List<Product> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public List<Product> getFeaturedProducts() {
        return featuredProducts;
    }

    public void setFeaturedProducts(List<Product> featuredProducts) {
        this.featuredProducts = featuredProducts;
    }

    public List<Product> getBestSellingProducts() {
        return bestSellingProducts;
    }

    public void setBestSellingProducts(List<Product> bestSellingProducts) {
        this.bestSellingProducts = bestSellingProducts;
    }

    public List<Product> getLatestProducts() {
        return latestProducts;
    }

    public void setLatestProducts(List<Product> latestProducts) {
        this.latestProducts = latestProducts;
    }

    public List<Product> getTopRatedProducts() {
        return topRatedProducts;
    }

    public void setTopRatedProducts(List<Product> topRatedProducts) {
        this.topRatedProducts = topRatedProducts;
    }
}
