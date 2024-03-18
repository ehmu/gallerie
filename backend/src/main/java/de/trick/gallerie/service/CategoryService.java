package de.trick.gallerie.service;

import de.trick.gallerie.entity.Category;
import de.trick.gallerie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService extends AbstractService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Category saveCategory(Category Category){
        return (Category) this.categoryRepository.save(Category);
    }

    @Transactional
    public Category loadCategoryByUUID(String uuid){
        try{
            Category Category = (Category) this.findByUuid(uuid);
            return Category;
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

    @Transactional
    public List<Category> loadCategories(Boolean onlyActive){
        List<Category> galleries;
        if(onlyActive != null && onlyActive == true){
            galleries = this.categoryRepository.findByActive(true);
        }
        else {
            galleries = (List<Category>) this.categoryRepository.findAll();
        }
        return galleries;
    }

    @Transactional
    public void deleteCategory(Category Category){
        this.categoryRepository.delete(Category);
    }

    @Transactional
    public void deleteGallerieByUUID(String uuid){
        try {
            Category Category = this.loadCategoryByUUID(uuid);
            this.deleteCategory(Category);
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

}