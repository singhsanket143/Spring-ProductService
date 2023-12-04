package com.example.productservice.controllers;

import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.services.ProductService;
import com.example.productservice.viewModels.ExceptionDto;
import com.example.productservice.viewModels.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GenericProductDto> getProducts() {
        return this.getProductService().getProducts();
    }

    @GetMapping( "/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return this.getProductService().getProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return this.getProductService().createProduct(product);
    }

    @DeleteMapping ( "/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(this.getProductService().deleteProduct(id), HttpStatus.OK);
    }
}








