package Controller;

import java.util.ArrayList;

public class Ingredient {
	
	int ingredientID;
	String ingredientType;
	String ingredientName;
	double unitPrice;
	int quantity;
	
	public void reduceStock(){
		//Remove the stock items from the database
	}
	
	public void restock(){
		//Increase the stock in the database
	}
	
	public static Ingredient getIngredients(){
		
		return null;
	}
	
	public static ArrayList<Ingredient> getAllIngredients(){
		//Loop through the array list of all ingredients 
		return null;
	}

}
