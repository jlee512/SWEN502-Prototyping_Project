package GUI;

import java.awt.Insets;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import Controller.BadPasswordException;
import Controller.Employee;
import Controller.Ingredient;
import Controller.NonExistentUserException;
import Controller.Order;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Display extends Application {

	Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, server1, server2, server3, server4;
	ArrayList<String> order_ingredients = new ArrayList<>();
	String customer_name = "";
	int phone_number = -1;
	int user_id = -1;
	String password = "";
	int screen_width = 850;
	int screen_height = 600;
	String order_price = "";

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Welcome to Happy Burger");
		// Scene 1

		Text title = new Text("Happy Burger");
		title.setFont(Font.font ("Helvetica", 50));
		title.setFill(Color.web("#ee0000"));		

		Button orderButton = new Button("Place an order");
		orderButton.setOnAction(e -> primaryStage.setScene(scene2));
		Button serverButton = new Button("Staff login");
		serverButton.setOnAction(e -> primaryStage.setScene(server1));
		VBox layout1 = new VBox(25);
		VBox layout1Inner = new VBox(200);
		orderButton.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		serverButton.setStyle("-fx-background-color: #0099cc;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		layout1.setStyle("-fx-background-color: #8ce2ff");
		layout1Inner.getChildren().addAll(orderButton, serverButton);
		layout1.getChildren().addAll(title, layout1Inner);
		layout1.setAlignment(Pos.CENTER);
		layout1Inner.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1, screen_width, screen_height);

		primaryStage.setScene(scene1);
		primaryStage.show();

		// Scene 2

		Text selectBurger = new Text("Choose your burger:");
		selectBurger.setFont(Font.font ("Helvetica", 25));
		selectBurger.setFill(Color.web("#ee0000"));		

		VBox layout2 = new VBox(75);
		layout2.setStyle("-fx-background-color: #8ce2ff");
		
		ArrayList<String> burger_name_list = Ingredient.getAllBurgers();
		ArrayList<Double> burger_prices = Ingredient.getAllBurgerPrices();
		ArrayList<String> burgerAndPrice = new ArrayList<>();

		for (int i = 0; i < burger_name_list.size(); i++) {
			burgerAndPrice.add("" + burger_name_list.get(i) + " $" + burger_prices.get(i) + "0");
		}
		
		ObservableList<String> burger_list = FXCollections.observableArrayList(burgerAndPrice);
		ChoiceBox burger = new ChoiceBox();
		burger.setItems(burger_list);
		burger.getSelectionModel().selectFirst();

		Button buttonReturn = new Button("Restart your order");
		buttonReturn.setOnAction(e1 -> primaryStage.setScene(scene1));

		buttonReturn.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		
		Button meatNext = new Button("Next");
		meatNext.setOnAction(e -> primaryStage.setScene(scene3));

		meatNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout2.getChildren().addAll(selectBurger, burger, meatNext, buttonReturn);
		layout2.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, screen_width, screen_height);

		BorderPane componentLayout = new BorderPane(); 

		// Scene 3

		Text selectBun = new Text("Choose your bun:");
		selectBun.setFont(Font.font ("Helvetica", 25));
		selectBun.setFill(Color.web("#ee0000"));		

		VBox layout3 = new VBox(75);

		ArrayList<String> bun_name_list = Ingredient.getAllBreads();
		ArrayList<Double> bun_price_list = Ingredient.getAllBreadPrices();
		ArrayList<String> bunAndPrice = new ArrayList<>();

		for (int i = 0; i < bun_name_list.size(); i++) {
			bunAndPrice.add("" + bun_name_list.get(i) + " $" + bun_price_list.get(i) + "0");
		}

		ObservableList<String> bun_list = FXCollections.observableArrayList(bunAndPrice);
		ChoiceBox bun = new ChoiceBox();
		bun.setItems(bun_list);
		bun.getSelectionModel().selectFirst();
		
		Button buttonReturn2 = new Button("Restart your order");
		buttonReturn2.setOnAction(e1 -> primaryStage.setScene(scene1));

		buttonReturn2.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		
		Button bunNext = new Button("Next");
		bunNext.setOnAction(e -> primaryStage.setScene(scene4));

		bunNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout3.getChildren().addAll(selectBun, bun, bunNext, buttonReturn2);
		layout3.setAlignment(Pos.CENTER);
		layout3.setStyle("-fx-background-color: #8ce2ff");
		scene3 = new Scene(layout3, screen_width, screen_height);

		// Scene 4

		Text selectSalad = new Text("Choose your filling:");
		selectSalad.setFont(Font.font ("Helvetica", 25));
		selectSalad.setFill(Color.web("#ee0000"));		

		VBox layout4 = new VBox(75);
		HBox layout4Inner = new HBox(20);

		ArrayList<String> fillings = Ingredient.getAllFillings();
		ArrayList<Double> fillings_price = Ingredient.getAllFillingPrices();

		ArrayList<CheckBox> filling_checkboxes = new ArrayList<>();
		for (int i = 0; i < fillings.size(); i++) {
			CheckBox filling = new CheckBox("" + fillings.get(i) + " $" + fillings_price.get(i) + "0");
			if (i == 0) {
				filling.setSelected(true);
			}
			layout4Inner.getChildren().add(filling);
			filling_checkboxes.add(filling);
		}
		Button buttonReturn3 = new Button("Restart your order");
		buttonReturn3.setOnAction(e1 -> primaryStage.setScene(scene1));

		buttonReturn3.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		Button saladNext = new Button("Next");

		saladNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				primaryStage.setScene(scene5);
			}
		}
				);

		saladNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout4.getChildren().addAll(selectSalad,layout4Inner,saladNext, buttonReturn3);
		layout4.setAlignment(Pos.CENTER);
		layout4.setStyle("-fx-background-color: #8ce2ff");
		layout4Inner.setAlignment(Pos.CENTER);
		scene4 = new Scene(layout4, screen_width, screen_height);

		// Scene 5

		Text selectSauce = new Text("Choose your sauce:");
		selectSauce.setFont(Font.font ("Helvetica", 25));
		selectSauce.setFill(Color.web("#ee0000"));		

		VBox layout5 = new VBox(75);
		HBox layout5Inner = new HBox(20);

		ArrayList<String> sauces = Ingredient.getAllSauces();
		ArrayList<Double> sauce_price = Ingredient.getAllSaucePrices();
		ArrayList<CheckBox> sauces_checkboxes = new ArrayList<>();
		for (int i = 0; i < sauces.size(); i++) {
			CheckBox sauce = new CheckBox(sauces.get(i) + " $" + sauce_price.get(i) + "0");
			if (i == 0) {
				sauce.setSelected(true);
			}
			layout5Inner.getChildren().add(sauce);
			sauces_checkboxes.add(sauce);
		}

		Button buttonReturn4 = new Button("Restart your order");
		buttonReturn4.setOnAction(e1 -> primaryStage.setScene(scene1));

		buttonReturn4.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		Button sauceNext = new Button("Next");

		sauceNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				primaryStage.setScene(scene6);

			}

		}    
				);
		sauceNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout5.getChildren().addAll(selectSauce,layout5Inner,sauceNext, buttonReturn4);
		layout5.setAlignment(Pos.CENTER);
		layout5Inner.setAlignment(Pos.CENTER);
		layout5.setStyle("-fx-background-color: #8ce2ff");
		scene5 = new Scene(layout5, screen_width, screen_height);

		// Scene 6


		Text enterDetails = new Text("Enter your details:");
		enterDetails.setFont(Font.font ("Helvetica", 25));
		enterDetails.setFill(Color.web("#ee0000"));   

		VBox layout6 = new VBox(75);
		VBox detailVBox = new VBox(20);
		HBox layout6User = new HBox(20);
		HBox layout6Pass = new HBox(20);
		//

		Text userName = new Text("Name:");
		TextField userNameIn = new TextField();

		Text userPhone = new Text("Phone:");
		TextField userPhoneIn = new TextField();
		
		Button buttonReturn5 = new Button("Restart your order");
		buttonReturn5.setOnAction(e1 -> primaryStage.setScene(scene1));

		buttonReturn5.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");


		Button detailsNext = new Button("Next");
		detailsNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if (userNameIn.getText().isEmpty() || userPhoneIn.getText().isEmpty()) {
					Label missing_details = new Label("Order details missing");
					layout6.getChildren().add(missing_details);
				} else {
					primaryStage.setScene(scene7);
				}
			}
		}    
				);
		detailsNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		layout6User.getChildren().addAll(userName, userNameIn, buttonReturn5);
		layout6Pass.getChildren().addAll(userPhone, userPhoneIn);
		detailVBox.getChildren().addAll(layout6User, layout6Pass);
		layout6.getChildren().addAll(enterDetails, detailVBox, detailsNext);
		layout6User.setAlignment(Pos.CENTER);
		layout6Pass.setAlignment(Pos.CENTER);
		layout6.setAlignment(Pos.CENTER);
		layout6.setStyle("-fx-background-color: #8ce2ff");
		scene6 = new Scene(layout6, screen_width, screen_height);

		// Scene 7

		Text confirm = new Text("Confirm your order:");

		confirm.setFont(Font.font ("Helvetica", 25));
		confirm.setFill(Color.web("#ee0000"));		

		VBox layout7 = new VBox(75);
		layout7.setStyle("-fx-background-color: #8ce2ff");
		
		Button buttonReturn6 = new Button("Restart your order");
		buttonReturn6.setOnAction(e1 -> primaryStage.setScene(scene1));

		buttonReturn6.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");


		Button confirmNext = new Button("Next");

		confirmNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				//				System.out.println("Burger");
				String burger_ordered = burger.getValue().toString().substring(0, burger.getValue().toString().indexOf(" "));
				System.out.println(burger.getValue().toString());
				order_ingredients.add(burger_ordered);
				burger.setItems(FXCollections.observableArrayList(Ingredient.getAllBurgers()));
				//				System.out.println(burger_ordered);

				//				System.out.println("Bun");
				String bun_ordered = "";
				if (bun.getValue().toString().startsWith("L")) {
					bun_ordered = bun.getValue().toString().substring(0, bun.getValue().toString().indexOf(" "));
				} else {
					bun_ordered = bun.getValue().toString().substring(0, bun.getValue().toString().indexOf(" ", bun.getValue().toString().indexOf(" ") + 1));
				}
				order_ingredients.add(bun_ordered);
				bun.setItems(FXCollections.observableArrayList(Ingredient.getAllBreads()));
				//				System.out.println(burger_ordered);

				//				System.out.println("Filling");
				for (int i = 0; i < filling_checkboxes.size(); i++) {
					if (filling_checkboxes.get(i).isSelected()) {
						order_ingredients.add(fillings.get(i));
					}
				}

				//				System.out.println("Sauces");
				for (int i = 0; i < sauces_checkboxes.size(); i++) {
					if (sauces_checkboxes.get(i).isSelected()) {
						order_ingredients.add(sauces.get(i));
					}
				}


				for(int i = 0; i < order_ingredients.size(); i++) {
					System.out.println(order_ingredients.get(i));
				}

				customer_name = userNameIn.getText();
				phone_number = Integer.parseInt(userPhoneIn.getText());
				//System.out.println(customer_name);
				//System.out.println(phone_number);

				double total_price = Order.createOrder(customer_name, phone_number, order_ingredients);
				order_price = "$" + total_price + "0";

				// Scene 8

				Text finalMessage = new Text("Thank you, your order has been processed");
				Text totalPrice = new Text(order_price);
				finalMessage.setFont(Font.font ("Helvetica", 20));
				finalMessage.setFill(Color.web("#ee0000"));
				totalPrice.setFont(Font.font ("Helvetica", 20));
				totalPrice.setFill(Color.web("#ee0000"));

				VBox layout8 = new VBox(75);
				layout8.setStyle("-fx-background-color: #8ce2ff");

				Button buttonReturn = new Button("Return");
				buttonReturn.setOnAction(e1 -> primaryStage.setScene(scene1));

				buttonReturn.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

				layout8.getChildren().addAll(finalMessage, totalPrice, buttonReturn);
				layout8.setAlignment(Pos.CENTER);
				scene8 = new Scene(layout8, screen_width, screen_height);

				primaryStage.setScene(scene8);
			}

		}    
				);


		confirmNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout7.getChildren().addAll(confirm, confirmNext);
		layout7.setAlignment(Pos.CENTER);
		layout7.setStyle("-fx-background-color: #8ce2ff");
		scene7 = new Scene(layout7, screen_width, screen_height);

		//Staff side of the display
		// Server scene 1

		VBox serverlayout1 = new VBox(75);
		VBox serverVBox = new VBox(20);
		HBox server1ID = new HBox(20);
		HBox server1Pass = new HBox(20);

		Text serverID = new Text("UserID:");
		TextField serverIDIn = new TextField();

		Text staffPass = new Text("Password:");		
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Your password");

		Button loginButton = new Button("Login");

		loginButton.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		Label noaccess = new Label();

		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				user_id = Integer.parseInt(serverIDIn.getText());
				password = passwordField.getText();

				try {
					if (Employee.validateUser(user_id, password)) {
						System.out.println("Employee #" + user_id + " credentials verified");
						VBox serverlayout3 = new VBox(25);
						VBox serverlayoutInner3 = new VBox(200);
						serverlayout3.setStyle("-fx-background-color: #eeeeee");
						
						ArrayList<Order> unfilled_orders = Order.getAllOpenOrders();
						ArrayList<Integer> unfilled_orders_ints = new ArrayList<>();
						for(int i = 0; i < unfilled_orders.size(); i++) {
							unfilled_orders_ints.add(unfilled_orders.get(i).getID());
						}
						
						ObservableList<Integer> unfilled_orders_observable = FXCollections.observableArrayList(unfilled_orders_ints);
						ChoiceBox unfilled_order_list = new ChoiceBox();
						unfilled_order_list.setItems(unfilled_orders_observable);
						
						Employee employee = Employee.getUserDB(user_id);
						ArrayList<Order> employee_orders = employee.getUserToDoList();
						ArrayList<Integer> employee_orders_ints = new ArrayList<>();
						for(int i = 0; i < employee_orders.size(); i++) {
							employee_orders_ints.add(employee_orders.get(i).getID());
						}
						
						ObservableList<Integer> employee_orders_observable = FXCollections.observableArrayList(employee_orders_ints);
						ChoiceBox employee_order_list = new ChoiceBox();
						employee_order_list.setItems(employee_orders_observable);
						
						Button assign_order = new Button("Assign Order");
						assign_order.setOnAction(new EventHandler<ActionEvent>() {
							@Override public void handle(ActionEvent e) {
								//Need to get the selected unassigned order
								Employee employee = null;
								try {
									employee = Employee.getUserDB(user_id);
								} catch (NonExistentUserException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								int order_takeup_id = Integer.parseInt(unfilled_order_list.getValue().toString());
								//Print out order list (drop down menu)
								//Select order #
								//Assign to employee 
								employee.assignOrder(order_takeup_id);
								
								/**Up to here we know its working*/
								System.out.println("Check from here");
								
								ArrayList<Order> unfilled_orders = Order.getAllOpenOrders();
								System.out.println("Unfilled order list completed");
					
								ArrayList<Integer> unfilled_orders_ints = new ArrayList<>();
								for(int i = 0; i < unfilled_orders.size(); i++) {
									unfilled_orders_ints.add(unfilled_orders.get(i).getID());
									System.out.println(unfilled_orders.get(i).getID());
								}
								
								System.out.println("Check up to here");
								
								unfilled_order_list.setItems(FXCollections.observableArrayList(unfilled_orders_ints));
								
								ArrayList<Order> employee_orders = employee.getUserToDoList();
								ArrayList<Integer> employee_orders_ints = new ArrayList<>();
								for(int i = 0; i < employee_orders.size(); i++) {
									employee_orders_ints.add(employee_orders.get(i).getID());
								}
								
								employee_order_list.setItems(FXCollections.observableArrayList(employee_orders_ints));
								
								primaryStage.setScene(server2);
								
							}
						});
						
						Button completeOrder = new Button("Complete Order");
						completeOrder.setOnAction(new EventHandler<ActionEvent>() {
							@Override public void handle(ActionEvent e) {
								//Get the list of orders assigned
								//Select out of list an order
								//Order number
								//Need to get the employee's orders that has been selected
								Employee employee = null;
								try {
									employee = Employee.getUserDB(user_id);
								} catch (NonExistentUserException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								int order_completed_id = (int) employee_order_list.getValue();
								//Print out order list (drop down menu)
								//Select order #
								//Assign to employee 
								employee.completeOrder(order_completed_id);
								
								ArrayList<Order> employee_orders = employee.getUserToDoList();
								ArrayList<Integer> employee_orders_ints = new ArrayList<>();
								for(int i = 0; i < employee_orders.size(); i++) {
									employee_orders_ints.add(employee_orders.get(i).getID());
									System.out.println(employee_orders.get(i).getID());
								}
								
								employee_order_list.setItems(FXCollections.observableArrayList(employee_orders_ints));
								primaryStage.setScene(server2);
							}
						});
						
						assign_order.setStyle("-fx-background-color: #0099cc;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
						completeOrder.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
						serverlayout3.getChildren().addAll(unfilled_order_list, assign_order, employee_order_list, completeOrder);
						serverlayout3.getChildren().add(serverlayoutInner3);
						serverlayout3.setAlignment(Pos.CENTER);
						serverlayout3.setStyle("-fx-background-color: #8ce2ff");
						serverlayoutInner3.setAlignment(Pos.CENTER);
						server3 = new Scene(serverlayout3, screen_width, screen_height);
						primaryStage.setScene(server2);
						
						/**Display the list of ingredients in checkboxes
						Select ingredient to restock
						Confirm restock -- connect to the restock item method*/
						
						VBox serverlayout4 = new VBox(25);
						VBox serverlayoutInner = new VBox(200);
						serverlayout4.setStyle("-fx-background-color: #8ce2ff");
								
						ObservableList<String> restockIngredients = FXCollections.observableArrayList(Ingredient.getRestockIngredients());
						ChoiceBox torestock = new ChoiceBox();
						torestock.setItems(restockIngredients);
						
						Button confirm_restock = new Button("Restock Item");
						confirm_restock.setOnAction(new EventHandler<ActionEvent>() {
							@Override public void handle(ActionEvent e) {
								String restock_ingredient = torestock.getValue().toString();
								Ingredient.restock(restock_ingredient);
								
								torestock.setItems(FXCollections.observableArrayList(Ingredient.getRestockIngredients()));
								primaryStage.setScene(server2);
							}
						});
						
						confirm_restock.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
						serverlayout4.getChildren().addAll(torestock, confirm_restock);
						serverlayout4.getChildren().addAll(serverlayoutInner);
						serverlayout4.setAlignment(Pos.CENTER);
						serverlayoutInner.setAlignment(Pos.CENTER);
						serverlayout4.setStyle("-fx-background-color: #8ce2ff");
						server4 = new Scene(serverlayout4, screen_width, screen_height);
						
					} else {
						System.out.println("Employee credentials could not be verified");
					}
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (NonExistentUserException e2){
					noaccess.setText("User does not exist");
				} catch (BadPasswordException e3){
					noaccess.setText("Password is incorrect");
				}

			}
		});

		server1ID.getChildren().addAll(serverID, serverIDIn);
		server1Pass.getChildren().addAll(staffPass, passwordField);
		serverVBox.getChildren().addAll(server1ID, server1Pass, noaccess);
		serverlayout1.getChildren().addAll(serverVBox, loginButton);
		server1ID.setAlignment(Pos.CENTER);
		server1Pass.setAlignment(Pos.CENTER);
		serverlayout1.setAlignment(Pos.CENTER);
		serverlayout1.setStyle("-fx-background-color: #8ce2ff");
		serverVBox.setAlignment(Pos.CENTER);
		server1 = new Scene(serverlayout1, screen_width, screen_height);

		// Server scene 2

		VBox serverlayout2 = new VBox(75);
		Text orderHeader = new Text("Orders:");
		orderHeader.setFont(Font.font ("Helvetica", 25));
		orderHeader.setFill(Color.web("#ee0000"));		
		HBox orderBox = new HBox(10);

		Button getToDoList = new Button("Get To Do List");
		getToDoList.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		getToDoList.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				primaryStage.setScene(server3);
			}
		});
	
		Button Restock = new Button("Restock");
		Restock.setStyle("-fx-background-color: #0099cc;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		Restock.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				primaryStage.setScene(server4);
			}
		});
		
		serverlayout2.getChildren().addAll(orderHeader,orderBox,Restock, getToDoList);
		orderBox.setAlignment(Pos.TOP_CENTER);
		serverlayout2.setAlignment(Pos.CENTER);
		serverlayout2.setStyle("-fx-background-color: #8ce2ff");

		server2 = new Scene(serverlayout2, screen_width, screen_height);
		
		
		//Server scene 3 - Assign & complete orders 
		
		//Server scene  4 - Restocking

	}

	public static void main(String[] args) {
		launch(args);
	}

}

