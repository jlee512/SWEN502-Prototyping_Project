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
	
	public static void reduceStock(){
		//Remove the stock items from the database
	}
	
	public static void restock(){
		//Increase the stock in the database
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
	
	public static ArrayList<Ingredient> getAllIngredients(){
		//Loop through the array list of all ingredients 
		return null;
	}

}
