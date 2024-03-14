package com.webshop.ecommerce.repo;

import com.webshop.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);
}
