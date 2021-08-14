package com.example.webshop.service;

import com.example.webshop.model.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void delete(Product product);
}
