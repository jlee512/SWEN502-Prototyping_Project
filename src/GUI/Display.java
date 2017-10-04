package GUI;

import java.awt.Insets;
import java.util.ArrayList;

import Controller.Ingredient;
import Controller.Order;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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

	Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, server1, server2;
	ArrayList<String> order_ingredients = new ArrayList<>();
	String customer_name = "";
	int phone_number = -1;
	
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
		layout1.setStyle("-fx-background-color: #eeeeee");
		layout1Inner.getChildren().addAll(orderButton, serverButton);
		layout1.getChildren().addAll(title, layout1Inner);
		layout1.setAlignment(Pos.CENTER);
		layout1Inner.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1, 420, 600);

		primaryStage.setScene(scene1);
		primaryStage.show();

		// Scene 2

		Text selectBurger = new Text("Choose your burger:");
		selectBurger.setFont(Font.font ("Helvetica", 25));
		selectBurger.setFill(Color.web("#ee0000"));		

		VBox layout2 = new VBox(75);
		ChoiceBox burger = new ChoiceBox(FXCollections.observableArrayList(Ingredient.getAllBurgers()));

		Button meatNext = new Button("Next");
		meatNext.setOnAction(e -> primaryStage.setScene(scene3));

		meatNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout2.getChildren().addAll(selectBurger, burger, meatNext);
		layout2.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, 420, 600);

		BorderPane componentLayout = new BorderPane(); 

		// Scene 3

		Text selectBun = new Text("Choose your bun:");
		selectBun.setFont(Font.font ("Helvetica", 25));
		selectBun.setFill(Color.web("#ee0000"));		

		VBox layout3 = new VBox(75);
		ChoiceBox bun = new ChoiceBox(FXCollections.observableArrayList(Ingredient.getAllBreads()));

		Button bunNext = new Button("Next");
		bunNext.setOnAction(e -> primaryStage.setScene(scene4));

		bunNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout3.getChildren().addAll(selectBun, bun, bunNext);
		layout3.setAlignment(Pos.CENTER);
		scene3 = new Scene(layout3, 420, 600);

		// Scene 4

		Text selectSalad = new Text("Choose your filling:");
		selectSalad.setFont(Font.font ("Helvetica", 25));
		selectSalad.setFill(Color.web("#ee0000"));		

		VBox layout4 = new VBox(75);
		HBox layout4Inner = new HBox(20);

		ArrayList<String> fillings = Ingredient.getAllFillings();
		ArrayList<CheckBox> filling_checkboxes = new ArrayList<>();
		for (int i = 0; i < fillings.size(); i++) {
			CheckBox filling = new CheckBox(fillings.get(i));
			if (i == 0) {
				filling.setSelected(true);
			}
			layout4Inner.getChildren().add(filling);
			filling_checkboxes.add(filling);
		}

		Button saladNext = new Button("Next");

		saladNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				primaryStage.setScene(scene5);
			}
		}
				);

		saladNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout4.getChildren().addAll(selectSalad,layout4Inner,saladNext);
		layout4.setAlignment(Pos.CENTER);
		layout4Inner.setAlignment(Pos.CENTER);
		scene4 = new Scene(layout4, 420, 600);

		// Scene 5

		Text selectSauce = new Text("Choose your sauce:");
		selectSauce.setFont(Font.font ("Helvetica", 25));
		selectSauce.setFill(Color.web("#ee0000"));		

		VBox layout5 = new VBox(75);
		HBox layout5Inner = new HBox(20);
		
		ArrayList<String> sauces = Ingredient.getAllSauces();
		ArrayList<CheckBox> sauces_checkboxes = new ArrayList<>();
		for (int i = 0; i < sauces.size(); i++) {
			CheckBox sauce = new CheckBox(sauces.get(i));
			if (i == 0) {
				sauce.setSelected(true);
			}
			layout5Inner.getChildren().add(sauce);
			sauces_checkboxes.add(sauce);
		}
		
		Button sauceNext = new Button("Next");

		sauceNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				primaryStage.setScene(scene6);

			}

		}    
				);
		sauceNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout5.getChildren().addAll(selectSauce,layout5Inner,sauceNext);
		layout5.setAlignment(Pos.CENTER);
		layout5Inner.setAlignment(Pos.CENTER);
		scene5 = new Scene(layout5, 420, 600);

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
		
		Button detailsNext = new Button("Next");
		detailsNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				primaryStage.setScene(scene7);
			}
		}    
				);
		detailsNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		layout6User.getChildren().addAll(userName, userNameIn);
		layout6Pass.getChildren().addAll(userPhone, userPhoneIn);
		detailVBox.getChildren().addAll(layout6User, layout6Pass);
		layout6.getChildren().addAll(enterDetails, detailVBox, detailsNext);
		layout6User.setAlignment(Pos.CENTER);
		layout6Pass.setAlignment(Pos.CENTER);
		layout6.setAlignment(Pos.CENTER);
		scene6 = new Scene(layout6, 420, 600);

		// Scene 7

		Text confirm = new Text("Confirm your order:");

		confirm.setFont(Font.font ("Helvetica", 25));
		confirm.setFill(Color.web("#ee0000"));		

		VBox layout7 = new VBox(75);

		Button confirmNext = new Button("Next");
		
		confirmNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				
//				System.out.println("Burger");
				String burger_ordered = burger.getValue().toString();
				order_ingredients.add(burger_ordered);
//				System.out.println(burger_ordered);
				
//				System.out.println("Bun");
				String bun_ordered = bun.getValue().toString();
				order_ingredients.add(bun_ordered);
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
//				System.out.println(customer_name);
//				System.out.println(phone_number);	
				
				Order.createOrder(customer_name, phone_number, order_ingredients);

				primaryStage.setScene(scene8);
			}

		}    
				);


		confirmNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout7.getChildren().addAll(confirm, confirmNext);
		layout7.setAlignment(Pos.CENTER);
		scene7 = new Scene(layout7, 420, 600);

		// Scene 8

		Text finalMessage = new Text("Thank you, your order has been processed");
		finalMessage.setFont(Font.font ("Helvetica", 20));
		finalMessage.setFill(Color.web("#ee0000"));		

		VBox layout8 = new VBox(75);

		Button buttonReturn = new Button("Return");
		buttonReturn.setOnAction(e -> primaryStage.setScene(scene1));

		buttonReturn.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout8.getChildren().addAll(finalMessage, buttonReturn);
		layout8.setAlignment(Pos.CENTER);
		scene8 = new Scene(layout8, 420, 600);

		// Server scene 1

		VBox serverlayout1 = new VBox(75);
		VBox serverVBox = new VBox(20);
		HBox server1ID = new HBox(20);
		HBox server1Pass = new HBox(20);

		Text serverID = new Text("UserID:");
		TextField serverIDIn = new TextField();

		Text staffPass = new Text("Password:");
		TextField staffPassIn = new TextField();

		Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> primaryStage.setScene(server2));

		loginButton.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		server1ID.getChildren().addAll(serverID, serverIDIn);
		server1Pass.getChildren().addAll(staffPass, staffPassIn);
		serverVBox.getChildren().addAll(server1ID, server1Pass);
		serverlayout1.getChildren().addAll(serverVBox, loginButton);
		server1ID.setAlignment(Pos.CENTER);
		server1Pass.setAlignment(Pos.CENTER);
		serverlayout1.setAlignment(Pos.CENTER);
		server1 = new Scene(serverlayout1, 420, 600);

		// Server scene 2

		VBox serverlayout2 = new VBox(75);
		Text orderHeader = new Text("Orders:");
		orderHeader.setFont(Font.font ("Helvetica", 25));
		orderHeader.setFill(Color.web("#ee0000"));		
		HBox orderBox = new HBox(20);

		Text orderText = new Text("Order text");
		Button completeOrder = new Button("Complete");
		completeOrder.setOnAction(e -> primaryStage.setScene(server2));
		completeOrder.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		Button Restock = new Button("Restock");
		Restock.setStyle("-fx-background-color: #0099cc;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		Button Complete = new Button("Complete");
		Complete.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		orderBox.getChildren().addAll(orderText, completeOrder);
		serverlayout2.getChildren().addAll(orderHeader,orderBox,Restock, Complete);
		orderBox.setAlignment(Pos.CENTER);
		serverlayout2.setAlignment(Pos.CENTER);
		server2 = new Scene(serverlayout2, 420, 600);

	}

	private Object ButtonClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		return null;
	}
	private void notifier(String string, String string2) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		launch(args);
	}
}

