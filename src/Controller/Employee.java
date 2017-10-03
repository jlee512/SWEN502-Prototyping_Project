package Controller;

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

	public void addEmployeetoDB() {
		//Add user to the database

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
