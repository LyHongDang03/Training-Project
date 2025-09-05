package com.example.Mini.controller;

import com.example.Mini.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartItemService cartItemService;
    @PostMapping("/add/{userId}/{productId}")
    public ResponseEntity<String> add(@PathVariable Integer userId,
                                      @PathVariable Integer productId,
                                      @RequestParam Integer quantity) {
        return ResponseEntity.ok().body(cartItemService.addToCart(userId, productId, quantity));
    }
}
