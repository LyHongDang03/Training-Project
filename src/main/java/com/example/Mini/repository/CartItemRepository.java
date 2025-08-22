package com.example.Mini.repository;

import com.example.Mini.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    Optional<CartItem>findByUserIdAndProductId(Integer userId, Integer productId);

    List<CartItem> findByUserId(Integer userId);

    CartItem deleteByProductIdAndUserId(Integer productId, Integer userId);
}
