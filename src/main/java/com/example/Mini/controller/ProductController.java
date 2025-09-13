package com.example.Mini.controller;

import com.example.Mini.dto.request.CreateProductRequest;
import com.example.Mini.dto.response.GetListProductsResponse;
import com.example.Mini.dto.response.ProductResponse;
import com.example.Mini.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private  final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        var result = productService.createProduct(request);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<GetListProductsResponse>> findAll() {
        var result = productService.getAllProducts();
        return ResponseEntity.ok().body(result);
    }
}
