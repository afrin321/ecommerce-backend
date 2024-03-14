package com.webshop.ecommerce.service;

import com.webshop.ecommerce.dto.ProductRequest;
import com.webshop.ecommerce.dto.ProductResponse;
import com.webshop.ecommerce.dto.SearchProductRequestResponse;
import com.webshop.ecommerce.model.Product;
import com.webshop.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.webshop.ecommerce.misc.Helpers.saveImage;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ProductResponse createProduct(ProductRequest productRequest) {
        String filename = saveImage(productRequest.getImage(), productRequest.getImage().getOriginalFilename());

        return ProductResponse.builder().product(
                productRepo.save(Product.builder()
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .price(productRequest.getPrice())
                .discount(productRequest.getDiscount())
                .type(productRequest.getType())
                .subType(productRequest.getSubType())
                .category(productRequest.getCategory())
                .imagePath(filename)
                .build()
                )
        ).build();
    }

    public ProductResponse updateProduct(ProductRequest productRequest) {
        String filename = saveImage(productRequest.getImage(), productRequest.getImage().getOriginalFilename());

        return ProductResponse.builder().product(
                productRepo.save(Product.builder()
                        .productName(productRequest.getProductName())
                        .productDescription(productRequest.getProductDescription())
                        .price(productRequest.getPrice())
                        .discount(productRequest.getDiscount())
                        .type(productRequest.getType())
                        .subType(productRequest.getSubType())
                        .category(productRequest.getCategory())
                        .imagePath(filename)
                        .build()
                )
        ).build();
    }

    public SearchProductRequestResponse search(SearchProductRequestResponse request) {
        PageRequest pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Product> productList =  productRepo.findAll(pageable);
        request.setProducts(productList.getContent());
        request.setPages(productList);
        return request;
    }


}
