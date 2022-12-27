package de.trick.gallerie.service;

import de.trick.gallerie.entity.Gallerie;
import de.trick.gallerie.repository.GallerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GallerieService extends AbstractService{

    @Autowired
    private GallerieRepository gallerieRepository;

    @Transactional
    public Gallerie saveGallerie(Gallerie Gallerie){
        return (Gallerie) this.gallerieRepository.save(Gallerie);
    }

    @Transactional
    public Gallerie loadGallerieByUUID(String uuid){
        try{
            Gallerie Gallerie = (Gallerie) this.findByUuid(uuid);
            return Gallerie;
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

    @Transactional
    public List<Gallerie> loadGalleries(Boolean onlyActive){
        List<Gallerie> galleries;
        if(onlyActive != null && onlyActive == true){
            galleries = this.gallerieRepository.findByActive(true);
        }
        else {
            galleries = (List<Gallerie>) this.gallerieRepository.findAll();
        }
        return galleries;
    }

    @Transactional
    public void deleteGallerie(Gallerie Gallerie){
        this.gallerieRepository.delete(Gallerie);
    }

    @Transactional
    public void deleteGallerieByUUID(String uuid){
        try {
            Gallerie Gallerie = this.loadGallerieByUUID(uuid);
            this.deleteGallerie(Gallerie);
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

}