package de.trick.gallerie.dto;

import de.trick.gallerie.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListDTO {

    private int totalCount;

    private List<Product> products = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
