package com.example.Mini.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OderItemResponse {
    private Integer productId;
    private Integer quantity;
    private Long price;
}
