package de.trick.gallerie.entity;

import de.trick.gallerie.type.ColorType;
import de.trick.gallerie.type.PicturesizeType;
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

    private int ratings = 5;

    @Enumerated(EnumType.STRING)
    private PicturesizeType size;

    @Enumerated(EnumType.STRING)
    private ColorType color;

    @Transient
    private int stock = 1;

    @Transient
    private Set<Product> variants = new HashSet<>();

    @Transient
    private String slug;

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

    public PicturesizeType getSize() {
        return size;
    }

    public void setSize(PicturesizeType size) {
        this.size = size;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public String getSlug() {
        return this.getUuid();
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
