package com.jsp.FlipShop_ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.FlipShop_ecommerce.entity.User;

public interface userRepo extends JpaRepository<User, Integer> {
boolean existsByEmail(String adminEmail);

Optional<User> findByEmail(String email);

}
