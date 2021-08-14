package com.example.webshop.service;

import com.example.webshop.model.Buyer;

import java.util.Collection;
import java.util.Optional;

public interface BuyerService {

    Collection<Buyer> findAll();
    Optional<Buyer> findById(Long id);
    void save(Buyer buyer);
    void delete(Buyer buyer);
}
