package com.example.Mini.service.impl;

import com.example.Mini.entity.CartItem;
import com.example.Mini.entity.Product;
import com.example.Mini.repository.CartItemRepository;
import com.example.Mini.repository.ProductRepository;
import com.example.Mini.request.AddToCartRequest;
import com.example.Mini.request.GetCartInfoRequest;
import com.example.Mini.response.CartItemResponse;
import com.example.Mini.response.GetCartInfoResponse;
import com.example.Mini.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Override
    public String addToCart(AddToCartRequest request, Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (request.getQuantity() > product.getQuantity()) {
            throw new RuntimeException("Out of stock. Only left: " + product.getQuantity());
        }
        var item = cartItemRepository.findByUserIdAndProductId(request.getUserId(), productId);
        if (item.isPresent()) {
            var itemId = item.get();
            itemId.setQuantity(itemId.getQuantity() + request.getQuantity());
            cartItemRepository.save(itemId);
        }
        else {
            CartItem cartItem = new CartItem();
            cartItem.setUserId(request.getUserId());
            cartItem.setProductId(productId);
            cartItem.setQuantity(request.getQuantity());
            cartItemRepository.save(cartItem);
        }
        return "Add";
    }

    @Override
    public GetCartInfoResponse getCartInfo(GetCartInfoRequest request) {
        var cartInfo = cartItemRepository.findByUserId(request.getUserId());
        List<CartItemResponse> cartItemResponses = new ArrayList<>();
        long totalAmount = 0;
        for (CartItem cartItem : cartInfo) {
            Product product = productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            CartItemResponse cartItemResponse = new CartItemResponse();
            cartItemResponse.setProductId(product.getId());
            cartItemResponse.setProductName(product.getName());
            cartItemResponse.setProductPrice(product.getPrice());
            cartItemResponse.setQuantity(cartItem.getQuantity());
            cartItemResponse.setImageURL(product.getImageURL());
            long total = product.getPrice() * cartItem.getQuantity();
            totalAmount = totalAmount + total;
            cartItemResponse.setTotal(total);
            cartItemResponses.add(cartItemResponse);

        }
        GetCartInfoResponse getCartInfoResponse = new GetCartInfoResponse();
        getCartInfoResponse.setCartItemResponses(cartItemResponses);
        getCartInfoResponse.setTotalAmount(totalAmount);

        return getCartInfoResponse;
    }
}
