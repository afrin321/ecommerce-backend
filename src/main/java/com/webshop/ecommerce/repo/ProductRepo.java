package com.webshop.ecommerce.repo;

import com.webshop.ecommerce.model.Product;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);
}
