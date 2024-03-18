package de.trick.gallerie.repository;


import de.trick.gallerie.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByActive(boolean active);
}
