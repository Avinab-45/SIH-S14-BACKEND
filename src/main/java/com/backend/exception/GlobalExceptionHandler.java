package com.backend.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<Map<String,Object>> notFound(ResourceNotFoundException e) {
        return ResponseEntity.status(404).body(error(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e) {
        Map<String,Object> body = error("Validation failed");
        Map<String,String> fields = new HashMap<>();
        e.getBindingResult().getFieldErrors()
            .forEach(x -> fields.put(x.getField(), x.getDefaultMessage()));
        body.put("fields", fields);
        return ResponseEntity.badRequest().body(body);
    }

    private Map<String,Object> error(String message) {
        Map<String,Object> b = new LinkedHashMap<>();
        b.put("timestamp", LocalDateTime.now());
        b.put("message", message);
        return b;
    }
}
