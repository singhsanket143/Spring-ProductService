package com.example.productservice.services;

import com.example.productservice.models.Product;
import com.example.productservice.viewModels.GenericProductDto;
import org.springframework.stereotype.Service;

/**
 *
 * We need an interface here because controller's usage of this product service should not be
 * impacted by any change in impl.
 * Currently, we will make ProductService Bring data from some free api, later we might have our own implementation.
 * This happens a lot of times because our business logic changes, and we cannot immediately migrate our business logic
 * usage everywhere.
 */
@Service
public interface ProductService {

    GenericProductDto getProductById(Long id);
}
