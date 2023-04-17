//package com.cg.model.dto;
//
//import com.cg.model.entity.Product;
//import com.cg.model.entity.User;
//
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//public class CartItemDto {
//    private Long id;
//
//
//
//    private User user;
//
//
//    private Product product;
//
//    private Integer quantity;
//
//    public CartItemDto(Long id, User user, Product product, Integer quantity) {
//        this.id = id;
//        this.user = user;
//        this.product = product;
//        this.quantity = quantity;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//}
