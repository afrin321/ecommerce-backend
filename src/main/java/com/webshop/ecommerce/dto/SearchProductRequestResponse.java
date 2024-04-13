package com.webshop.ecommerce.dto;

import com.webshop.ecommerce.model.Product;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchProductRequestResponse {
    private int page;
    private int size;
    private List<Product> products;
    private Page<Product> pages;
    private String searchString;
    private List<String> categories;
    private String sortByPrice;
    private List<String> types;
}
