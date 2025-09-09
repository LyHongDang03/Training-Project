package com.example.Mini.service;

import com.example.Mini.request.OrderRequest;
import com.example.Mini.response.OderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OderService {
    OderResponse checkout(OrderRequest request) throws JsonProcessingException;
//    List<OderResponse> findOrdersByProductName(String productName);
}
