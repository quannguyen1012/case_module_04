package com.cg.admin;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminProductController {
    private final IProductService productService;
    private final IUserService userService;
    private final ICategoryService categoryService;
    private final IMadeInService madeInService;
    private final IBrandService brandService;

    private final ICompanyService companyService;

    public AdminProductController(IProductService productService, IUserService userService, ICategoryService categoryService, IMadeInService madeInService, IBrandService brandService, ICompanyService companyService) {
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


    @GetMapping("/admin/products")
    public ModelAndView list(){
        List<ProductDto> productDtoList = productService.findAll();
        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        UserDto user = userService.findByUsername(name);
        ModelAndView modelAndView = new ModelAndView("web_admin/watch_list_table");
        modelAndView.addObject("products",productDtoList);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @GetMapping("/admin/create-product")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("web_admin/create-product");
        modelAndView.addObject("product", new ProductDto());
        return modelAndView;
    }

    @PostMapping("/admin/create-product")
    public ModelAndView save(@ModelAttribute ProductDto productDto) {
        productService.save(productDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/products");
        return modelAndView;
    }

    @GetMapping("/admin/edit-product-{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web_admin/edit-product");
        modelAndView.addObject("product", productService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/admin/edit-product")
    public ModelAndView edit(@ModelAttribute("product") ProductDto productDto) {
        productService.save(productDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/products");
        return modelAndView;
    }

    @GetMapping("/admin/delete-product-{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web_admin/delete-product");
        modelAndView.addObject("product", productService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/admin/delete-product")
    public ModelAndView delete(@ModelAttribute("product") ProductDto productDto) {
        productService.remove(productDto.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/products");
        return modelAndView;
    }

}
