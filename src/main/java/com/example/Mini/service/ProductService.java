package com.example.Mini.service;

import com.example.Mini.entity.Product;
import com.example.Mini.file.FileCloudinaryService;
import com.example.Mini.repository.ProductRepository;
import com.example.Mini.request.CreateProductRequest;
import com.example.Mini.request.UpdateProductRequest;
import com.example.Mini.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final FileCloudinaryService fileCloudinaryService;

    public ProductResponse createProduct(CreateProductRequest createProductRequest) throws IOException {

        Product product = new Product();

        product.setProductName(createProductRequest.getProductName());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());

        String urlImage = fileCloudinaryService.uploadFile(createProductRequest.getFile(), createProductRequest.getFolder());
        product.setImageUrl(urlImage);
        productRepository.save(product);

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setProductName(product.getProductName());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setImageUrl(product.getImageUrl());

        return productResponse;
    }

    public ProductResponse updateProduct(UpdateProductRequest updateProductRequest) throws IOException {

        Product productId = productRepository.findById(updateProductRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productId.setProductName(updateProductRequest.getProductName());
        productId.setPrice(updateProductRequest.getPrice());
        productId.setQuantity(updateProductRequest.getQuantity());
        String urlImage = fileCloudinaryService.uploadFile(updateProductRequest.getFile(), updateProductRequest.getFolder());
        productId.setImageUrl(urlImage);

        productRepository.save(productId);

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(productId.getId());
        productResponse.setProductName(productId.getProductName());
        productResponse.setPrice(productId.getPrice());
        productResponse.setQuantity(productId.getQuantity());
        productResponse.setImageUrl(productId.getImageUrl());

        return productResponse;
    }

    public ProductResponse getProductById(Integer id) throws IOException {

        Product productId = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productId.getId());
        productResponse.setProductName(productId.getProductName());
        productResponse.setPrice(productId.getPrice());
        productResponse.setQuantity(productId.getQuantity());
        productResponse.setImageUrl(productId.getImageUrl());

        return productResponse;
    }

    public List<ProductResponse> getAllProducts() throws IOException {
        var products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (var product : products) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setProductName(product.getProductName());
            productResponse.setPrice(product.getPrice());
            productResponse.setQuantity(product.getQuantity());
            productResponse.setImageUrl(product.getImageUrl());
            productResponses.add(productResponse);
        }
        return productResponses;
    }

    public String deleteProductById(Integer id) throws IOException {
        var productId = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(productId);

        return "Product deleted";
    }
}
