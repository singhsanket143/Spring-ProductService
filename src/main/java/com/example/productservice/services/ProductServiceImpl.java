package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{

    /**
     * @param id
     * @return
     */
    @Override
    public String getProductById(Long id) {
        return "Actual";
    }
}
