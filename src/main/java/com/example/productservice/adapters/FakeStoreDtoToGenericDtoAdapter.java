package com.example.productservice.adapters;

import com.example.productservice.viewModels.FakeStoreProductDto;
import com.example.productservice.viewModels.GenericProductDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FakeStoreDtoToGenericDtoAdapter implements GenericDtoAdapter{

    FakeStoreProductDto fakeStoreProductDto;


    /**
     * @param productDto
     * @return
     */
    @Override
    public GenericProductDto convertToGenericProductDto( ) {
        GenericProductDto response = new GenericProductDto();
        response.setCategory(fakeStoreProductDto.getCategory());
        response.setId(fakeStoreProductDto.getId());
        response.setTitle(fakeStoreProductDto.getTitle());
        response.setDescription(fakeStoreProductDto.getDescription());
        response.setPrice(fakeStoreProductDto.getPrice());
        response.setImage(fakeStoreProductDto.getImage());
        return response;
    }
}
