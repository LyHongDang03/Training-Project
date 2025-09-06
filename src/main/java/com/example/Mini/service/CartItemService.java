package com.example.Mini.service;

public interface CartItemService {
    String addToCart(Integer userId, Integer productId, Integer quantity);
}