package com.example.Mini.service;

import com.example.Mini.request.AddToCartRequest;
import com.example.Mini.request.GetCartInfoRequest;
import com.example.Mini.response.GetCartInfoResponse;

public interface CartItemService {
    String addToCart(AddToCartRequest addToCartRequest, Integer productId);
    GetCartInfoResponse getCartInfo(GetCartInfoRequest request);
}
