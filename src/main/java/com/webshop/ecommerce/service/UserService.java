package com.webshop.ecommerce.service;

import com.webshop.ecommerce.dto.UserDto;
import com.webshop.ecommerce.misc.Role;
import com.webshop.ecommerce.model.User;
import com.webshop.ecommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepo userRepo;

    public String addUser(UserDto userDto) {
        userRepo.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(Role.valueOf("USER"))
                .build());
        return "User Created Successfully";
    }

    public String addAdmin(UserDto userDto) {
        userRepo.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(Role.valueOf("ADMIN"))
                .build());
        return "User Created Successfully";
    }
}
