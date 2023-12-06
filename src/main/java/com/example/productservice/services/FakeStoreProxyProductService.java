package com.example.productservice.services;

import com.example.productservice.adapters.FakeStoreDtoToGenericDtoAdapter;
import com.example.productservice.apis.FakeStoreProductServiceApi;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.viewModels.FakeStoreProductDto;
import com.example.productservice.viewModels.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("FakeStoreProxyProductService")
public class FakeStoreProxyProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreProductServiceApi fakeStoreProductServiceApi;

    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String getProductBaseUrl = "https://fakestoreapi.com/products";

    FakeStoreProxyProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreProductServiceApi fakeStoreProductServiceApi) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreProductServiceApi = fakeStoreProductServiceApi;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        FakeStoreDtoToGenericDtoAdapter fakeStoreDtoToGenericDtoAdapter = new FakeStoreDtoToGenericDtoAdapter(fakeStoreProductServiceApi.getProductById(id));
        return fakeStoreDtoToGenericDtoAdapter.convertToGenericProductDto();
    }

    /**
     * @return
     */
    @Override
    public List<GenericProductDto> getProducts() {
        List<FakeStoreProductDto> response = (fakeStoreProductServiceApi.getProducts());
        List<GenericProductDto> result = new ArrayList<>();
        for(FakeStoreProductDto product : response) {
            GenericProductDto productResponse = new FakeStoreDtoToGenericDtoAdapter(product).convertToGenericProductDto();
            result.add(productResponse);
        }
        return result;

    }

    /**
     * @param product
     * @return
     */
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        FakeStoreDtoToGenericDtoAdapter fakeStoreDtoToGenericDtoAdapter = new FakeStoreDtoToGenericDtoAdapter(fakeStoreProductServiceApi.createProduct(product));
        return fakeStoreDtoToGenericDtoAdapter.convertToGenericProductDto();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public GenericProductDto deleteProduct(Long id) throws NotFoundException {
        FakeStoreDtoToGenericDtoAdapter fakeStoreDtoToGenericDtoAdapter = new FakeStoreDtoToGenericDtoAdapter(fakeStoreProductServiceApi.deleteProduct(id));
        return fakeStoreDtoToGenericDtoAdapter.convertToGenericProductDto();
    }

    private GenericProductDto getGenericProductDto(FakeStoreProductDto product) {
        GenericProductDto productResponse = new GenericProductDto();
        productResponse.setCategory(product.getCategory());
        productResponse.setId(product.getId());
        productResponse.setTitle(product.getTitle());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setImage(product.getImage());
        return productResponse;
    }
}
