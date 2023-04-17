package com.cg.controller;

import com.cg.model.dto.ProductDto;
import com.cg.service.User.IUserService;
import com.cg.service.product.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class product {
    private final IProductService productService;
    public product( IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1")
    public ResponseEntity<?> list(){
        List<ProductDto> productDtos = productService.findAll();
        if (productDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
}
