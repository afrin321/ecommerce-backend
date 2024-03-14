package com.webshop.ecommerce.controller;

import com.webshop.ecommerce.dto.ProductRequest;
import com.webshop.ecommerce.dto.ProductResponse;
import com.webshop.ecommerce.dto.SearchProductRequestResponse;
import com.webshop.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static com.webshop.ecommerce.misc.Helpers.saveImage;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/test")
    public String testLink() {
        return "Product Controller Running...";
    }

    @PostMapping("/create")
    ResponseEntity<ProductResponse> createProduct(@ModelAttribute ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping("/find-all")
    ResponseEntity<SearchProductRequestResponse> search(@RequestBody SearchProductRequestResponse request) {
        return ResponseEntity.ok(productService.search(request));
    }
}
