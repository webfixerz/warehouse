package com.tvh.warehouseManager.exception;

/**
 * Objects of this class can be in a list of ApiError.
 *
 * @author simon
 */
public class ApiValidationError extends ApiSubError {
    /**
    * The object where the validation failed
    */
    private String object;
    
    /**
    * The field where the validation failed
    */
    private String field;
    
    /**
    * The value that was going to be assigned
    */
    private Object rejectedValue;
    
    /**
    * The errormessage of the validation
    */
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
