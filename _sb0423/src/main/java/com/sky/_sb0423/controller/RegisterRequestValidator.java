package com.sky._sb0423.controller;

import com.sky._sb0423.spring.RegisterRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest registerRequest = (RegisterRequest) target;
        if (registerRequest.getEmail() == null ||
                       registerRequest.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required");
        }
    }
}
