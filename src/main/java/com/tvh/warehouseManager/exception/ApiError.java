package com.tvh.warehouseManager.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;

/**
 * This class is responsible for making errormessages more readible for clients.
 *
 * @author simon
 */
public class ApiError {
    /**
    * The status of the error
    */
    private HttpStatus status;
    
    /**
    * The timestamp of the error
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    
    /**
    * The message of the error
    */
    private String message;
    
    /**
    * The debugmessage of the error
    */
    private String debugMessage;
    
    /**
    * A list of other errors that happened
    */
    private List<ApiSubError> subErrors;
    
    private ApiError() {
        timestamp = LocalDateTime.now();
    }
    
    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }
    
    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }

    
}
