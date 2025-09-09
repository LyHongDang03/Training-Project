package com.example.Mini.service.impl;

import com.example.Mini.entity.CartItem;
import com.example.Mini.entity.Order;
import com.example.Mini.entity.Product;
import com.example.Mini.repository.CartItemRepository;
import com.example.Mini.repository.OderRepository;
import com.example.Mini.repository.ProductRepository;
import com.example.Mini.request.OrderRequest;
import com.example.Mini.response.OderItemResponse;
import com.example.Mini.response.OderResponse;
import com.example.Mini.service.OderService;
import com.example.Mini.statusEnum.StatusEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OderServiceImpl implements OderService {
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final OderRepository oderRepository;

    @Override
    public OderResponse checkout(OrderRequest request) throws JsonProcessingException {
//      List<CartItem> cartItems = cartItemRepository.findByUserId(userId);
        List<CartItem> cartItems = cartItemRepository.findAllById(request.getCartItemId());

        if (cartItems.isEmpty()){
            throw new RuntimeException("User No item " + request.getCartItemId() + " in cart ");
        }
        boolean valid = true;
        for (CartItem cartItem : cartItems) {
            if (!cartItem.getUserId().equals(request.getUserId())) {
                valid = false;
                break;
            }
        }
        if (!valid){
            throw new RuntimeException("CartItem does not belong to this user");
        }
        List<OderItemResponse> listOderItemResponses = new ArrayList<>();
        long total = 0;
        for (CartItem cartItem : cartItems) {
            Product product = productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            if (product.getQuantity() < cartItem.getQuantity()){
                throw new RuntimeException("Insufficient quantity for product " + cartItem.getProductId());
            }
            else {
                OderItemResponse oderItemResponse = new OderItemResponse();
                oderItemResponse.setProductId(product.getId());
                oderItemResponse.setQuantity(cartItem.getQuantity());
                oderItemResponse.setPrice(product.getPrice());
                var amount = cartItem.getQuantity() * product.getPrice();
                total = total + amount;
                product.setQuantity(product.getQuantity() - cartItem.getQuantity());
                listOderItemResponses.add(oderItemResponse);
                productRepository.save(product);
            }
        }
        Long totalAmount = total - request.getDiscount();
        OderResponse orderResponse = new OderResponse();
        orderResponse.setTotalAmount(totalAmount);
        orderResponse.setDiscount(request.getDiscount());
        orderResponse.setItems(listOderItemResponses);
            Order order = new Order();
            order.setUserId(request.getUserId());
            order.setDate(LocalDateTime.now());
            order.setData(
                    new ObjectMapper().writeValueAsString(orderResponse)
            );
            order.setStatus(StatusEnum.SUCCESS);
            oderRepository.save(order);
        cartItemRepository.deleteAll(cartItems);
        return orderResponse;
    }
}
