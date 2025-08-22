package com.example.Mini.controller;

import com.example.Mini.response.OderResponse;
import com.example.Mini.service.OderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("checkout")
@RequiredArgsConstructor
public class OderController {
    private final OderService orderService;
    @PostMapping("/{userId}")
    public ResponseEntity<OderResponse> checkout(@PathVariable Integer userId,
                                                 @RequestParam Long discount) throws JsonProcessingException {
        return ResponseEntity.ok().body(orderService.checkout(userId, discount));
    }
}
