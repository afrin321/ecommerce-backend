package com.webshop.ecommerce.dto;

import com.webshop.ecommerce.model.Product;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {
    public Product product;
}
