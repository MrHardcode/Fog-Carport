/*
 *  
 */
package presentation;

import data.exceptions.LoginException;

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
     * @throws LoginException 
     */
    public int validateInteger(String validate, String name) throws LoginException
    {
        if (validate == null || validate.isEmpty())
        {
            throw new LoginException(name + " may not be empty.");
        } else
        {
            try
            {
                int length = Integer.parseInt(validate);
                return length;
            } catch (NumberFormatException ex)
            {
                throw new LoginException(name + " has to be an integer.");
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
     * @throws LoginException 
     */
    public String validateString(String validate, String name) throws LoginException
    {
        if (validate == null || validate.isEmpty())
        {
            throw new LoginException(name + " may not be empty.");
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
     * @throws LoginException 
     */
    public String validatePassword(String password, String password2, String name) throws LoginException
    {
        if (password == null || password.isEmpty() || password2 == null || password2.isEmpty())
        {
            throw new LoginException(name + " must not be empty");
        }
        if (!password.equals(password2))
        {
            throw new LoginException("Please type in matching passwords");
        }
        return password;
    }
}
