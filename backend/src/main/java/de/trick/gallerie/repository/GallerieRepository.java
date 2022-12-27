package de.trick.gallerie.repository;


import de.trick.gallerie.entity.Gallerie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GallerieRepository extends CrudRepository<Gallerie, Long> {

    List<Gallerie> findByActive(boolean active);
}
