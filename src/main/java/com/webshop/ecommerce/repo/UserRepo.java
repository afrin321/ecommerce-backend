package com.webshop.ecommerce.repo;

import com.webshop.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}
