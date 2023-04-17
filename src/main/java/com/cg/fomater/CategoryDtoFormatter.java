package com.cg.fomater;

import com.cg.model.dto.CategoryDto;
import com.cg.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryDtoFormatter implements Formatter<CategoryDto> {

    private ICategoryService categoryService;

    @Autowired
    public CategoryDtoFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto parse(String text, Locale locale) throws ParseException {
        CategoryDto categoryDto = categoryService.findOne(Long.parseLong(text));
        return categoryDto;
    }

    @Override
    public String print(CategoryDto object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
