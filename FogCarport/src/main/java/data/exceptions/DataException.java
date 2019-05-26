
package data.exceptions;

/**
 * This Exception is thrown in the data and logic layer whenever something is 
 * wrong with the data from the databse or when a SQL-exception is caught. 
 * @author 
 */
public class DataException extends Exception{
     private static final long serialVersionUID = 1L;

    public DataException(String message) {
        super(message);
    }
    
    
}
