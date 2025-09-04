package com.example.Mini.product;

import com.example.Mini.product.productDTO.requset.CreateProductRequest;
import com.example.Mini.product.productDTO.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private  final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) throws IOException {
        var result = productService.createProduct(request);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> findAll() throws IOException {
        var result = productService.getAllProducts();
        return ResponseEntity.ok().body(result);
    }
}
