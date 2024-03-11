package com.hexagonal.restapi.adapter.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hexagonal.restapi.domain.exception.DataConflictException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e) {
        Map<String, Object> errorDetails = buildErrorDetails(HttpStatus.NOT_FOUND, "Dados não encontrados.",
                e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(DataConflictException.class)
    public ResponseEntity<Object> handleDataConflictException(DataConflictException e) {
        Map<String, Object> errorDetails = buildErrorDetails(HttpStatus.CONFLICT, "Conflito de dados.",
                e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    private Map<String, Object> buildErrorDetails(HttpStatus status, String error, String message) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDate.now().toString());
        errorDetails.put("status", status.value());
        errorDetails.put("error", error);
        errorDetails.put("message", message);
        return errorDetails;
    }
}
