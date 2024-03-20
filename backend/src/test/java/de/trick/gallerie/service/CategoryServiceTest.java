package de.trick.gallerie.service;

import de.trick.gallerie.entity.Category;
import de.trick.gallerie.entity.Product;
import de.trick.gallerie.type.ColorType;
import de.trick.gallerie.type.PicturesizeType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.OptionalInt;
import java.util.Random;


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
            Random random = new Random();
            int anzahlProdukte = random.ints(1, 4).limit(7).findFirst().getAsInt();
            for(int a = 1; a<= anzahlProdukte; a++){
                Product product = new Product();
                product.setName("Produkt "  + a);
                product.setDescription("Beschreibung Produkt " + a);
                product.getImageUuids().add("eee-ddd-ccc-" + a);
                product.setCreatedAt(new Date());
                product.setActive(true);
                product.setSize(PicturesizeType.S60X60);
                product.setColor(ColorType.BLUE);
                categoryService.save(product);
                category.getProducts().add(product);

                product = new Product();
                product.setName("Produkt "  + a+2);
                product.setDescription("Beschreibung Produkt " + a+2);
                product.getImageUuids().add("eee-ddd-ccc-" + a);
                product.setCreatedAt(new Date());
                product.setActive(true);
                product.setSize(PicturesizeType.S40X40);
                product.setColor(ColorType.GREEN);
                categoryService.save(product);
                category.getProducts().add(product);

                product = new Product();
                product.setName("Produkt "  + a+3);
                product.setDescription("Beschreibung Produkt " + a+3);
                product.getImageUuids().add("eee-ddd-ccc-" + a);
                product.setCreatedAt(new Date());
                product.setActive(true);
                product.setSize(PicturesizeType.S80X120);
                product.setColor(ColorType.BLACK);
                categoryService.save(product);
                category.getProducts().add(product);
            }
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