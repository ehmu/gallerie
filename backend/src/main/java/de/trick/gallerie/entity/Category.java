package de.trick.gallerie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "category")
public class Category extends AbstractEntity{

    private String name;

    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean active;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "category_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn( name="product_id"))
    private Set<Product> products = new HashSet<>();

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
