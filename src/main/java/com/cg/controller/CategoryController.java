package com.cg.controller;

import com.cg.model.dto.CategoryDto;
import com.cg.service.category.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping("/category")
    public ModelAndView list(){
        List<CategoryDto> categoryDtos = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("web_admin/category_list_table");
        modelAndView.addObject("category",categoryDtos);
        return modelAndView;
    }
    @GetMapping("/create-category")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("web_admin/create-category");
        modelAndView.addObject("category", new CategoryDto());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView save(@ModelAttribute CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        return modelAndView;
    }

    @GetMapping("/edit-category-{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web_admin/edit-category");
        modelAndView.addObject("category", categoryService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/edit-category")
    public ModelAndView edit(@ModelAttribute("category") CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        return modelAndView;
    }

    @GetMapping("/delete-category-{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web_admin/delete-category");
        modelAndView.addObject("category", categoryService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/delete-category")
    public ModelAndView delete(@ModelAttribute("category") CategoryDto categoryDto) {
        categoryService.remove(categoryDto.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        return modelAndView;
    }

}
