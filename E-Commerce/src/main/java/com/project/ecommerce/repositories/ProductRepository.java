package com.project.ecommerce.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{

}
