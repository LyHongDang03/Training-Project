package com.example.Mini.service;

import com.example.Mini.response.OderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OderService {
    OderResponse checkout(Integer userId, long discount) throws JsonProcessingException;
}