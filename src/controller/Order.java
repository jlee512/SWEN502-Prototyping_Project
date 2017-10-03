package controller;

import java.util.ArrayList;

public class Order {
	
	int orderID;
	String userAlias;
	int userPhone;
	boolean orderComplete;
	String timestamp;
	ArrayList<Ingredient> ingredients;
	
	public void createOrder(){
		//Create the order based on the input received from the GUI
	}
	
	public static Order getOrder(){
		//get Order
		return null;
	}
	
	public void completeOrder(){
		//Complete the order and remove ingredients from the database	
	}
	
	public ArrayList<Order> getAllOrders(){
		return null;
	}

}
