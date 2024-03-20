package de.trick.gallerie.controller;


import de.trick.gallerie.dto.ProductListDTO;
import de.trick.gallerie.entity.Category;
import de.trick.gallerie.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "")
    public ResponseEntity<HashMap> getCategories(@RequestParam(name = "onlyActive", required = false)Boolean onlyActive){
        List<Category> categories = this.categoryService.loadCategories(onlyActive);
        HashMap response = new HashMap();
        response.put("categories", categories);
        ResponseEntity<HashMap> responseEntity = ResponseEntity.ok().body(response);
        return responseEntity;
    }

    @GetMapping(path = "/{uuid}")
    public ResponseEntity<Category> getCategory(@PathVariable("uuid") String uuid){
        Category category = this.categoryService.loadCategoryByUUID(uuid);
        ResponseEntity<Category> responseEntity = ResponseEntity.ok().body(category);
        return responseEntity;
    }


}
