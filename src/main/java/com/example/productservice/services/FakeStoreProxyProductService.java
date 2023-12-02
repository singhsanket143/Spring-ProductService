package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("FakeStoreProxyProductService")
public class FakeStoreProxyProductService implements ProductService{
    @Override
    public String getProductById(Long id) {
        return "Fake product";
    }
}
