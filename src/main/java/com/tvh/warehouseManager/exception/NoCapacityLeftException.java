package com.tvh.warehouseManager.exception;

/**
 * This is a custom runtimeException. It is called when there are problems 
 * with the capacity of warehouses.
 *
 * @author simon
 */
public class NoCapacityLeftException extends RuntimeException  {
    public NoCapacityLeftException(String message) {
        super(message);
    }
}
