package de.trick.gallerie.service;

import de.trick.gallerie.entity.Category;
import de.trick.gallerie.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void addDataCategory() {
        for(int i = 1; i<5; i++){
            Category category = new Category();
            category.setName("Kategorie " + i);
            category.setActive(true);
            category.setDescription("Ich bin die Beschreibung von Kategorie " + i);
            Product product = new Product();
            product.setName("Produkt "  + i);
            product.setDescription("Beschreibung Produkt " + i);
            product.getImageUuids().add("eee-ddd-ccc-" + i);
            product.setCreatedAt(new Date());
            product.setActive(true);
            categoryService.save(product);
            category.getProducts().add(product);
            this.categoryService.saveCategory(category);
        }
    }

    @Test
    void loadCategoryByUUID() {
    }

    @Test
    void loadCategories() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void deleteGallerieByUUID() {
    }
}