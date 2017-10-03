package Controller;

/**
 * Created by Julian on 3/10/2017.
 */
public class NonExistentUserException extends Exception {

    //Paramter-less constructor
    public NonExistentUserException() {}

    //Constructor that accepts a message
    public NonExistentUserException(String message) {
        super(message);
    }

}
