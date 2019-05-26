package data.exceptions;

/**
 * This Exception is thrown in the logic layer. For example in the checks for 
 * less than zero on a number or null-check on a list used in the calculations.
 * @author 
 */
public class AlgorithmException extends Exception{
     private static final long serialVersionUID = 1L;

    public AlgorithmException(String message) {
        super(message);
    }
    
    
}