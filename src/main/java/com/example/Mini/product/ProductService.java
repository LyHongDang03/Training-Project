package com.example.Mini.product;

import com.example.Mini.product.productDTO.requset.CreateProductRequest;
import com.example.Mini.product.productDTO.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //Create product
    public ProductResponse createProduct(CreateProductRequest createProductRequest) throws IOException {

        Product product = new Product();

        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());
        product.setImageURL(createProductRequest.getImageURL());
        productRepository.save(product);

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setImageURL(product.getImageURL());

        return productResponse;
    }
    //Get list products
    public List<ProductResponse> getAllProducts() throws IOException {
        var products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (var product : products) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productResponse.setQuantity(product.getQuantity());
            productResponse.setImageURL(product.getImageURL());
            productResponses.add(productResponse);
        }
        return productResponses;
    }
}
