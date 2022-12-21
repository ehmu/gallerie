package de.trick.gallerie.service;

import de.trick.gallerie.entity.Dokument;
import de.trick.gallerie.repository.DokumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class DokumentService extends AbstractService{

    @Autowired
    private DokumentRepository dokumentRepository;

    @Transactional
    public Dokument saveDokument(Dokument dokument){
        return (Dokument) this.dokumentRepository.save(dokument);
    }

    @Transactional
    public Dokument loadDokumentByUUID(String uuid){
        try{
            Dokument dokument = (Dokument) this.findByUuid(uuid);
            return dokument;
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

    @Transactional
    public void deleteDokument(Dokument dokument){
        this.dokumentRepository.delete(dokument);
    }

    @Transactional
    public void deleteDokumentByUUID(String uuid){
        try {
            Dokument dokument = this.loadDokumentByUUID(uuid);
            this.deleteDokument(dokument);
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

}