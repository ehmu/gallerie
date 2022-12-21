package de.trick.gallerie.repository;

import de.trick.gallerie.entity.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbstractRepository extends CrudRepository<AbstractEntity, Long> {

    List<AbstractEntity> findByUuid(@Param("uuid") String uuid);
}
