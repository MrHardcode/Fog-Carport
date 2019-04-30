package data.exceptions;

public class AlgorithmException extends Exception
{

    int errorNumber;

    private static final long serialVersionUID = 1L;

    public AlgorithmException(int errorNumber, String message)
    {
        super(message);
        this.errorNumber = errorNumber;
    }

    public AlgorithmException(int errorNumber, String message, Throwable throwable)
    {
        super(message, throwable);
        this.errorNumber = errorNumber;
    }
}
