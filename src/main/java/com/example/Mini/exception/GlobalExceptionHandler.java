package com.example.Mini.exception;

import com.example.Mini.dto.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ExceptionResponse> handlingAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setCode(errorCode.getCode());
        exceptionResponse.setMessage(errorCode.getMessage());
        exceptionResponse.setStatusCode(errorCode.getHttpStatusCode());

        return ResponseEntity.status(errorCode.getHttpStatusCode()).body(exceptionResponse);
    }
}
