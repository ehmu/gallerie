package de.trick.gallerie.service;

import de.trick.gallerie.entity.Product;
import de.trick.gallerie.repository.ProductRepository;
import de.trick.gallerie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends AbstractService{

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product saveProduct(Product Product){
        return (Product) this.productRepository.save(Product);
    }

    @Transactional
    public Product loadProductByUUID(String uuid){
        try{
            Product Product = (Product) this.findByUuid(uuid);
            return Product;
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

    @Transactional
    public Page<Product> loadProducts(Integer page, Integer perPage, Boolean onlyActive, String orderBy){
        Page<Product> result = productRepository.findAll(Specification.where(ProductRepository.isActive(onlyActive)), PageRequest.of(page, perPage, Sort.by(Sort.Direction.DESC, orderBy)));
        return result;
    }

    @Transactional
    public void deleteProduct(Product Product){
        this.productRepository.delete(Product);
    }

    @Transactional
    public void deleteProductByUUID(String uuid){
        try {
            Product Product = this.loadProductByUUID(uuid);
            this.deleteProduct(Product);
        }
        catch (EntityNotFoundException e){
            throw e;
        }
    }

}