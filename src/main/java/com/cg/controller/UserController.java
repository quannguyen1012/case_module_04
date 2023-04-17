package com.cg.controller;

import com.cg.model.dto.RoleDto;
import com.cg.model.dto.UserDto;
import com.cg.repository.UserRepository;
import com.cg.service.User.IUserService;
import com.cg.service.role.IRoleService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class UserController {
    private final IUserService userService;
    private final IRoleService roleService;
    private final UserRepository userRepository;

    @ModelAttribute("roleList")
    public List<RoleDto> roleDtos(){
        List<RoleDto> roleDtoList = roleService.findAll();
        return roleDtoList;
    }

    public UserController(IUserService userService, IRoleService roleService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRepository = userRepository;
    }


    @GetMapping("/user")
    public ModelAndView list(){
        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        UserDto user = userService.findByUsername(name);
        ModelAndView modelAndView = new ModelAndView("web_admin/user_list_table");
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("user",user);


        return modelAndView;
    }

    @GetMapping("/user/create-user")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("web_admin/create_basic");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }
    @GetMapping("/create-user")
    public ModelAndView showCreateFormClient(){
        ModelAndView modelAndView = new ModelAndView("sign-up");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping("/user/create-user")
    public ModelAndView save(@ModelAttribute UserDto userDto) {
        userService.save(userDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/user");
        return modelAndView;
    }

    @GetMapping("/user/edit-user-{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web_admin/edit_basic");
        modelAndView.addObject("user", userService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/user/edit-user")
    public ModelAndView edit(@ModelAttribute("user") UserDto userDto) {
        userService.save(userDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/user");
        return modelAndView;
    }

    @GetMapping("/user/delete-user-{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web_admin/delete_basic");
        modelAndView.addObject("user", userService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/user/delete-user")
    public ModelAndView delete(@ModelAttribute("user") UserDto userDto) {
        userService.remove(userDto.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/user");
        return modelAndView;
    }
}

