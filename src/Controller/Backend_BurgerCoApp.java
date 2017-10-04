package Controller;

import Database.LocalSQLiteDB;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Julian on 3/10/2017.
 */
public class Backend_BurgerCoApp {

    public static void main(String[] args) {
        Backend_BurgerCoApp app = new Backend_BurgerCoApp();
        app.addUsersToDB();

        //Employee_id and password input from Java FX
        int employee_id = 2;
        String password_input = "test";

        Employee employee = null;

        //Attempt to verify credentials and if verified take to employee screen
        try {
            app.verifyUserCredentials(employee_id, password_input);
            employee = Employee.getUserDB(employee_id);
            //If successful login transition to employee screen
            System.out.println(employee.getEmpFirstName() + " " + employee.getEmpLastName() + " logged in");
        } catch (BadPasswordException e) {
            //Java FX post error message "User credentials incorrect" and remain on login screen
            System.out.println("User credentials could not be verified");
            return;
        } catch (NonExistentUserException e) {
            //Java FX post error message "User_id does not exist" and remain on login screen
            System.out.println("User does not exist");
            return;
        }

        //Once logged in - display unfilled orders
        ArrayList<Order> unfilled_orders = Order.getAllOpenOrders();
        for (int i = 0; i < unfilled_orders.size(); i++) {
            System.out.println("Unfilled -> Order id: " + unfilled_orders.get(i).getID() + " " + unfilled_orders.get(i).getTimestamp());
        }

        //And display the users orders
        ArrayList<Order> employee_orders = employee.getUserToDoList();
        if (employee_orders.size() == 0) {
            System.out.println("No orders assigned to this staff member");
        } else {
            System.out.println("Orders for: " + employee.getEmpFirstName() + " " + employee.getEmpLastName());
        }
        //Test output for Java FX
        for (int i = 0; i < employee_orders.size(); i++) {
            System.out.print("Order #" + employee_orders.get(i).getID() + ": ");
            for (int j = 0; j < employee_orders.get(i).getIngredients().size(); j++) {
                if (j < (employee_orders.get(i).getIngredients().size() - 1)) {
                    System.out.print(employee_orders.get(i).getIngredients().get(j) + ", ");
                } else {
                    System.out.println(employee_orders.get(i).getIngredients().get(j));
                }
            }
        }
        //Display employee screen

        //Employee can select unfilled orders to be responsible for (pushes retrieve button in Java FX)
//        employee.assignOrder(5);
        //Refresh employee screen

        //Employee can complete retrieved orders (pushes completed button in Java FX)
//        employee.completeOrder(5);
        //Refresh employee screen

        //Test ingredient list to restock
        ArrayList<String> restock_ingredients = Ingredient.getRestockIngredients();
        for (int i = 0; i < restock_ingredients.size(); i++) {
            System.out.println("Ingredient to restock: " + restock_ingredients.get(i));
        }

//        Test ingredient restock mechanism
//        Ingredient.restock("Cucumber");

        //Test getOrderId
        System.out.println("Order_id for: Test1 is -> " + Order.getOrderID("Test1"));

        //Test getIngredientID
        System.out.println("Ingredient_id for: Chicken is -> " + Ingredient.getIngredientID("Chicken"));

        //Test order addition
//        ArrayList<String> ingredients = new ArrayList<>();
//        ingredients.add("White bread");
//        ingredients.add("Lamb");
//        ingredients.add("Mint");
//        Order.createOrder("Julian", 123, ingredients);
//        Order.createOrder("Maddy", 12345, ingredients);

        // Test all ingredients of particular types
        ArrayList<String> burgers = Ingredient.getAllBurgers();
        for (int i = 0; i < burgers.size(); i++) {
            System.out.println(burgers.get(i));
        }

        ArrayList<String> breads = Ingredient.getAllBreads();
        for (int i = 0; i < breads.size(); i++) {
            System.out.println(breads.get(i));
        }

        ArrayList<String> fillings = Ingredient.getAllFillings();
        for (int i = 0; i < fillings.size(); i++) {
            System.out.println(fillings.get(i));
        }

        ArrayList<String> sauces = Ingredient.getAllSauces();
        for (int i = 0; i < sauces.size(); i++) {
            System.out.println(sauces.get(i));
        }

//        Ingredient.reduceStock("Onion");
    }

    public void addUsersToDB() {
        // Connect to database
        System.out.println("Creating Database Link");
        File database_file = new File("Burger.sqlite");
        LocalSQLiteDB db = new LocalSQLiteDB("sqlite", database_file.getAbsolutePath());

        // Add prototype users to database
        System.out.println("Adding users to database");
        Employee.addEmployeetoDB("Julian", "Lees", "test");
        Employee.addEmployeetoDB("Maddy", "St-Laurent-Guerin", "test");
        Employee.addEmployeetoDB("Jack", "Humphrey", "test");
        Employee.addEmployeetoDB("Gurtej", "Singh", "test");
        Employee.addEmployeetoDB("Darren", "Carrol", "test");
    }

    public void verifyUserCredentials(int employee_id, String password_input) throws NonExistentUserException, BadPasswordException {
        try {
            if (Employee.validateUser(employee_id, password_input)) {
                System.out.println("Employee #" + employee_id + " credentials verified");
            } else {
                System.out.println("Employee credentials could not be verified");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Successful test
//        System.out.println("Non-existent user test: ");
//        try {
//            if (Employee.validateUser(10, "test")) {
//                System.out.println("Employee credentials verified");
//            } else {
//                System.out.println("Employee credentials could not be verified");
//            }
//        } catch (NonExistentUserException e) {
//            e.printStackTrace();
//        } catch (BadPasswordException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        //Successful test
//        System.out.println("Incorrect password test: ");
//        try {
//            if (Employee.validateUser(1, "test1")) {
//                System.out.println("Employee credentials verified");
//            } else {
//                System.out.println("Employee credentials could not be verified");
//            }
//        } catch (NonExistentUserException e) {
//            e.printStackTrace();
//        } catch (BadPasswordException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }

}
