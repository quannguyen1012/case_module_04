package com.cg.service.category;

import com.cg.model.dto.CategoryDto;
import com.cg.model.entity.Categories;
import com.cg.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Categories> categoriesList = categoryRepository.findAll();
        return categoriesList.stream()
                .map(categories -> modelMapper.map(categories, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findOne(Long id) {
        Categories categories = categoryRepository.findById(id).get();
        return modelMapper.map(categories, CategoryDto.class);
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Categories categories = modelMapper.map(categoryDto, Categories.class);
        categoryRepository.save(categories);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
