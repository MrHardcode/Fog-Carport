/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.exceptions;

/**
 *
 * @author Camilla
 */
public class DataException extends Exception{
     private static final long serialVersionUID = 1L;

    public DataException(String message) {
        super(message);
    }
    
    
}
