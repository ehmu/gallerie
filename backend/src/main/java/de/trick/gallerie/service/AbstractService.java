package de.trick.gallerie.service;

import de.trick.gallerie.entity.AbstractEntity;
import de.trick.gallerie.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractService {

    @Autowired
    private AbstractRepository abstractRepository;

    public AbstractEntity findByUuid(String uuid){
        return this.abstractRepository.findByUuid(uuid).get(0);
    }

    public void delete(AbstractEntity abstractEntity){
        this.abstractRepository.delete(abstractEntity);
    }

    public AbstractEntity save(AbstractEntity abstractEntity){
        return this.abstractRepository.save(abstractEntity);
    }
}
