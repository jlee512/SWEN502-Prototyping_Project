package Controller;

import java.util.ArrayList;

public class Order {
	
	int orderID;
	String userAlias;
	int userPhone;
	boolean orderComplete = false;
	String timestamp;
	ArrayList<Ingredient> ingredients;

	public Order(int order_id, String alias, int userPhone, String timestamp, ArrayList<Ingredient> ingredients) {
		this.orderID = order_id;
		this.userAlias = alias;
		this.userPhone = userPhone;
		this.timestamp = timestamp;
		this.ingredients = ingredients;
	}
	
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

	public ArrayList<Order> getAllOrdersByUser() {
		return null;
	}
}
