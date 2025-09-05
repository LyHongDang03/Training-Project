package com.example.Mini.service.impl;

import com.example.Mini.entity.Product;
import com.example.Mini.repository.ProductRepository;
import com.example.Mini.request.CreateProductRequest;
import com.example.Mini.response.GetListProductsResponse;
import com.example.Mini.response.ProductResponse;
import com.example.Mini.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {

        Product product = new Product();

        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());
        product.setImageURL(createProductRequest.getImageURL());
        productRepository.save(product);

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());

        return productResponse;
    }

    @Override
    public List<GetListProductsResponse> getAllProducts(){
        var products = productRepository.findAll();
        List<GetListProductsResponse> productResponses = new ArrayList<>();
        for (var product : products) {
            GetListProductsResponse productResponse = new GetListProductsResponse();
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
