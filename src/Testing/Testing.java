package Testing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Controller.Backend_BurgerCoApp;
import Controller.BadPasswordException;
import Controller.Employee;
import Controller.NonExistentUserException;

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
	public void test2(){

	}

}

