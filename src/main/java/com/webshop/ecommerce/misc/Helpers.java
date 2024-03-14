package com.webshop.ecommerce.misc;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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

}
