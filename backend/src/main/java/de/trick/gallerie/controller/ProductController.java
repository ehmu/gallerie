package de.trick.gallerie.controller;


import de.trick.gallerie.dto.ProductDTO;
import de.trick.gallerie.entity.Category;
import de.trick.gallerie.entity.Product;
import de.trick.gallerie.service.CategoryService;
import de.trick.gallerie.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/{uuid}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("uuid") String uuid){
        Product product = this.productService.loadProductByUUID(uuid);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct(product);
        ResponseEntity<ProductDTO> responseEntity = ResponseEntity.ok().body(productDTO);
        return responseEntity;
    }


}
