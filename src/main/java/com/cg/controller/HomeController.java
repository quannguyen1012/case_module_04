package com.cg.controller;

import com.cg.model.dto.UserDto;
import com.cg.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping({"/","/shop-watch/admin"})
    public ModelAndView view(){
        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        UserDto user = userService.findByUsername(name);
        ModelAndView modelAndView = new ModelAndView("web_admin/index");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
