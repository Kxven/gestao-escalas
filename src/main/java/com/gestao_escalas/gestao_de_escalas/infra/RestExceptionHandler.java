package com.gestao_escalas.gestao_de_escalas.infra;

import com.gestao_escalas.gestao_de_escalas.exceptions.EmployeeNotFoundException;
import com.gestao_escalas.gestao_de_escalas.exceptions.WorkplaceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    private ResponseEntity<StandardError> EmployeeNotFoundException(EmployeeNotFoundException exception, HttpServletRequest request){

        StandardError  error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(exception.getMessage());
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(WorkplaceNotFoundException.class)
    private ResponseEntity<StandardError> WorkplaceNotFoundException(WorkplaceNotFoundException exception, HttpServletRequest request){

        StandardError  error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(exception.getMessage());
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, String> errorList = new LinkedHashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {
            String errorField = ((FieldError) error).getField();
            String errorMsg = error.getDefaultMessage();
            errorList.put(errorField, errorMsg);
        });
        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError(status.getReasonPhrase());
        error.setMessage("Validation Error");
        error.setPath(request.getRequestURI());
        error.setErrors(errorList);
        return ResponseEntity.status(status).body(error);
    }
}
