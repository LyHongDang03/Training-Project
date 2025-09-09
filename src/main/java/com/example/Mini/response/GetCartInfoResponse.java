package com.example.Mini.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCartInfoResponse {
    private List<CartItemResponse> cartItemResponses;
    private Long totalAmount;
}
