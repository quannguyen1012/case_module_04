package com.cg.controller;


//import com.cg.model.entity.CartItem;
import com.cg.model.dto.UserDto;
import com.cg.repository.CartItemRepository;
import com.cg.service.User.IUserService;
import com.cg.service.cart.Cart;
import org.springframework.security.core.context.SecurityContextHolder;
import com.cg.service.cart.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {
    private final IUserService userService;
    private CartItemRepository cartItemRepository;
    private CartService cartService;


    public ShoppingCartController(IUserService userService, CartItemRepository cartItemRepository, CartService cartService) {
        this.userService = userService;
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
    }


    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("web-client/cart");
//        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
//        UserDto user = userService.findByUsername(name);
//        if(user != null){
//            modelAndView.addObject("user", user);
//        }
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
