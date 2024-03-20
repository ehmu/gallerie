package de.trick.gallerie.dto;

import de.trick.gallerie.entity.Category;
import de.trick.gallerie.entity.Product;
import de.trick.gallerie.type.ColorType;
import de.trick.gallerie.type.PicturesizeType;

import java.util.ArrayList;
import java.util.List;

public class SidebarDTO {

    private List<Category> sidebarList = new ArrayList<>();

    private List<Product> featuredProducts = new ArrayList<>();

    private ColorType[] shopColors = ColorType.values();

    private PicturesizeType[] shopSizes = PicturesizeType.values();

    public List<Category> getSidebarList() {
        return sidebarList;
    }

    public void setSidebarList(List<Category> sidebarList) {
        this.sidebarList = sidebarList;
    }

    public List<Product> getFeaturedProducts() {
        return featuredProducts;
    }

    public void setFeaturedProducts(List<Product> featuredProducts) {
        this.featuredProducts = featuredProducts;
    }

    public ColorType[] getShopColors() {
        return shopColors;
    }

    public void setShopColors(ColorType[] shopColors) {
        this.shopColors = shopColors;
    }

    public PicturesizeType[] getShopSizes() {
        return shopSizes;
    }

    public void setShopSizes(PicturesizeType[] shopSizes) {
        this.shopSizes = shopSizes;
    }
}
