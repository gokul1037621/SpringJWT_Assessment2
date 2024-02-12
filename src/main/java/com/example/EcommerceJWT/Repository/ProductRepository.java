package com.example.EcommerceJWT.Repository;

import com.example.EcommerceJWT.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Jpa extended through product to have access to built in db functions
}