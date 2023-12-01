package com.example.productservice.services;

import com.example.productservice.models.Product;

public class FakeStoreProxyProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
