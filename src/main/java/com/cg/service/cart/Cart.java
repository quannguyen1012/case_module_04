package com.cg.service.cart;

import com.cg.model.dto.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;


@Service
@SessionScope
public class Cart {
    private Map<ProductDto, Integer> productDtos = new HashMap<>();

    public Cart(){}

    public Cart(Map<ProductDto, Integer> productDtos) {
        this.productDtos = productDtos;
    }

    public Map<ProductDto, Integer> getProductDtos(){
        return productDtos;
    }

    private Boolean checkItemInCart(ProductDto productDto){
        for (Map.Entry<ProductDto, Integer> entry : productDtos.entrySet()) {
            if(entry.getKey().getId().equals(productDto.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto productDto){
        for (Map.Entry<ProductDto, Integer> entry : productDtos.entrySet()){
            if (entry.getKey().getId().equals(productDto.getId())){
                return entry;
            }
        }
        return null;
    }

//    public void addNewProductDto(ProductDto productDto){
//        if (!checkItemInCart(productDto)){
//            productDtos.put(productDto,1);
//        }
//    }


    public void addQuantityProductDto(ProductDto productDto){
        if (!checkItemInCart(productDto)){
            productDtos.put(productDto,1);
        }else {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
            Integer newQuantity = itemEntry.getValue() + 1;
            productDtos.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void minusProductDto(ProductDto productDto){
        Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
        Integer newQuantity = itemEntry.getValue() - 1;
        if (newQuantity > 0) {
            productDtos.replace(itemEntry.getKey(), newQuantity);
        }else {
            productDtos.remove(itemEntry.getKey());
        }
    }

    public Integer countProductDtoQuantity() {
        Integer productDtoQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtos.entrySet()) {
            if (productDtoQuantity >= 0) productDtoQuantity += entry.getValue();
        }
        if (productDtoQuantity > 0){
            return productDtoQuantity;
        }
        return 0;
    }

    public Integer countItemQuantity(){
        return productDtos.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtos.entrySet()){
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        if (payment > 0) {
            return payment;
        }
        return 0.0f;
    }
}
