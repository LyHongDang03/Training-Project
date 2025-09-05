package com.example.Mini.controller;

import com.example.Mini.request.CreateProductRequest;
import com.example.Mini.response.ProductResponse;
import com.example.Mini.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private  final ProductServiceImpl productServiceImpl;

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) throws IOException {
        var result = productServiceImpl.createProduct(request);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> findAll() throws IOException {
        var result = productServiceImpl.getAllProducts();
        return ResponseEntity.ok().body(result);
    }
}
