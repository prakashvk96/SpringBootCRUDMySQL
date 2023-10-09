package com.practice.CrudOperation.exceptions;


import com.practice.CrudOperation.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException ex) {
        log.error(
                String.format("Error error message: %s", ex.getMessage())
        );
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "User Not Found", Instant.now());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
         //return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
    }


//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(UserNotFoundException.class)
//    public Map<String, String> userNotFoundException(UserNotFoundException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        errorMap.put("errorMessage", ex.getMessage());
//        return errorMap;
//    }
}
