package com.example.Mini.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListProductsResponse {
    private Integer id;
    private String name;
    private Long price;
    private Long quantity;
    private String imageURL;
}
