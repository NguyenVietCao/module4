package com.example.ss11.service;


import com.example.ss11.model.Product;

import java.util.Optional;

public interface IProductService {

    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
