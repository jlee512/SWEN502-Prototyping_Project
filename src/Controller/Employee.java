package Controller;

import Database.LocalSQLiteDB;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {

    int employeeID;
    String empFirstName;
    String empLastName;
    byte[] hash;
    byte[] salt;
    int iterations;

    public Employee(int employeeID, String employeeFName, String emloyeeLName, byte[] hash, byte[] salt, int iterations) {
        //Employee Constructor
        this.employeeID = employeeID;
        this.empFirstName = employeeFName;
        this.empLastName = emloyeeLName;
        this.hash = hash;
        this.salt = salt;
        this.iterations = iterations;
    }

    public static void addEmployeetoDB(String firstname_entry, String lastname_entry, String password_entry) {
        //Create database connection
        File database_file = new File("Burger.sqlite");
        LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

        //Add user to Database
        int iteration_temp = Passwords.getNextNumIterations();
        byte[] salt_array = Passwords.getNextSalt();
        byte[] hash_array = Passwords.hash(password_entry.toCharArray(), salt_array, iteration_temp);
        String salt = null;
        String hash = null;
        try {
            salt = new String(salt_array, "UTF-8");
            hash = new String(hash_array, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try (Connection c = db.connection()) {
            try (PreparedStatement stmt = c.prepareStatement("INSERT INTO Employee (employee_fname, employee_lname, hash, salt, iterations) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setString(1, firstname_entry);
                stmt.setString(2, lastname_entry);
                stmt.setString(3, hash);
                stmt.setString(4, salt);
                stmt.setInt(5, iteration_temp);

                stmt.executeUpdate();
                System.out.println("User: " + firstname_entry + " " + lastname_entry + " added to database");

            } catch (SerialException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Employee getUserDB(int employeeID) {
        //Get user from the database

        return null;
    }

    public void validateUser() {
        //Validate the password
    }

    public void assignOrder() {
        //Assign an order to the employee
    }

    public void completeOrder() {
        //Order is completed and ingredients are removed from the database
    }

    ArrayList<Order> getUserToDoList() {
        //Shows list of all orders
        return null;
    }

}
