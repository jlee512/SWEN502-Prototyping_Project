package Controller;

/**
 * Created by Julian on 3/10/2017.
 */
public class BadPasswordException extends Exception {

    //Paramter-less constructor
    public BadPasswordException() {}

    //Constructor that accepts a message
    public BadPasswordException(String message) {
        super(message);
    }

}
