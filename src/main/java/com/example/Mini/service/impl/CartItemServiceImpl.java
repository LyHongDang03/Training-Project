package com.example.Mini.service.impl;

import com.example.Mini.entity.CartItem;
import com.example.Mini.entity.Product;
import com.example.Mini.repository.CartItemRepository;
import com.example.Mini.repository.ProductRepository;
import com.example.Mini.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Override
    public String addToCart(Integer userId, Integer productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (quantity > product.getQuantity()) {
            throw new RuntimeException("Out of stock. Only left: " + product.getQuantity());
        }
        var item = cartItemRepository.findByUserIdAndProductId(userId, productId);
        if (item.isPresent()) {
            var itemId = item.get();
            itemId.setQuantity(itemId.getQuantity() + quantity);
            cartItemRepository.save(itemId);
        }
        else {
            CartItem cartItem = new CartItem();
            cartItem.setUserId(userId);
            cartItem.setProductId(productId);
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
        return "Add";
    }
}
