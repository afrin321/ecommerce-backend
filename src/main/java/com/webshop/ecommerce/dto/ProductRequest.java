package com.webshop.ecommerce.dto;

import com.webshop.ecommerce.misc.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private double discount;
    private String type;
    private String subType;
    private Category category;
    private MultipartFile image;
}
