package de.trick.gallerie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gallerie")
public class Gallerie extends AbstractEntity{

    private String name;

    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean active;

    private String mainImageUuid;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "gallerie_images", joinColumns = @JoinColumn(name = "gallerie_id"))
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMainImageUuid() {
        return mainImageUuid;
    }

    public void setMainImageUuid(String mainImageUuid) {
        this.mainImageUuid = mainImageUuid;
    }

    public Set<String> getImageUuids() {
        return imageUuids;
    }

    public void setImageUuids(Set<String> imageUuids) {
        this.imageUuids = imageUuids;
    }
}
