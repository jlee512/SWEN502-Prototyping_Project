package Testing;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Controller.Backend_BurgerCoApp;
import Controller.BadPasswordException;
import Controller.Employee;
import Controller.NonExistentUserException;
import Controller.Order;
import Database.LocalSQLiteDB;

public class Testing {

	/**
	 * @author Madeleine St-Laurent-Guerin
	 */

	@Test
	public void testCredentials() {

		Backend_BurgerCoApp app = new Backend_BurgerCoApp();

		int employee_id = 2;
		String password_input = "test";

		Employee employee = null;
		boolean answer = false;

		try {
			app.verifyUserCredentials(employee_id, password_input);
			employee = Employee.getUserDB(employee_id);
			answer = true;
				
		} catch (BadPasswordException e) {
			System.out.println("User credentials could not be verified");
			return;
		} catch (NonExistentUserException e) {
			System.out.println("User does not exist");
			return;
		}

		assertTrue("Failure - should be true", answer);

	}

	@Test
	public void testGetOrderID(){
		
		int orderid = -1;

        File database_file = new File("Burger.sqlite");
        LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
        
        try (Connection c = db.connection()) {
            try (PreparedStatement stmt = c.prepareStatement("SELECT order_id FROM Burger_Order WHERE user_alias = ?")) {
                stmt.setString(1, "Test1");
              try (ResultSet r = stmt.executeQuery()) {
                    while (r.next()) {
                        orderid = r.getInt("order_id");   
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

        assertThat(orderid, is(1));
	}
	
	@Test
	public void testStockLevel(){

		int stocklevel = -1;
		
		File database_file = new File("Burger.sqlite");
		LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());
		try (Connection c = db.connection()) {
			try (PreparedStatement stmt = c.prepareStatement("SELECT i.quantity FROM Ingredient as i WHERE ingredient_name = ?;")) {
				stmt.setString(1, "Beetroot");

				try (ResultSet r = stmt.executeQuery()) {
					while (r.next()) {
						stocklevel = r.getInt("quantity");
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

		 assertThat(stocklevel, is(4));
	}

}

