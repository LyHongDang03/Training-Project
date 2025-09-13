package com.example.Mini.service;

import com.example.Mini.dto.request.OrderRequest;
import com.example.Mini.dto.response.OderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OderService {
    OderResponse checkout(OrderRequest request) throws JsonProcessingException;
//    List<OderResponse> findOrdersByProductName(String productName);
}
