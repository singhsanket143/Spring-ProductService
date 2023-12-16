package com.example.productservice.services;

import com.example.productservice.viewModels.GenericCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<GenericCategoryDto> getAllCategories();
}
