package com.example.Mini.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OderResponse {
    private Long totalAmount;
    private Long discount;
    private List<OderItemResponse> items;
}
