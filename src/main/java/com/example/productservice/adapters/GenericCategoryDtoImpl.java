package com.example.productservice.adapters;

import com.example.productservice.models.Category;
import com.example.productservice.viewModels.GenericCategoryDto;
import com.example.productservice.viewModels.GenericProductDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericCategoryDtoImpl implements GenericCategoryDtoAdapter{

    Category category;

    /**
     * @return GenericCategoryDto
     */
    @Override
    public GenericCategoryDto convertToGenericProductDto() {
        GenericCategoryDto response = new GenericCategoryDto();
        response.setId(String.valueOf(category.getId()));
        response.setName(category.getName());
        return response;
    }
}
