package com.shop.online.dao;

import com.shop.online.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findByOrderByPrice();
    List<Product> findByOrderByPriceDesc();
}
