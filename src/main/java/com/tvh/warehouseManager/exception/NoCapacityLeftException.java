package com.tvh.warehouseManager.exception;

/**
 *
 * @author simon
 */
public class NoCapacityLeftException extends RuntimeException  {
    public NoCapacityLeftException(String message) {
        super(message);
    }
}
