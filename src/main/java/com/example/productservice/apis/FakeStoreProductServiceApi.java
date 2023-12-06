package com.example.productservice.apis;

import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.viewModels.FakeStoreProductDto;
import com.example.productservice.viewModels.GenericProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component // could have used service also but not using as we have a separate service layer
public class FakeStoreProductServiceApi {

    private RestTemplateBuilder restTemplateBuilder;

//    @Value("${fakestore.api.url}")
//    private String fakeStoreApiUrl;
//
//    @Value("${fakestore.api.paths.product}")
//    private String fakeStoreProductsApiPath;
    // Uncomment the above code and remove the same parameters from constructors for debugging exercise to students

    private String specificProductRequestUrl ;
    private String productRequestsBaseUrl ;

    FakeStoreProductServiceApi(RestTemplateBuilder restTemplateBuilder,
                               @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath,
                               @Value("${fakestore.api.url}") String fakeStoreApiUrl) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsBaseUrl  = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
    }


    public FakeStoreProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(this.productRequestsBaseUrl, FakeStoreProductDto.class, id);
        return response.getBody();
    }

    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(this.productRequestsBaseUrl, product, FakeStoreProductDto.class);
        return response.getBody();
    }

    public FakeStoreProductDto deleteProduct(Long id) throws NotFoundException{
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        FakeStoreProductDto response =  restTemplate.execute(this.specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id).getBody();
        if(response == null) {
            throw new NotFoundException("No product with id " + id + " found");
        }
        return response;
    }

    public List<FakeStoreProductDto> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(this.productRequestsBaseUrl, FakeStoreProductDto[].class);
        return List.of(response.getBody());
    }


}
