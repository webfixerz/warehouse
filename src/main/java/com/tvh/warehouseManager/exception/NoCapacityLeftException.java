package com.tvh.warehouseManager.exception;

/**
 * This is a custom runtimeException. It is called when there are problems 
 * with the capacity of warehouses.
 *
 * @author simon
 */
public class NoCapacityLeftException extends RuntimeException  {
    
    /**
    * <p>This constructor will call the RuntimeException constructor</p>
    * @param message the message of the error
    * @since 1.0
    */
    public NoCapacityLeftException(String message) {
        super(message);
    }
}
