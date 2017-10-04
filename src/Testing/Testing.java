package Testing;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

import Controller.BadPasswordException;
import Controller.Employee;
import Controller.NonExistentUserException;
import Database.LocalSQLiteDB;

public class Testing {

	/**
	 * @author Madeleine St-Laurent-Guerin
	 */

	@Test
	public void testCredentials() {

		//Insert test code & assert statement
		
//		//Attempt to verify credentials and if verified take to employee screen
//        try {
//            app.verifyUserCredentials(employee_id, password_input);
//            employee = Employee.getUserDB(employee_id);
//            //If successful login transition to employee screen
//            System.out.println(employee.getEmpFirstName() + " " + employee.getEmpLastName() + " logged in");
//        } catch (BadPasswordException e) {
//            //Java FX post error message "User credentials incorrect" and remain on login screen
//            System.out.println("User credentials could not be verified");
//            return;
//        } catch (NonExistentUserException e) {
//            //Java FX post error message "User_id does not exist" and remain on login screen
//            System.out.println("User does not exist");
//            return;
//        }

	}

	@Test
	public void testGetOrderID() {

		//Insert test code & assert statement
		
//		//Get the order for that customer phone
//				//Return the order id
//				int ingredient_id = -1;
//
//				File database_file = new File("Burger.sqlite");
//				LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
//				try (Connection c = db.connection()) {
//					try (PreparedStatement stmt = c.prepareStatement("SELECT ingredient_id FROM Ingredient WHERE ingredient_name = ?")) {
//						stmt.setString(1, ingredientName);
//						try(ResultSet r = stmt.executeQuery()){
//							while (r.next()){
//								return r.getInt("ingredient_id");
//							}
//						}
//						System.out.println("Ingredient id confirmed");
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//
//				return ingredient_id;

	}
	
	@Test
	public void testOrderAddition(){
	
    //Test order addition -- 
//  ArrayList<String> ingredients = new ArrayList<>();
//  ingredients.add("White bread");
//  ingredients.add("Lamb");
//  ingredients.add("Mint");
//  Order.createOrder("Julian", 123, ingredients);

	}
}

