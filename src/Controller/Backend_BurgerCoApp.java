package Controller;

import Database.LocalSQLiteDB;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by Julian on 3/10/2017.
 */
public class Backend_BurgerCoApp {

    public static void main(String[] args) {
        Backend_BurgerCoApp app = new Backend_BurgerCoApp();
//        app.addUsersToDB();
        app.verifyUserCredentials();
    }

    public void addUsersToDB() {
        // Connect to database
        System.out.println("Creating Database Link");
        File database_file = new File("Burger.sqlite");
        LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

        // Add prototype users to database
        System.out.println("Adding users to database");
        Employee.addEmployeetoDB("Julian", "Lees", "test");
        Employee.addEmployeetoDB("Maddy", "St-Laurent-Guerin", "test");
        Employee.addEmployeetoDB("Jack", "Humphrey", "test");
        Employee.addEmployeetoDB("Gurtej", "Singh", "test");
        Employee.addEmployeetoDB("Darren", "Carrol", "test");
    }

    public void verifyUserCredentials(){
        try {
            if (Employee.validateUser(1, "test")) {
                System.out.println("Employee credentials verified");
            } else {
                System.out.println("Employee credentials could not be verified");
            }
        } catch (NonExistentUserException e) {
            e.printStackTrace();
        } catch (BadPasswordException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
