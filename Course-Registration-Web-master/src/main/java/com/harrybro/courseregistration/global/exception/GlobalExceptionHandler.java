package com.harrybro.courseregistration.global.exception;

import com.harrybro.courseregistration.domain.user.exception.UsernameDuplicateException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
        Map<String, Map<String, String>> responseError = new HashMap<>();
        responseError.put("error-message", errors);
        return ResponseEntity.badRequest().body(responseError);
    }

    @ExceptionHandler({UsernameDuplicateException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String, String>> handleRuntimeException(Exception e) {
        Map<String, String> error = new HashMap<>();
        error.put("error-message", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}
