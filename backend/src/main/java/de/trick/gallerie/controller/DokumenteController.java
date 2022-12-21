package de.trick.gallerie.controller;

import de.trick.gallerie.entity.AbstractEntity;
import de.trick.gallerie.entity.Dokument;
import de.trick.gallerie.service.DokumentService;
import de.trick.gallerie.type.DokumentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.util.Set;



@Controller
@RequestMapping(value = "/api/dokumente")
public class DokumenteController{

    private static final Logger LOG = LoggerFactory.getLogger(DokumenteController.class);


    @Autowired
    private DokumentService dokumentService;

    /**
     * Speichert ein Dokument in der Datenbank und ordnet es der Entity zu. WICHTIG: Die Entity muss ein 'Set<Dokument> dokumente' haben
     * @param objectUuid Die UUID der Entity die die Dokumente beinhaltet
     * @param objectClass Voll qualifizierter Klassenname (z.B. Gallerie)
     * @param dokumentType DokumentType (IMAGE, PDF)
     * @param file
     * @param modelMap
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadDokument", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<?> uploadDokument(@RequestParam("objectUuid") String objectUuid, @RequestParam("objectClass") String objectClass, @RequestParam(value = "dokumentType", required = false)DokumentType dokumentType, @RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);

        Dokument dokument = new Dokument();
        try {
            dokument.setData(file.getBytes());
            dokument.setDocType(file.getContentType());
            dokument.setTitle(file.getOriginalFilename());
            dokument.setDocName(file.getOriginalFilename());
            dokument.setSize(file.getSize());
            dokument.setDokumentType(dokumentType);
            this.dokumentService.saveDokument(dokument);
            //Falls ein Objekt übergeben wurde, das Dokument dranheften
            if(!StringUtils.isEmpty(objectUuid)){
                Class<?> aClass = Class.forName(objectClass);
                AbstractEntity o = this.dokumentService.findByUuid(objectUuid);
                Method m = aClass.getDeclaredMethod("getDokumente");
                Set<Dokument> dokumente = (Set<Dokument>) m.invoke(o, new Object[0]);
                dokumente.add(dokument);
                this.dokumentService.save(o);
            }
            return new ResponseEntity<>(dokument, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(dokument, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * L�scht ein Dokument aus der Datenbank und entfernt es aus der Entity zu. WICHTIG: Die Entity muss ein 'Set<Dokument> dokumente' haben
     * @param objectUuid Die UUID der Entity die die Dokumente beinhaltet
     * @param objectClass Voll qualifizierter Klassenname (z.B. Gallerie)
     * @param uuid UUID des zu l�schenden Dokuments
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteDokument", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<?> deleteDokument(@RequestParam("objectUuid") String objectUuid, @RequestParam("objectClass") String objectClass, @RequestParam("uuid") String uuid) {

        try{
            //Falls ein Objekt übergeben wurde, das Dokument wegnehmen
            if(!StringUtils.isEmpty(objectUuid)){
                Class<?> aClass = Class.forName(objectClass);
                AbstractEntity o = this.dokumentService.findByUuid(objectUuid);
                Method m = aClass.getDeclaredMethod("getDokumente");
                Set<Dokument> dokumente = (Set<Dokument>) m.invoke(o, new Object[0]);
                for(Dokument dokument : dokumente){
                    if(dokument.getUuid().equals(uuid)){
                        dokumente.remove(dokument);
                        break;
                    }
                }
                this.dokumentService.save(o);
            }

            this.dokumentService.deleteDokumentByUUID(uuid);
            return new ResponseEntity<>(uuid, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/downloadDokument/{uuid}")
    public ResponseEntity<ByteArrayResource> downloadDokument(@PathVariable String uuid){
        Dokument dokument = this.dokumentService.loadDokumentByUUID(uuid);
        ResponseEntity<ByteArrayResource> responseEntity = ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dokument.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + dokument.getTitle() + "\"")
                .body(new ByteArrayResource(dokument.getData()));
        return responseEntity;
    }

}
