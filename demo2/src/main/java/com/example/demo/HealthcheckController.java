package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HealthcheckController {

    private boolean isDatabaseOk() {
        return true;
    }

    @GetMapping("/api/healthcheck")
    public String livenessCheck() {
        if (!isDatabaseOk()) {  // DB에 이상이 있는 경우
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
        }

        return "OK";
    }
}
