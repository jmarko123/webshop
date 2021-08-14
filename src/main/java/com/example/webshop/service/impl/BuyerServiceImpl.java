package com.example.webshop.service.impl;

import com.example.webshop.model.Buyer;
import com.example.webshop.repository.BuyerRepository;
import com.example.webshop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public Collection<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Optional<Buyer> findById(Long id) {
        return buyerRepository.findById(id);
    }

    @Override
    public void save(Buyer buyer) {
        buyerRepository.save(buyer);

    }

    @Override
    public void delete(Buyer buyer) {
        buyerRepository.delete(buyer);

    }

/*    @Autowired
    private BuyerRepository buyerRepository;*/

/*    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }*/
/*
    public Buyer findById(Long id) {
        return buyerRepository.findById(id).get();
    }

    public void save(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    public void delete(Buyer buyer) {
        buyerRepository.delete(buyer);
    }
}*/
}



