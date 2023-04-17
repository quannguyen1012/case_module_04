package com.cg.service.cart;

import com.cg.model.dto.ProductDto;
import com.cg.model.entity.CartItem;
import com.cg.model.entity.User;
import com.cg.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService implements CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> cartItems(Long id){
        return cartItemRepository.findByUser(id);
    }

    @Override
    public CartItem save(CartItem cartItem) {

        return cartItemRepository.save(cartItem);
    }

//    public void addQuantityProductDto(ProductDto productDto){
//        if (!checkItemInCart(productDto)){
//            productDtos.put(productDto,1);
//        }else {
//            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
//            Integer newQuantity = itemEntry.getValue() + 1;
//            productDtos.replace(itemEntry.getKey(), newQuantity);
//        }
//    }
}
