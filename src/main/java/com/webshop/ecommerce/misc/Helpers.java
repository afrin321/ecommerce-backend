package com.webshop.ecommerce.misc;

import com.webshop.ecommerce.dto.SearchProductRequestResponse;
import com.webshop.ecommerce.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Helpers {

    public static String saveImage(MultipartFile image, String filename) {
        try {
            String uniqueFileName = UUID.randomUUID().toString() + "_" + filename;
            System.out.println(uniqueFileName);
            String fileUploadPath = ".\\src\\main\\resources\\images\\products";
            Path filePath = Paths.get(fileUploadPath, uniqueFileName);
            System.out.println(filePath);
            Files.write(filePath, image.getBytes());
            return uniqueFileName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SearchProductRequestResponse convertImages(SearchProductRequestResponse requestResponse) {

        String fileUploadPath = ".\\src\\main\\resources\\images\\products";

        List<Product> products = requestResponse.getProducts().stream().map(product -> {
            Path imagePath = Paths.get(fileUploadPath).resolve(product.getImagePath());
            try {
                byte[] imageData = Files.readAllBytes(imagePath);
                product.setProductImage(imageData);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return product;
        }).collect(Collectors.toList());

        requestResponse.setProducts(products);

        return requestResponse;
    }

}
