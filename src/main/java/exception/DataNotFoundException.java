/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author simon
 */
public class DataNotFoundException extends RuntimeException  {
    public DataNotFoundException(String message) {
        super(message);
    }
}
