package de.trick.gallerie.repository;


import de.trick.gallerie.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByActive(boolean active);

    static Specification<Product> isActive(boolean active) {
        return (product, cq, cb) -> cb.equal(product.get("active"), active);
    }

    static Specification<Product> nameContains(String name) {
        return (product, cq, cb) -> cb.like(product.get("name"), "%" + name + "%");
    }

}
