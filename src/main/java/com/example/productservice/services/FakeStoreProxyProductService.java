package com.example.productservice.services;

import com.example.productservice.models.Product;
import com.example.productservice.viewModels.FakeStoreProductDto;
import com.example.productservice.viewModels.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("FakeStoreProxyProductService")
public class FakeStoreProxyProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String getProductBaseUrl = "https://fakestoreapi.com/products";

    FakeStoreProxyProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> respone = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto product = respone.getBody();
        GenericProductDto productResponse = new GenericProductDto();
        productResponse.setCategory(product.getCategory());
        productResponse.setId(product.getId());
        productResponse.setTitle(product.getTitle());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setImage(product.getImage());
        return productResponse;
    }

    /**
     * @return
     */
    @Override
    public List<GenericProductDto> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(getProductBaseUrl, FakeStoreProductDto[].class);
        List<GenericProductDto> result = new ArrayList<>();
        for(FakeStoreProductDto product : response.getBody()) {
            GenericProductDto productResponse = new GenericProductDto();
            productResponse.setCategory(product.getCategory());
            productResponse.setId(product.getId());
            productResponse.setTitle(product.getTitle());
            productResponse.setDescription(product.getDescription());
            productResponse.setPrice(product.getPrice());
            productResponse.setImage(product.getImage());
            result.add(productResponse);
        }
        return result;

    }
}
