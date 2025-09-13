package com.example.Mini.controller;

import com.example.Mini.dto.request.OrderRequest;
import com.example.Mini.dto.response.OderResponse;
import com.example.Mini.service.OderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OderService orderService;
    @PostMapping()
    public ResponseEntity<OderResponse> checkout(@RequestBody OrderRequest request) throws JsonProcessingException {
        return ResponseEntity.ok().body(orderService.checkout(request));
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<OderResponse>> findOrdersByProductName(@RequestParam String productName) {
//        return ResponseEntity.ok(orderService.findOrdersByProductName(productName));
//    }
}
