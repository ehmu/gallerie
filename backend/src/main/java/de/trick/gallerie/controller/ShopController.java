package de.trick.gallerie.controller;


import de.trick.gallerie.dto.ProductListDTO;
import de.trick.gallerie.entity.Product;
import de.trick.gallerie.service.ProductService;
import de.trick.gallerie.type.OrderType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api/shop")
public class ShopController {

    private static final Logger LOG = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/sidebar-list")
    public String getSidebar() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("sidebar-list.json");
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        for (int result = bis.read(); result != -1; result = bis.read()) {
            buf.write((byte) result);
        }
        return buf.toString("UTF-8");
    }

    @GetMapping(path = "")
    public ProductListDTO getProductList(
            @RequestParam(name = "per_page", required = false, defaultValue = "1")Integer perPage,
            @RequestParam(name = "page", required = false, defaultValue = "1")Integer page,
            @RequestParam(name = "order_by", required = false, defaultValue = "default")OrderType orderBy
            ) {
        page--;
        Page<Product> result = this.productService.loadProducts(page, perPage, true, orderBy.getDatabaseName());
        ProductListDTO productList = new ProductListDTO();
        result.get().forEach(product -> productList.getProducts().add(product));
        productList.setTotalCount((int) result.getTotalElements());
        return productList;
    }

}
