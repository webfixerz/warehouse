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

    /**
    * <p>This is a constructor of ApiCalidationError that can be called in this package</p>
    * @param object the object where the validation failed
    * @param message the message of the error
    * @since 1.0
    */
    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    /**
    * <p>This method will return the object</p>-
    * @return the object
    * @since 1.0
    */
    public String getObject() {
        return object;
    }

    /**
    * <p>This method will set a new object</p>
    * @param object a new object
    * @since 1.0
    */
    public void setObject(String object) {
        this.object = object;
    }

    /**
    * <p>This method will return the field where the error happened</p>-
    * @return the field
    * @since 1.0
    */
    public String getField() {
        return field;
    }

    /**
    * <p>This method will set a new field where the error happened</p>
    * @param field a new field
    * @since 1.0
    */
    public void setField(String field) {
        this.field = field;
    }

    /**
    * <p>This method will return the value that was rejected</p>
    * @return the rejected value
    * @since 1.0
    */
    public Object getRejectedValue() {
        return rejectedValue;
    }

    /**
    * <p>This method will set a new value</p>
    * @param rejectedValue a new value that is rejected
    * @since 1.0
    */
    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    /**
    * <p>This method will return the message of the error</p>
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
    
    
}
