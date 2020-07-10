package com.tvh.warehouseManager.controller;

import com.tvh.warehouseManager.exception.ApiError;
import com.tvh.warehouseManager.exception.NoCapacityLeftException;
import java.util.NoSuchElementException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * When an error occures, this controller is responsible for sending the error back in a response.
 * 
 * @author simon
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    /**
    * <p>This method will handle a HttpRequestMethodNotSupportedException</p>
    * @param ex The exception
    * @param headers The header of the HTTP request
    * @param status The status of the error
    * @param request The request object
    * @return a response entity with the error
    * @since 1.0
    */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "The API is not valid";
        return buildResponseEntity(new ApiError(HttpStatus.NOT_IMPLEMENTED, error, ex));
    }
    
    /**
    * <p>This method will handle a MissingPathVariableException</p>
    * @param ex The exception
    * @param headers The header of the HTTP request
    * @param status The status of the error
    * @param request The request object
    * @return a response entity with the error
    * @since 1.0
    */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "One of the pathvariables is missing.";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }
    
    /**
    * <p>This method will build the response entity to send to the client</p>
    * @param apiError The error object
    * @return a response entity with the error
    * @since 1.0
    */
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
    
    /**
    * <p>This method will handle a NoCapacityLeftException</p>
    * @param ex The exception
    * @return a response entity with the error
    * @since 1.0
    */
    @ExceptionHandler(NoCapacityLeftException.class)
    protected ResponseEntity<Object> handleEntityNotFound(NoCapacityLeftException ex) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    
    /**
    * <p>This method will handle a NoSuchElementException</p>
    * @param ex The exception
    * @return a response entity with the error
    * @since 1.0
    */
    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> handleNoSuchElement(NoSuchElementException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    
    /**
    * <p>This method will handle a ConstraintViolationException</p>
    * @param ex The exception
    * @return a response entity with the error
    * @since 1.0
    */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT);
        apiError.setMessage("There is an issue in the database regarding the mapping");
        return buildResponseEntity(apiError);
    }
}
