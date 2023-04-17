package com.cg.repository;

import com.cg.model.entity.CartItem;
import com.cg.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query(nativeQuery = true,
        value = "SELECT * FROM cart_item " +
                "INNER JOIN products ON cart_item.product_id = products.id " +
                "WHERE user_id = :id")
    List<CartItem> findByUser(@Param(value = "id") Long id);
}
