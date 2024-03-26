package de.trick.gallerie.controller;


import de.trick.gallerie.dto.CartDTO;
import de.trick.gallerie.dto.ProductListDTO;
import de.trick.gallerie.dto.SidebarDTO;
import de.trick.gallerie.entity.Product;
import de.trick.gallerie.service.CategoryService;
import de.trick.gallerie.service.ProductService;
import de.trick.gallerie.type.ColorType;
import de.trick.gallerie.type.OrderType;
import de.trick.gallerie.type.PicturesizeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/shop")
public class ShopController {

    private static final Logger LOG = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping(path = "/sidebar-list")
    public ResponseEntity<SidebarDTO> getSidebar() {
        SidebarDTO sidebar = new SidebarDTO();
        sidebar.getFeaturedProducts().add(new Product());
        sidebar.getSidebarList().addAll(this.categoryService.loadCategories(true));
        ResponseEntity<SidebarDTO> responseEntity = ResponseEntity.ok().body(sidebar);
        return responseEntity;
    }

    @GetMapping(path = "")
    public ResponseEntity<ProductListDTO> getProductList(
            @RequestParam(name = "per_page", required = false, defaultValue = "1")Integer perPage,
            @RequestParam(name = "page", required = false, defaultValue = "1")Integer page,
            @RequestParam(name = "order_by", required = false, defaultValue = "default")OrderType orderBy,
            @RequestParam(name = "category", required = false)String categoryUuid,
            @RequestParam(name = "color", required = false)ColorType[] colors,
            @RequestParam(name = "size", required = false)PicturesizeType[] sizes
            ) {
        page--;
        Page<Product> result = this.productService.loadProducts(page, perPage, true, orderBy.getDatabaseName(), colors, sizes, categoryUuid);
        ProductListDTO productList = new ProductListDTO();
        result.get().forEach(product -> productList.getProducts().add(product));
        productList.setTotalCount((int) result.getTotalElements());
        ResponseEntity<ProductListDTO> responseEntity = ResponseEntity.ok().body(productList);
        return responseEntity;
    }

    @PostMapping(path = "/submitCart", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> submitCart(@RequestBody CartDTO cartDTO) {
        LOG.info(cartDTO.getNachricht());
        ResponseEntity<String> responseEntity = ResponseEntity.ok().body("Alles toll");
        return responseEntity;
    }

}
