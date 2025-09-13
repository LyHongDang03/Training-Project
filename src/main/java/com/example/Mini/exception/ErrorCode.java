package com.example.Mini.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
@Getter
public enum ErrorCode {
    PRODUCT_NOT_FOUND(404,"Product Not Found",HttpStatus.NOT_FOUND),
    OUT_OF_STOCK(400,"Out of Stock", HttpStatus.BAD_REQUEST),
    CART_EMPTY(400,"No items in cart", HttpStatus.BAD_REQUEST),
    CART_ITEM_NOT_BELONG_TO_USER(403,"Cart item does not belong to this user", HttpStatus.FORBIDDEN),
    ORDER_NOT_FOUND(404,"Order not found", HttpStatus.NOT_FOUND),
    DISCOUNT_INVALID(400, "Discount must be greater than or equal to 0", HttpStatus.BAD_REQUEST),

    ;
    private final Integer code;
    private final String message;
    private final HttpStatusCode httpStatusCode;

    ErrorCode(Integer code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
