package com.example.Mini.service;

import com.example.Mini.dto.request.CreateProductRequest;
import com.example.Mini.dto.response.GetListProductsResponse;
import com.example.Mini.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    List<GetListProductsResponse> getAllProducts();
}
