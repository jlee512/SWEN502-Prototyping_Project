package GUI;

import java.awt.Insets;

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

	Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7;

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("My First JavaFX GUI");
		// Scene 1

		Text title = new Text("Happy Burger");
		title.setFont(Font.font ("Helvetica", 50));
		title.setFill(Color.web("#ee0000"));		

		Button orderButton = new Button("Place an order");
		orderButton.setOnAction(e -> primaryStage.setScene(scene2));
		Button serverButton = new Button("Server login");
		//		orderButton.setOnAction(e -> primaryStage.setScene(scene2));
		VBox layout1 = new VBox(75);
		VBox layout1Inner = new VBox(20);
		orderButton.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		serverButton.setStyle("-fx-background-color: #0099cc;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
		layout1.setStyle("-fx-background-color: #eeeeee");
		layout1Inner.getChildren().addAll(orderButton, serverButton);
		layout1.getChildren().addAll(title, layout1Inner);
		layout1.setAlignment(Pos.CENTER);
		layout1Inner.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1, 320, 480);

		primaryStage.setScene(scene1);
		primaryStage.show();

		// Scene 2

		Text selectBurger = new Text("Choose your burger:");
		selectBurger.setFont(Font.font ("Helvetica", 25));
		selectBurger.setFill(Color.web("#ee0000"));		

		VBox layout2 = new VBox(75);
		ChoiceBox burger = new ChoiceBox(FXCollections.observableArrayList("Chicken", "Beef", "Lamb", "Vege"));

		Button meatNext = new Button("Next");
		meatNext.setOnAction(e -> primaryStage.setScene(scene3));

		meatNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout2.getChildren().addAll(selectBurger, burger, meatNext);
		layout2.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, 320, 480);

		BorderPane componentLayout = new BorderPane(); 

		// Scene 3

		Text selectBun = new Text("Choose your bun:");
		selectBun.setFont(Font.font ("Helvetica", 25));
		selectBun.setFill(Color.web("#ee0000"));		

		VBox layout3 = new VBox(75);
		ChoiceBox bun = new ChoiceBox(FXCollections.observableArrayList("White", "Wheat"));

		Button bunNext = new Button("Next");
		bunNext.setOnAction(e -> primaryStage.setScene(scene4));

		bunNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout3.getChildren().addAll(selectBun, bun, bunNext);
		layout3.setAlignment(Pos.CENTER);
		scene3 = new Scene(layout3, 320, 480);

		// Scene 4

		Text selectSalad = new Text("Choose your salad:");
		selectSalad.setFont(Font.font ("Helvetica", 25));
		selectSalad.setFill(Color.web("#ee0000"));		

		VBox layout4 = new VBox(75);
		HBox layout4Inner = new HBox(20);

		CheckBox salad1 = new CheckBox("Lettuce");
		CheckBox salad2 = new CheckBox("Tomatoes");
		CheckBox salad3 = new CheckBox("Cucumber");
		salad1.setSelected(true);

		Button saladNext = new Button("Next");

		saladNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Order successful - you have ordered " + burger.getSelectionModel().getSelectedItem() + " burger");
				System.out.println("Salads:");
				if (salad1.isSelected())
				{
					System.out.println("Lettuce is selected");
				}
				if (salad2.isSelected())
				{
					System.out.println("Tomatoes is selected");
				}
				if (salad3.isSelected())
				{
					System.out.println("Cucumber is selected");
				}
				primaryStage.setScene(scene5);
			}
		}
				);

		saladNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout4Inner.getChildren().addAll(salad1,salad2,salad3);
		layout4.getChildren().addAll(selectSalad,layout4Inner,saladNext);
		layout4.setAlignment(Pos.CENTER);
		layout4Inner.setAlignment(Pos.CENTER);
		scene4 = new Scene(layout4, 320, 480);

		// Scene 5

		Text selectSauce = new Text("Choose your sauce:");
		selectSauce.setFont(Font.font ("Helvetica", 25));
		selectSauce.setFill(Color.web("#ee0000"));		

		VBox layout5 = new VBox(75);
		HBox layout5Inner = new HBox(20);

		CheckBox sauce1 = new CheckBox("Mayonaise");
		CheckBox sauce2 = new CheckBox("BBQ");
		CheckBox sauce3 = new CheckBox("Aoli");
		sauce1.setSelected(true);

		Button sauceNext = new Button("Next");

		sauceNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				System.out.println("Order successful - you have ordered " + burger.getSelectionModel().getSelectedItem() + " burger");
				System.out.println("Sauces:");
				if (sauce1.isSelected())
				{
					System.out.println("Mayonaise is selected");
				}
				if (sauce2.isSelected())
				{
					System.out.println("BBQ is selected");
				}
				if (sauce3.isSelected())
				{
					System.out.println("Aoli is selected");
				}
				primaryStage.setScene(scene6);
			}
		}    
				);

		sauceNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout5Inner.getChildren().addAll(sauce1,sauce2,sauce3);
		layout5.getChildren().addAll(selectSauce,layout5Inner,sauceNext);
		layout5.setAlignment(Pos.CENTER);
		layout5Inner.setAlignment(Pos.CENTER);
		scene5 = new Scene(layout5, 320, 480);

		// Scene 6

		Text confirm = new Text("Confirm your order:");
		confirm.setFont(Font.font ("Helvetica", 25));
		confirm.setFill(Color.web("#ee0000"));		

		VBox layout6 = new VBox(75);

		Button confirmNext = new Button("Next");
		confirmNext.setOnAction(e -> primaryStage.setScene(scene7));

		confirmNext.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout6.getChildren().addAll(confirm, confirmNext);
		layout6.setAlignment(Pos.CENTER);
		scene6 = new Scene(layout6, 320, 480);

		// Scene 7

		Text finalMessage = new Text("Your order has been processed");
		finalMessage.setFont(Font.font ("Helvetica", 25));
		finalMessage.setFill(Color.web("#ee0000"));		

		VBox layout7 = new VBox(75);

		Button buttonReturn = new Button("Return");
		buttonReturn.setOnAction(e -> primaryStage.setScene(scene1));

		buttonReturn.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");

		layout7.getChildren().addAll(finalMessage, buttonReturn);
		layout7.setAlignment(Pos.CENTER);
		scene7 = new Scene(layout7, 320, 480);
	}

	// Scene 8

	//		Text loginMessage = new Text("Server login");
	//		finalMessage.setFont(Font.font ("Helvetica", 25));
	//		finalMessage.setFill(Color.web("#ee0000"));		
	//
	//		VBox layout8 = new VBox(75);
	//
	//		Button Login = new Button("Return");
	//		buttonReturn.setOnAction(e -> primaryStage.setScene(scene1));
	//
	//		buttonReturn.setStyle("-fx-background-color: #ff6633;-fx-background-radius: 0,0,0;-fx-font: 20px Tahoma;-fx-text-fill: white;");
	//
	//		layout7.getChildren().addAll(finalMessage, buttonReturn);
	//		layout7.setAlignment(Pos.CENTER);
	//		scene7 = new Scene(layout7, 320, 480);

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
