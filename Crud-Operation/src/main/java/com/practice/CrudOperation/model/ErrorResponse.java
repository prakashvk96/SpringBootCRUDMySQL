package com.practice.CrudOperation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private Instant timestamp;
//
//    public ErrorResponse(int status, String message) {
//        this.status = status;
//        this.message = message;
//        this.timestamp = System.currentTimeMillis();
//    }

    // Getters and setters
}

