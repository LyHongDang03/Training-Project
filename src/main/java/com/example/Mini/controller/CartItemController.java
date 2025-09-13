package com.example.Mini.controller;

import com.example.Mini.dto.request.AddToCartRequest;
import com.example.Mini.dto.request.GetCartInfoRequest;
import com.example.Mini.dto.response.GetCartInfoResponse;
import com.example.Mini.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cartitems")
@RestController
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;
    @PostMapping("/{productId}")
    public ResponseEntity<String> add(@RequestBody AddToCartRequest request,
                                      @PathVariable Integer productId) {
        return ResponseEntity.ok().body(cartItemService.addToCart(request, productId));
    }

    @GetMapping()
    public ResponseEntity<GetCartInfoResponse> getCartInfo(@RequestBody GetCartInfoRequest request) {
        GetCartInfoResponse response = cartItemService.getCartInfo(request);
        return ResponseEntity.ok().body(response);
    }
}