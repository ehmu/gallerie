package de.trick.gallerie.repository;


import de.trick.gallerie.entity.Category;
import de.trick.gallerie.entity.Product;
import de.trick.gallerie.type.ColorType;
import de.trick.gallerie.type.PicturesizeType;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.parameters.P;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByActive(boolean active);

    static Specification<Product> isActive(boolean active) {
        return (product, cq, cb) -> cb.equal(product.get("active"), active);
    }

    static Specification<Product> containsColors(ColorType[] colors) {

        return (product, query, cb) -> {
            if (colors != null && colors.length > 0) {
                List<ColorType> colorList = Arrays.asList(colors);
                return product.get("color").in(colorList);
            } else {
                return cb.and();
            }
        };
    }

    static Specification<Product> containsSizes(PicturesizeType[] sizes) {

        return (product, query, cb) -> {
            if (sizes != null && sizes.length > 0) {
                List<PicturesizeType> sizeList = Arrays.asList(sizes);
                return product.get("size").in(sizeList);
            } else {
                return cb.and();
            }
        };
    }

    static Specification<Product> nameContains(String name) {
        return (product, cq, cb) -> cb.like(product.get("name"), "%" + name + "%");
    }

    static Specification<Product> hasCategory(final Integer categoryId) {

        return (root, query, cb) -> {
            if(categoryId != null){
            query.distinct(true);
            Root<Product> product = root;
            Subquery<Category> categorySubQuery = query.subquery(Category.class);
            Root<Category> category = categorySubQuery.from(Category.class);
            Expression<Collection<Product>> categoryProducts = category.get("products");
            categorySubQuery.select(category);
            categorySubQuery.where(cb.equal(category.get("id"), categoryId), cb.isMember(product, categoryProducts));
            return cb.exists(categorySubQuery);
            }
            else {
                return cb.and();
            }
        };
    }

}
