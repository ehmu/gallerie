package de.trick.gallerie.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date createdAt;

    private String name;

    private String description;

    private double price;

    @Column(columnDefinition = "boolean default false")
    private boolean active;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_uuid")
    private Set<String> imageUuids = new HashSet<>();

    @Transient
    private int stock = 1;

    @Transient
    private Set<Product> variants = new HashSet<>();

    private int ratings = 5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getImageUuids() {
        return imageUuids;
    }

    public void setImageUuids(Set<String> imageUuids) {
        this.imageUuids = imageUuids;
    }

    public Set<Product> getVariants() {
        return variants;
    }

    public void setVariants(Set<Product> variants) {
        this.variants = variants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
