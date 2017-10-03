package Controller;

import Database.LocalSQLiteDB;

import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {

    int employeeID;
    String empFirstName;
    String empLastName;
    String hash;
    String salt = "burgerco";
    int iterations;

    public Employee(int employeeID, String employeeFName, String emloyeeLName, String hash, String salt, int iterations) {
        //Employee Constructor
        this.employeeID = employeeID;
        this.empFirstName = employeeFName;
        this.empLastName = emloyeeLName;
        this.hash = hash;
        this.salt = salt;
        this.iterations = iterations;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }

    public int getIterations() {
        return iterations;
    }

    public static Employee getUserDB(int employeeID) throws NonExistentUserException {
        //Get user from the database
        //Create database connection
        File database_file = new File("Burger.sqlite");
        LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
        try(Connection c = db.connection()) {
            try(PreparedStatement stmt = c.prepareStatement("SELECT e.employee_id, e.employee_fname, e.employee_lname, e.hash, e.salt, e.iterations FROM Employee as e WHERE employee_id = ?;")) {
                stmt.setInt(1, employeeID);

                try(ResultSet r = stmt.executeQuery()) {
                    if (r.next()) {
                        Employee employee = new Employee(r.getInt("employee_id"), r.getString("employee_fname"), r.getString("employee_lname"), r.getString("hash"), r.getString("salt"), r.getInt("iterations"));
                        return employee;
                    } else {
                        throw new NonExistentUserException("User is not within database");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validateUser(int employee_id_input, String password_input) throws NonExistentUserException, BadPasswordException, UnsupportedEncodingException {
        //Validate the user's credentials
        Employee employee = Employee.getUserDB(employee_id_input);

        byte[] hash_array_check = Passwords.hash(password_input.toCharArray(), employee.getIterations());
        String hash_string_check = new String(hash_array_check, "UTF-8");

        if (hash_string_check.equals(employee.getHash())) {
            return true;
        }

        return false;
    }

    public void assignOrder() {
        //Assign an order to the employee
    }

    public void completeOrder() {
        //Order is completed and ingredients are removed from the database
    }

    public ArrayList<Order> getUserToDoList() {
        //Shows list of all orders


        return null;
    }

    //Method created to populate prototype database with test data for employees (necessary in Java in order to encrypt credentials)
    public static void addEmployeetoDB(String firstname_entry, String lastname_entry, String password_entry) {
        //Create database connection
        File database_file = new File("Burger.sqlite");
        LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

        //Add user to Database
        int iteration_temp = Passwords.getNextNumIterations();
        byte[] hash_array = Passwords.hash(password_entry.toCharArray(), iteration_temp);
        String salt = null;
        String hash = null;
        try {
            salt = "burgerco";
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
}
