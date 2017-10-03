package Controller;

/**
 * @author Julian Lees, Madeleine St-Laurent-Guerin
 */

import Database.LocalSQLiteDB;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void addIngredient(String ingredientName) {
		ingredients.add(ingredientName);
	}

	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	//Creates a new order record in the database 
	public static void createOrder(String custname, int custphone){
		
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("INSERT INTO Burger_Order (user_alias, user_phone) VALUES (?, ?)")) {
				stmt.setString(1, custname);
				stmt.setInt(2, custphone);
				stmt.executeUpdate();
				System.out.println("Cust name: " + custname + " Phone: " + custphone + " order added");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//Create the new burger component records
	public void createBurgerComponents(int orderID, ArrayList<String> inputingredients){
	
		for (int i = 0; i < inputingredients.size() ; i++ ){
			int ingid = Ingredient.getIngredientID(inputingredients.get(i));
			
			File database_file = new File("Burger.sqlite");
			LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
			try (Connection c = db.connection()) {
				try (PreparedStatement stmt = c.prepareStatement("INSERT INTO Burger_Component (ingredient_id, order_id) VALUES (?, ?)")) {
					
					stmt.setInt(1, ingid);
					stmt.setInt(2, orderID);
					stmt.executeUpdate();
					System.out.println("Order ID: " + orderID + "ingredientID: " + ingid + "inputted successfully");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Connect to the database to obtain the order ID number 
	public static int getOrderID(String custname){
		int orderid = -1;
		
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT order_id FROM Burger_Order WHERE user_alias = ?")) {
				stmt.setString(1, custname);
				try(ResultSet r = stmt.executeQuery()){
					while (r.next()){
						return r.getInt("order_id");
					}
				}
				System.out.println("Order id");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return orderid;
	}


	//
	public static Order getOrder(){
		//get Order
		return null;
	}

	public void completeOrder(){
		//Complete the order and remove ingredients from the database	
	}

	//Get all open orders which are not yet assigned a staff member	
	public static ArrayList<Order> getAllOpenOrders(){
		
		//Create database connection
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT o.order_id, o.timestamp FROM Burger_Order AS o WHERE o.order_completed = 0 AND o.employee_id IS NULL ORDER BY o.timestamp ASC;")) {

				try (ResultSet r = stmt.executeQuery()) {
					ArrayList<Order> orders = new ArrayList<>();
					Order order = null;
					int order_id = -1;
					int order_num = 0;
					boolean has_orders = false;
					while (r.next()) {
						has_orders = true;
						//Process first order
						if (order_num == 0) {
							order = new Order(r.getInt("order_id"));
							//                            System.out.println("New order " + order.getOrderID());
							order.setTimestamp(r.getString("timestamp"));
							order_num ++;
							// Process subsequent orders
						} else if (r.getInt("order_id") != order.getOrderID()) {
							orders.add(order);
							order = new Order(r.getInt("order_id"));
							//                            System.out.println("New order " + order.getOrderID());
							order.setTimestamp(r.getString("timestamp"));
							//Process ingredients which form part of initialised order
						}
					}
					if(has_orders) {
						orders.add(order);
					}
					return orders;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
