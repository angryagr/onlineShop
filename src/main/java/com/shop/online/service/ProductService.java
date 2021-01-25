package com.shop.online.service;

import com.shop.online.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void delete(long id);
    Product readById(long id);
    List<Product> sortByPriceAsc();
    List<Product> sortByPriceDesc();
}
