package com.java_backend.weather_api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLocationNotFoundException(LocationNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(404).body(
                new ErrorResponse(404,ex.getMessage(), request.getRequestURI())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericExceptionHandler(Exception ex, HttpServletRequest request){
        return ResponseEntity.status(500).body(
                new ErrorResponse(500,ex.getMessage(), request.getRequestURI())
        );
    }
}
