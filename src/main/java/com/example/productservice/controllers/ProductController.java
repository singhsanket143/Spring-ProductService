package com.example.productservice.controllers;

import com.example.productservice.services.ProductService;
import com.example.productservice.viewModels.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ApplicationContext context;
    private final String productServiceType;

    @Autowired
    public ProductController(ApplicationContext context,
                             @Value("${ProductService.type}") String productServiceType) {
        this.context = context;
        this.productServiceType = productServiceType;
    }

    private ProductService getProductService() {
        return context.getBean(productServiceType, ProductService.class);
    }

    @GetMapping
    public GenericProductDto getProducts() {
        return this.getProductService().getProductById((Long) (10L));
    }

    @GetMapping( "/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return this.getProductService().getProductById(id);
    }

}
