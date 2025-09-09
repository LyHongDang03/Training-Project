package com.example.Mini.controller;

import com.example.Mini.request.OrderRequest;
import com.example.Mini.response.OderResponse;
import com.example.Mini.service.OderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OderService orderService;
    @PostMapping("/checkout")
    public ResponseEntity<OderResponse> checkout(@RequestBody OrderRequest request) throws JsonProcessingException {
        return ResponseEntity.ok().body(orderService.checkout(request));
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<OderResponse>> findOrdersByProductName(@RequestParam String productName) {
//        return ResponseEntity.ok(orderService.findOrdersByProductName(productName));
//    }
}
