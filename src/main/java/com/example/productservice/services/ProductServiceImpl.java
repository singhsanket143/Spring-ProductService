package com.example.productservice.services;

import com.example.productservice.models.Product;
import com.example.productservice.viewModels.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{

    /**
     * @param id
     * @return
     */
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<GenericProductDto> getProducts() {
        return null;
    }

    /**
     * @param product
     * @return
     */
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }
}
