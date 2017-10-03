package controller;

import java.util.ArrayList;

public class Employee {
	
	int employeeID;
	String empFirstName;
	String empLastName;
	byte[] hash;
	byte[] salt;
	int iterations;
	
	public void getUserDB(){
		//Get user from the database
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
