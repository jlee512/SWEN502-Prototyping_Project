package Controller;

import Database.LocalSQLiteDB;

import java.io.File;
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

	public void addEmployeetoDB(String firstname_entry, String lastname_entry, String password_entry) {
		//Create database connection
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

		//Add user to Database
		int iteration_temp = Passwords.getNextNumIterations();
		byte[] salt = Passwords.getNextSalt();
		byte[] hash = Passwords.hash(password_entry.toCharArray(), salt, iterations);

		try(Connection c = db.connection()) {
			try(PreparedStatement stmt = c.prepareStatement("INSERT INTO Employee (employee_fname, employee_lname, hash, salt, iterations) VALUES (?, ?, ?, ?, ?)")) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Employee getUserDB(int employeeID){
		//Get user from the database

		return null;
	}
	
	public void validateUser(){
		//Validate the password 
	}
	
	public void assignOrder(){
		//Assign an order to the employee
	}
	
	public void completeOrder(){
		//Order is completed and ingredients are removed from the database
	}
	
	ArrayList<Order> getUserToDoList(){
		//Shows list of all orders
		return null;
	}

}
