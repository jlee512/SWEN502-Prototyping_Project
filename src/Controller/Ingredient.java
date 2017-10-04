package Controller;

import Database.LocalSQLiteDB;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ingredient {
	
	int ingredientID;
	String ingredientType;
	String ingredientName;
	double unitPrice;
	int quantity;

	public Ingredient() {

	}
	
	public static void reduceStock(String ingredientName){
		//Remove the stock items from the database
		//Create database connection
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

		int stock_level = Ingredient.getStockLevel(ingredientName);

		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("UPDATE Ingredient SET quantity = ? WHERE ingredient_name = ?;")) {
				stmt.setInt(1, (stock_level - 1));
				stmt.setString(2, ingredientName);

				stmt.executeUpdate();
				System.out.println(ingredientName + " stock level reduced");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getStockLevel(String ingredientName) {
		//Get a stock level from the database for a given ingredient
		//Establish connection to the database
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT i.quantity FROM Ingredient as i WHERE ingredient_name = ?;")) {
				stmt.setString(1, ingredientName);

				try (ResultSet r = stmt.executeQuery()) {
					while (r.next()) {
						return r.getInt("quantity");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void restock(String ingredientName){
		//Increase the stock in the database
		//Create database connection
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

		int stock_level = Ingredient.getStockLevel(ingredientName);

		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("UPDATE Ingredient SET quantity = ? WHERE ingredient_name = ?;")) {
				stmt.setInt(1, (stock_level + 5));
				stmt.setString(2, ingredientName);

				stmt.executeUpdate();
				System.out.println(ingredientName + " stock level replenished");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getRestockIngredients(){
		//Create database connection
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT i.ingredient_name FROM Ingredient as i WHERE i.quantity < 5;")) {

				try (ResultSet r = stmt.executeQuery()) {
					ArrayList<String> restock_ingredients = new ArrayList<>();
					while (r.next()) {
						restock_ingredients.add(r.getString("ingredient_name"));
					}
					return restock_ingredients;
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

	public static int getIngredientID(String ingredientName) {
		//Get the order for that customer phone
		//Return the order id
		int ingredient_id = -1;

		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT ingredient_id FROM Ingredient WHERE ingredient_name = ?")) {
				stmt.setString(1, ingredientName);
				try(ResultSet r = stmt.executeQuery()){
					while (r.next()){
						return r.getInt("ingredient_id");
					}
				}
				System.out.println("Ingredient id confirmed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ingredient_id;

	}
	
	public static ArrayList<String> getAllBurgers(){
		//Loop through the array list of all burgers
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT i.ingredient_name FROM Ingredient AS i, Ingredient_type AS it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = 'Meat' AND i.quantity > 0;")) {

				try (ResultSet r = stmt.executeQuery()) {
					ArrayList<String> burgers = new ArrayList<>();
					while (r.next()) {
						burgers.add(r.getString("ingredient_name"));
					}
					return burgers;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getAllBreads(){
		//Loop through the array list of all breads
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT i.ingredient_name FROM Ingredient AS i, Ingredient_type AS it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = 'Bun' AND i.quantity > 0;")) {

				try (ResultSet r = stmt.executeQuery()) {
					ArrayList<String> burgers = new ArrayList<>();
					while (r.next()) {
						burgers.add(r.getString("ingredient_name"));
					}
					return burgers;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getAllFillings(){
		//Loop through the array list of all fillings
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT i.ingredient_name FROM Ingredient AS i, Ingredient_type AS it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = 'Filling' AND i.quantity > 0;")) {

				try (ResultSet r = stmt.executeQuery()) {
					ArrayList<String> burgers = new ArrayList<>();
					while (r.next()) {
						burgers.add(r.getString("ingredient_name"));
					}
					return burgers;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getAllSauces(){
		//Loop through the array list of all fillings
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT i.ingredient_name FROM Ingredient AS i, Ingredient_type AS it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = 'Sauce' AND i.quantity > 0;")) {

				try (ResultSet r = stmt.executeQuery()) {
					ArrayList<String> burgers = new ArrayList<>();
					while (r.next()) {
						burgers.add(r.getString("ingredient_name"));
					}
					return burgers;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
