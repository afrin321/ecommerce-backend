package com.webshop.ecommerce.repo;

import com.webshop.ecommerce.misc.Category;
import com.webshop.ecommerce.model.Product;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);

    //@Query("SELECT p FROM Product p WHERE (p.productName LIKE %:searchString% OR p.productDescription LIKE %:searchString%) AND p.category IN :categories")
//    @Query("SELECT p FROM Product p WHERE " +
//            "(COALESCE(:searchString, '') = '' OR p.productName LIKE %:searchString% OR p.productDescription LIKE %:searchString%) " +
//            "AND (:categories IS NULL OR p.category IN :categories)")
    @Query("SELECT p FROM Product p WHERE " +
            "(COALESCE(:searchString, '') = '' OR p.productName LIKE %:searchString% OR p.productDescription LIKE %:searchString%) " +
            "AND (:categories IS NULL OR p.category IN :categories) " +
            "AND (:types IS NULL OR p.type IN :types) " )
    Page<Product> findBySearchString(@Param("searchString") String searchString, @Param("categories") List<Category> categories, @Param("types") List<String> types, Pageable pageable);
}
