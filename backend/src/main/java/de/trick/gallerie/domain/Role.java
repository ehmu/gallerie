package de.trick.gallerie.domain;

import javax.persistence.*;

/**
 * Entity-Klasse für Adressen
 *
 * User: dehmann
 * Date: 02.02.15
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

    private String name;

    private String description;

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

}
