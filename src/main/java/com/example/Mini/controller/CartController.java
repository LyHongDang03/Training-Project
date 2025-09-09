package com.example.Mini.controller;

import com.example.Mini.request.AddToCartRequest;
import com.example.Mini.request.GetCartInfoRequest;
import com.example.Mini.response.GetCartInfoResponse;
import com.example.Mini.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cartItems")
@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartItemService cartItemService;
    @PostMapping("/add/{productId}")
    public ResponseEntity<String> add(@RequestBody AddToCartRequest request,
                                      @PathVariable Integer productId) {
        return ResponseEntity.ok().body(cartItemService.addToCart(request, productId));
    }

    @GetMapping("/info")
    public ResponseEntity<GetCartInfoResponse> getCartInfo(@RequestBody GetCartInfoRequest request) {
        GetCartInfoResponse response = cartItemService.getCartInfo(request);
        return ResponseEntity.ok().body(response);
    }
}