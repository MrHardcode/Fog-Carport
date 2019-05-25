/*
 *  
 */
package presentation;

import data.exceptions.UserException;

/**
 *
 * @author
 */
public class Validation
{

    public Validation()
    {
    }

    /**
     * Validate an Integer input from user. 
     * 
     * Checks if the integer input is null, empty and actually an integer.
     * To be used by command implementation classes. 
     * @param validate String input from user, that is supposed to be an integer afterwards.
     * @param name of the thing you want to validate.
     * @return int
     * @throws UserException 
     */
    public int validateInteger(String validate, String name) throws UserException
    {
        if (validate == null || validate.isEmpty())
        {
            throw new UserException(name + " may not be empty.");
        } else
        {
            try
            {
                int length = Integer.parseInt(validate);
                return length;
            } catch (NumberFormatException ex)
            {
                throw new UserException(name + " has to be an integer.");
            }
        }
    }

    /**
     * Validate a String input from user.
     * 
     * Checks if the String is null or empty.
     * To be used by command implementation classes.
     * @param validate String input you want to validate.
     * @param name you want to show user if their input is null or empty.
     * @return Input string, if it is valid.
     * @throws UserException 
     */
    public String validateString(String validate, String name) throws UserException
    {
        if (validate == null || validate.isEmpty())
        {
            throw new UserException(name + " may not be empty.");
        } else
        {
            return validate;
        }
    }
    
    /**
     * Validate two Strings (passwords) from user.
     * 
     * Checks if strings are null or empty.
     * Checks if the two given passwords match.
     * To be used by command implementation classes.
     * @param password String representing the first password input
     * @param password2 String representing the second password input
     * @param name Name of the element that is being validated
     * @return Input password if it is valid
     * @throws UserException 
     */
    public String validatePassword(String password, String password2, String name) throws UserException
    {
        if (password == null || password.isEmpty() || password2 == null || password2.isEmpty())
        {
            throw new UserException(name + " must not be empty");
        }
        if (!password.equals(password2))
        {
            throw new UserException("De to passwords stemte ikke overens.");
        }
        return password;
    }
}
