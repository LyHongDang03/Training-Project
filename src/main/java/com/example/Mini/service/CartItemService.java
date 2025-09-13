package com.example.Mini.service;

import com.example.Mini.dto.request.AddToCartRequest;
import com.example.Mini.dto.request.GetCartInfoRequest;
import com.example.Mini.dto.response.GetCartInfoResponse;

public interface CartItemService {
    String addToCart(AddToCartRequest addToCartRequest, Integer productId);
    GetCartInfoResponse getCartInfo(GetCartInfoRequest request);
}
