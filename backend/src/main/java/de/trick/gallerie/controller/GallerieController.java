package de.trick.gallerie.controller;


import de.trick.gallerie.entity.Gallerie;
import de.trick.gallerie.service.GallerieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/gallerie")
public class GallerieController {

    private static final Logger LOG = LoggerFactory.getLogger(GallerieController.class);

    @Autowired
    private GallerieService gallerieService;

    @GetMapping(path = "/{uuid}")
    public Gallerie getGallerie(@PathVariable("uuid") String uuid){
        Gallerie gallerie = this.gallerieService.loadGallerieByUUID(uuid);
        return gallerie;
    }

    @GetMapping(path = "/galleries")
    public List<Gallerie> getGalleries(@RequestParam(name = "onlyActive", required = false)Boolean onlyActive){
        List<Gallerie> galleries = this.gallerieService.loadGalleries(onlyActive);
        return galleries;
    }
}
