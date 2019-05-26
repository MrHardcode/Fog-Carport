
package data.exceptions;

/**
 * This Exception is thrown in the data layer whenever something is 
 * wrong with the validation of the user. 
 * @author 
 */

public class UserException extends Exception
{

    private static final long serialVersionUID = 1L;

    public UserException(String msg)
    {
        super(msg);
    }

}
