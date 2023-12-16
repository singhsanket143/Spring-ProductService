package com.example.productservice.services;

import com.example.productservice.adapters.GenericCategoryDtoImpl;
import com.example.productservice.models.Category;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.viewModels.GenericCategoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * @return
     */
    @Override
    public List<GenericCategoryDto> getAllCategories() {

        List<Category> response =  this.categoryRepository.findAll();
        List<GenericCategoryDto> result = new ArrayList<>();
        for(Category category : response) {
            GenericCategoryDto categoryDto = new GenericCategoryDtoImpl(category).convertToGenericProductDto();
            result.add(categoryDto);
        }
        return result;
    }
}
