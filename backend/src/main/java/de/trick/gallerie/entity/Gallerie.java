package de.trick.gallerie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity-Klasse für Adressen
 *
 * User: dehmann
 * Date: 02.02.15
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "gallerie")
public class Gallerie extends AbstractEntity{

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @CollectionTable(name = "gallerie_dokumente", joinColumns = @JoinColumn(name = "gallerie_id"))
    private Set<Dokument> dokumente = new HashSet<>();

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

    public Set<Dokument> getDokumente() {
        return dokumente;
    }

    public void setDokumente(Set<Dokument> dokumente) {
        this.dokumente = dokumente;
    }
}
