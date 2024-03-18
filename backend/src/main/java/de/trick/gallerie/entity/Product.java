package de.trick.gallerie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    private String name;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_uuid")
    private Set<String> imageUuids = new HashSet<>();

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
}
