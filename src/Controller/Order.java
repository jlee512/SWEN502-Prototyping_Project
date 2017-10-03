package Controller;

import java.util.ArrayList;

public class Order {
	
	int orderID;
	String userAlias;
	int userPhone;
	boolean orderComplete = false;
	String timestamp;
	ArrayList<String> ingredients;

	public Order(int order_id) {
		this.orderID = order_id;
		this.ingredients = new ArrayList<>();
	}

	public int getOrderID() {
		return orderID;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public boolean isOrderComplete() {
		return orderComplete;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void addIngredient(String ingredientName) {
		ingredients.add(ingredientName);
	}

	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	public void createOrder(){
		//Create the order based on the input received from the GUI and add to DB
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
