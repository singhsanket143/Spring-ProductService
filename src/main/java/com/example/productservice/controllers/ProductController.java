package com.example.productservice.controllers;

import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    ProductController(@Qualifier("FakeStoreProxyProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public String getProducts() {
        return "Received a request for a products";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "Received a request for a product with id: " + id;
    }

}
