package com.example.Mini.service;

import com.example.Mini.request.CreateProductRequest;
import com.example.Mini.response.GetListProductsResponse;
import com.example.Mini.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    List<GetListProductsResponse> getListProducts();
}