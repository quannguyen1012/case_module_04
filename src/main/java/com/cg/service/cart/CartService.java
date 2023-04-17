package com.cg.service.cart;

import com.cg.model.entity.CartItem;
import com.cg.model.entity.User;

import java.util.List;

public interface CartService {
  List<CartItem> cartItems(Long id);
  CartItem save(CartItem cartItem);
}
