package com.example.Mini.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private Integer productId;
    private String productName;
    private Long price;
    private Long quantity;
    private MultipartFile file;
    private String folder;
}
