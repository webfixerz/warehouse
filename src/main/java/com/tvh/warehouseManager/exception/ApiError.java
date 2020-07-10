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
    
    /**
    * <p>This is a hidden constructor of ApiError</p>
    * @since 1.0
    */
    private ApiError() {
        timestamp = LocalDateTime.now();
    }
    
    /**
    * <p>This is a constructor of ApiError</p>
    * @param status the status of the error
    * @since 1.0
    */
    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }
    
    /**
    * <p>This is a constructor of ApiError</p>
    * @param status the status of the error
    * @param ex the exception
    * @since 1.0
    */
    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }
    
    /**
    * <p>This is a constructor of ApiError</p>
    * @param status the status of the error
    * @param message the message of the error
    * @param ex the exception
    * @since 1.0
    */
    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    /**
    * <p>This method will return the status of the error</p>
    * @return the status
    * @since 1.0
    */
    public HttpStatus getStatus() {
        return status;
    }

    /**
    * <p>This method will set a new status for the error</p>
    * @param status the new status-
    * @since 1.0
    */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
    * <p>This method will return the timestamp</p>
    * @return the timestamp
    * @since 1.0
    */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
    * <p>This method will set a timestamp when the error happened</p>
    * @param timestamp a new timestamp
    * @since 1.0
    */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
    * <p>This method will return the message</p>
    * @return the message
    * @since 1.0
    */
    public String getMessage() {
        return message;
    }

    /**
    * <p>This method will set a new message</p>
    * @param message the new message
    * @since 1.0
    */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
    * <p>This method will return the debugMessage</p>
    * @return the debugMessage
    * @since 1.0
    */
    public String getDebugMessage() {
        return debugMessage;
    }

    /**
    * <p>This method will set a debugMessage</p>
    * @param debugMessage the new debugMessage
    * @since 1.0
    */
    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    /**
    * <p>This method will return the subErrors</p>
    * @return the subErrors
    * @since 1.0
    */
    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    /**
    * <p>This method will set errors involved with this error</p>
    * @param subErrors the list of errors
    * @since 1.0
    */
    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }  
}
