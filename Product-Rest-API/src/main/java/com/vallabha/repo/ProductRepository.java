package com.vallabha.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vallabha.entites.Product;

public interface ProductRepository extends JpaRepository<Product,Serializable> {

}
