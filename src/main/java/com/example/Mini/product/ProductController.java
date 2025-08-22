package com.example.Mini.product;

import com.example.Mini.product.productDTO.requset.CreateProductRequest;
import com.example.Mini.product.productDTO.requset.UpdateProductRequest;
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

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> createProduct(@ModelAttribute CreateProductRequest request) throws IOException {
        var result = productService.createProduct(request);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductResponse>> findAll() throws IOException {
        var result = productService.getAllProducts();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Integer id) throws IOException {
        var result = productService.getProductById(id);
        return ResponseEntity.ok().body(result);
    }
    @PutMapping("/update")
    public ResponseEntity<ProductResponse> updateProduct(@ModelAttribute UpdateProductRequest request) throws IOException {
        var result = productService.updateProduct(request);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(productService.deleteProductById(id));
    }
}
