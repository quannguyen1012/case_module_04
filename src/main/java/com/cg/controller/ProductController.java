package com.cg.controller;

import com.cg.model.dto.*;
import com.cg.service.User.IUserService;
import com.cg.service.brand.IBrandService;
import com.cg.service.cart.Cart;
import com.cg.service.category.ICategoryService;
import com.cg.service.company.ICompanyService;
import com.cg.service.madeIn.IMadeInService;
import com.cg.service.product.IProductService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@SessionAttributes("cart")
public class ProductController {
    private final IProductService productService;
    private final IUserService userService;

    private final ICategoryService categoryService;
    private final IMadeInService madeInService;
    private final IBrandService brandService;

    private final ICompanyService companyService;

    public ProductController(IProductService productService, IUserService userService, ICategoryService categoryService, IMadeInService madeInService, IBrandService brandService, ICompanyService companyService) {
        this.productService = productService;
        this.userService = userService;

        this.categoryService = categoryService;
        this.madeInService = madeInService;
        this.brandService = brandService;
        this.companyService = companyService;
    }


    @ModelAttribute("cart")
    public Cart setCart(){
        return new Cart();
    }
    @ModelAttribute("categoryList")
    public List<CategoryDto> categoryDtos(){
        return categoryService.findAll();
    }
    @ModelAttribute("madeInList")
    public List<MadeInDto> madeInDtos(){
        return madeInService.findAll();
    }
    @ModelAttribute("company")
    public List<CompanyDto> companyDtos(){
        return companyService.findAll();
    }
    @ModelAttribute("brand")
    public List<BrandDto> brandDtos(){
        return brandService.findAll();
    }



    @GetMapping("/shop/product-details/{id}")
    public ModelAndView details(@PathVariable Long id ){
        ProductDto product = productService.findOne(id);
//        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
//        UserDto user = userService.findByUsername(name);
        ModelAndView modelAndView = new ModelAndView("web-client/product-details");
//        if(user != null){
//            modelAndView.addObject("user", user);
//        }
        modelAndView.addObject("product", product);
        return modelAndView;
    }


    @GetMapping("/shop-brand-{id}")
    public ModelAndView listBrand(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("web-client/shop");
        modelAndView.addObject("products",productService.findAllByBrand(id));
        return modelAndView;
    }
    @GetMapping("/shop-company-{id}")
    public ModelAndView listCompany(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("web-client/shop");
        modelAndView.addObject("products",productService.findAllByCompany(id));
        return modelAndView;
    }
    @GetMapping("/shop-category-{id}")
    public ModelAndView listCategory(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("web-client/shop");
        modelAndView.addObject("products",productService.findAllByCategories(id));
        return modelAndView;
    }
    @GetMapping("/shop")
    public ModelAndView listProduct(@RequestParam("search") Optional<String> search){

        List<ProductDto> productDtoList;
        if (search.isPresent()){
            productDtoList =  productService.findAllByNameContaining(search.get());
        }else {
            productDtoList = productService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("web-client/shop");
//        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
//        UserDto user = userService.findByUsername(name);
//        if(user != null){
//            modelAndView.addObject("user", user);
//        }
        modelAndView.addObject("products", productDtoList);
        return modelAndView;
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart,
                            @RequestParam("action") String action){
        ProductDto product = productService.findOne(id);

        if (action.equals("add")){
            cart.addQuantityProductDto(product);
            return "redirect:/shopping-cart";
        }
        if (action.equals("minus")){
            cart.minusProductDto(product);
            return "redirect:/shopping-cart";
        }
        if (action.equals("add-in-detail")){
            cart.addQuantityProductDto(product);
            return "redirect:/shop/product-details/{id}";
        }
        cart.addQuantityProductDto(product);
        return "redirect:/shop";
    }
}
