// package JAVA;

// import javaapplication4.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.Pos;   
                             
public class RestaurantManagementSystem extends Application {

//////////////////// ????????
    private Label totalPriceLabel;
    Date orderTime=null;
    private Map<FoodItem, Integer> selectedItems = new HashMap<>();
//////////////////// ????????

    // ArrayList that holds all users registered in the JavaFX Restaurant
    private static ArrayList<User> users = new ArrayList<>(); 

    // index of the Array list for the user currently logged in  
    private static int currentUserIndex = 0; 
       
    // main primaryStage used in all pages 
    private Stage primaryStage;


    // start of the javaFX program 
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        enterPage();
    }




    private void enterPage() {

        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("Welcome to JavaFX Restaurant!!");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the Buttons
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 
         
        // create the Buttons  
        Button loginButton      = new Button("Login"); 
        Button registerButton   = new Button("Register"); 

        // adjust their margin
        VBox.setMargin(loginButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(registerButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        loginButton.setPrefSize(200,100); 
        registerButton.setPrefSize(200,100); 
        
        // customize Buttons style
        loginButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        registerButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(loginButton);
        vBox.getChildren().add(registerButton);

        // create action of login Button
        loginButton.setOnAction(e -> {loginPage();});
        registerButton.setOnAction(e -> {registerPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane, 650, 600);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void loginPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Login");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the username and password 
        TextField userNameField = new TextField();
        userNameField.setPromptText("Username");
        PasswordField pwdField = new PasswordField();
        pwdField.setPromptText("Password");

        // Customize the textFields
        userNameField.setMaxWidth(400);
        userNameField.setMinWidth(400);
        pwdField.setMaxWidth(400);
        pwdField.setMinWidth(400);
        userNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        pwdField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 

        // adjust margin of the TextFields Button
        VBox.setMargin(userNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(pwdField, new Insets(20, 0, 30, 0));

        // add the TextFields to the VBox 
        vBox.getChildren().add(userNameField);
        vBox.getChildren().add(pwdField);

        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(123);
        // hBox.setStyle("-fx-background-color: gold");
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create login Button & back Button then customize them
        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");
        loginButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(loginButton);
 
        // create action for the login Button
        loginButton.setOnAction(e -> {

            String userName = userNameField.getText();
            String password = pwdField.getText();
            boolean validCredentials = false; 

            for(int i = 0; i < users.size(); i++) {
                if((userName.equals(users.get(i).getUserName())) && (password.equals(users.get(i).getPassword()))) {
                    validCredentials = true; 
                    currentUserIndex = i;
                    break;
                }
            } 

            if (validCredentials == true) {
                if(users.get(currentUserIndex).getUserName() == "admin") {
                    adminLoggedInPage(); 
                } 
                else {
                    userLoggedInPage(); 
                }
            } 
            else {
                // Show error message for invalid credentials
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password");
                alert.showAndWait();
            }

        });

        // create action for the back Button
        backButton.setOnAction(e -> {enterPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 600);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void registerPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Register");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the username and password 
        TextField userNameField = new TextField();
        PasswordField pwdField = new PasswordField();
        TextField phoneNumberField = new TextField();
        TextField addressField = new TextField();
        userNameField.setPromptText("Username");
        pwdField.setPromptText("Password");
        phoneNumberField.setPromptText("Phone Number");
        addressField.setPromptText("Address");

        // Customize the textFields
        userNameField.setMinWidth(400);
        userNameField.setMaxWidth(400);
        pwdField.setMinWidth(400);
        pwdField.setMaxWidth(400);
        phoneNumberField.setMinWidth(400);
        phoneNumberField.setMaxWidth(400);
        addressField.setMinWidth(400);
        addressField.setMaxWidth(400);
        userNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        pwdField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        phoneNumberField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        addressField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 

        // adjust margin of the TextFields Button
        VBox.setMargin(userNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(pwdField, new Insets(20, 0, 30, 0));
        VBox.setMargin(phoneNumberField, new Insets(20, 0, 30, 0));
        VBox.setMargin(addressField, new Insets(20, 0, 30, 0));

        // add the TextFields to the VBox 
        vBox.getChildren().add(userNameField);
        vBox.getChildren().add(pwdField);
        vBox.getChildren().add(phoneNumberField);
        vBox.getChildren().add(addressField);

        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create login Button & back Button then customize them
        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");
        registerButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(registerButton);
 
        // create action for the register Button
        registerButton.setOnAction(e -> {

            String userName = userNameField.getText();
            String password = pwdField.getText();
            String phoneNumber = phoneNumberField.getText();
            String address = addressField.getText();

            boolean errorExists = false;
            boolean duplicateExists = false;

            errorExists = checkErrorsInInput(userName, password, phoneNumber, address);
            
            if(errorExists == false) {
                duplicateExists = checkDuplicatesInInput(userName, phoneNumber);
                if(duplicateExists == false) {
                    // add the user to the database 
                    addUser(userName, password, phoneNumber, address); 
                     
                    // display Successful registration message 
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful Registration!!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Congratulations! You have sucessfully registered in the JavaFX Restaurant, enjoy your meals!");
                    alert.showAndWait();

                    // go back to the enter page to enter the new credentials and log in
                    enterPage();
                }            
            }
                                                  
        });

        // create action for the back Button
        backButton.setOnAction(e -> {enterPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void userLoggedInPage() {

        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("Welcome back "+users.get(currentUserIndex).getUserName()+"!!");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the Buttons
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 
         
        // create the Buttons  
        Button menuButton       = new Button("Menu"); 
        Button orderButton      = new Button("Order"); 
        Button logoutButton     = new Button("Logout"); 

        // adjust their margin
        VBox.setMargin(menuButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(orderButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(logoutButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        menuButton.setPrefSize(200,100); 
        orderButton.setPrefSize(200,100); 
        logoutButton.setPrefSize(200,100); 
        
        // customize Buttons style
        menuButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        orderButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        logoutButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(menuButton);
        vBox.getChildren().add(orderButton);
        vBox.getChildren().add(logoutButton);

        // create action of login Button
        menuButton.setOnAction(e -> {menuPage();});
        orderButton.setOnAction(e -> {orderPage();});
        logoutButton.setOnAction(e -> {
            currentUserIndex = 0;
            enterPage();
        });

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane, 650, 600);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void adminLoggedInPage() {

        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("Welcome back "+users.get(currentUserIndex).getUserName()+"!!");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the Buttons
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 
         
        // create the Buttons  
        Button addButton       = new Button("Add Item"); 
        Button editButton      = new Button("Change Item"); 
        Button deleteButton    = new Button("Delete Item"); 
        Button logoutButton    = new Button("Logout"); 

        // adjust their margin
        VBox.setMargin(addButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(editButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(deleteButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(logoutButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        addButton.setPrefSize(300,100); 
        editButton.setPrefSize(300,100); 
        deleteButton.setPrefSize(300,100); 
        logoutButton.setPrefSize(300,100); 
        
        // customize Buttons style
        addButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        editButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        deleteButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        logoutButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(addButton);
        vBox.getChildren().add(editButton);
        vBox.getChildren().add(deleteButton);
        vBox.getChildren().add(logoutButton);

        // create action of login Button
        addButton.setOnAction(e -> {addItemPage();});
        editButton.setOnAction(e -> {editItemPage();});
        deleteButton.setOnAction(e -> {deleteItemPage();});
        logoutButton.setOnAction(e -> {enterPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane, 650, 750);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void menuPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Menu");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the pictures + labels 
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create another HBox for the Bottom Back Button
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create back Button then customize it and add it to the HBox
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        controlButtonsHBox.getChildren().add(backButton);

        // create action for the back Button
        backButton.setOnAction(e -> {userLoggedInPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void orderPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Order");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the username and password 
        TextField userNameField = new TextField();
        PasswordField pwdField = new PasswordField();
        TextField phoneNumberField = new TextField();
        TextField addressField = new TextField();
        userNameField.setPromptText("Username");
        pwdField.setPromptText("Password");
        phoneNumberField.setPromptText("Phone Number");
        addressField.setPromptText("Address");

        // Customize the textFields
        userNameField.setMinWidth(400);
        userNameField.setMaxWidth(400);
        pwdField.setMinWidth(400);
        pwdField.setMaxWidth(400);
        phoneNumberField.setMinWidth(400);
        phoneNumberField.setMaxWidth(400);
        addressField.setMinWidth(400);
        addressField.setMaxWidth(400);
        userNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        pwdField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        phoneNumberField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        addressField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 

        // adjust margin of the TextFields Button
        VBox.setMargin(userNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(pwdField, new Insets(20, 0, 30, 0));
        VBox.setMargin(phoneNumberField, new Insets(20, 0, 30, 0));
        VBox.setMargin(addressField, new Insets(20, 0, 30, 0));

        // add the TextFields to the VBox 
        vBox.getChildren().add(userNameField);
        vBox.getChildren().add(pwdField);
        vBox.getChildren().add(phoneNumberField);
        vBox.getChildren().add(addressField);

        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        // hBox.setStyle("-fx-background-color: gold");
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create login Button & back Button then customize them
        Button placeOrderButton = new Button("Place Order");
        Button backButton = new Button("Back");
        placeOrderButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(placeOrderButton);
 
        // create action for the placeOrder Button
        placeOrderButton.setOnAction(e -> {
            // place the order                                 
        });

        // create action for the back Button
        backButton.setOnAction(e -> {userLoggedInPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void addItemPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Add Item");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the pictures + labels 
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create another HBox for the Bottom Back Button
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create back Button then customize it and add it to the HBox
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        controlButtonsHBox.getChildren().add(backButton);

        // create action for the back Button
        backButton.setOnAction(e -> {adminLoggedInPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void editItemPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Edit Item");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the pictures + labels 
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create another HBox for the Bottom Back Button
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create back Button then customize it and add it to the HBox
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        controlButtonsHBox.getChildren().add(backButton);

        // create action for the back Button
        backButton.setOnAction(e -> {adminLoggedInPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void deleteItemPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Delete Item");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the pictures + labels 
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create another HBox for the Bottom Back Button
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create back Button then customize it and add it to the HBox
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        controlButtonsHBox.getChildren().add(backButton);

        // create action for the back Button
        backButton.setOnAction(e -> {adminLoggedInPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }





    private void tableRegistrationPage() {
    // Prompt the user to select a table
    
    boolean validInput = false;
    List<Table> availableTables = Table.getAvailableTables(); // Implement this method to retrieve available tables
    ChoiceDialog<Table> tableChoiceDialog = new ChoiceDialog<>(null, availableTables);
    tableChoiceDialog.setHeaderText("Select a table:");
    Optional<Table> selectedTableResult = tableChoiceDialog.showAndWait();

    if (selectedTableResult.isPresent()) {
        Table selectedTable = selectedTableResult.get();

        // Prompt the user to input order time
        while (!validInput){
        TextInputDialog orderTimeDialog = new TextInputDialog();
        orderTimeDialog.setHeaderText("Enter order time (dd/MM/yyyy HH:mm):");
        Optional<String> orderTimeResult = orderTimeDialog.showAndWait();
        
        if (orderTimeResult.isPresent()) {
            // Parse the order time string to Date
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            try {
                 orderTime = sdf.parse(orderTimeResult.get());
                selectedTable.setOrderTime(orderTime);
                validInput=true;

                // Prompt the user to input the duration
                TextInputDialog durationDialog = new TextInputDialog();
                durationDialog.setHeaderText("Enter duration in minutes:");
                Optional<String> durationResult = durationDialog.showAndWait();

                if (durationResult.isPresent()) {
                    int duration = Integer.parseInt(durationResult.get());
                    selectedTable.setDuration(duration);

                    // Proceed with other operations (e.g., menu selection)
                    menuSelectionPage();
                } else {
                    // Duration input cancelled
                    // Handle this case as needed
                }
            } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid input format");
            alert.setContentText("Please enter the order time in the correct format (day/month/year HH:MM).");
            alert.showAndWait();
            
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
                // Invalid duration input
                // Handle this case as needed
            }
        } else {
           
            // Exit the method if the dialog is cancelled
            // Order time input cancelled
            // Handle this case as needed
        }

    // else {
        // Table selection cancelled
        // Handle this case as needed
        // }

} // end of while

} // of the if before while 

} // end of TableRegistrationPage
 
    private void registerTable(int tableNumber) {
        // Implement table registration logic here
        // For now, let's just display a message
        System.out.println("Table " + tableNumber + " registered");
        // After registering the table, you can proceed to the next stage
        menuSelectionPage();
    }

    private void menuSelectionPage() {
         
        // Implement menu selection page
        VBox menuSelectionLayout = new VBox(10);
        menuSelectionLayout.setPadding(new Insets(20));

        Label menuLabel = new Label("Select Food Items:");
        VBox foodItemsLayout = new VBox(5);
        for (FoodItem foodItem : FoodItem.getFoodItems()) {
            CheckBox checkBox = new CheckBox(foodItem.getName());
            Spinner<Integer> quantitySpinner = new Spinner<>(0, 10, 0);
            quantitySpinner.setEditable(true);
            HBox itemLayout = new HBox(10);
            itemLayout.getChildren().addAll(checkBox, new Label("Quantity:"), quantitySpinner);
            checkBox.setOnAction(e -> {
                if (checkBox.isSelected()) {
                    selectedItems.put(foodItem, quantitySpinner.getValue());
                } else {
                    selectedItems.remove(foodItem);
                }
                updateTotalPrice();
            });
            quantitySpinner.getValueFactory().valueProperty().addListener((observable, oldValue, newValue) -> {
                if (checkBox.isSelected()) {
                    selectedItems.put(foodItem, newValue);
                    updateTotalPrice();
                }
            });
            foodItemsLayout.getChildren().add(itemLayout);
        }

        totalPriceLabel = new Label("Total Price: $0.00");
        Button submitButton = new Button("Submit Order");
        submitButton.setOnAction(e -> submitOrder(orderTime.toString()));

        menuSelectionLayout.getChildren().addAll(menuLabel, foodItemsLayout, totalPriceLabel, submitButton);
        Scene scene = new Scene(menuSelectionLayout, 400, 300);
        primaryStage.setScene(scene);
    }

    private void updateTotalPrice() {
        float totalPrice = 0;
        for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
    }

    private void submitOrder(String orderTime) {
        // Implement order submission logic here
        // For now, let's just display a message with selected items and total price
        StringBuilder orderDetails = new StringBuilder("Selected Items:\n");
        
        for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
            orderDetails.append(entry.getKey().getName()).append(" (Quantity: ").append(entry.getValue()).append(")\n");
        }
        float totalPrice = 0;
       
        for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        orderSubmissionPage(orderTime, totalPrice);
        orderDetails.append("\nTotal Price: $").append(String.format("%.2f", totalPrice));
        System.out.println(orderDetails.toString());
    }

    private void orderSubmissionPage(String orderTime, double totalPrice) {
    // Create labels to display order time and total price
    Label orderTimeLabel = new Label("Order Time: " + orderTime);
    Label totalPriceLabel = new Label("Total Price: $" + String.format("%.2f", totalPrice));

    // Create a button to close the stage
    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> primaryStage.close());

    // Create a layout to arrange the components
    VBox layout = new VBox(20);
    layout.setPadding(new Insets(20));
    layout.getChildren().addAll(orderTimeLabel, totalPriceLabel, closeButton);

    // Update the scene with the new layout
    Scene scene = new Scene(layout, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Order Confirmation");
}






    private static void addUser(String userName, String password, String phoneNumber, String Address) {
        User tmpUser = new User(userName, password, phoneNumber, Address);
        users.add(tmpUser); 
    }

    private static boolean checkErrorsInInput(String userName, String password, String phoneNumber, String address) {
        if(userName.length() < 3) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("User Name must be at least 3 characters long, please enter a valid User Name...");
                alert.showAndWait(); 
                return true; 
        } 

        if(password.length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password must be at least 8 characters long, please enter a valid Password...");
            alert.showAndWait(); 
            return true; 
        }  

        for(int i = 0; i < userName.length(); i++) {
            if (!Character.isDigit(userName.charAt(i)) && !Character.isLetter(userName.charAt(i)) && !Character.isWhitespace(userName.charAt(i))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("User Name can't contains special characters, only letters/numbers/spaces are allowed, please enter a valid User Name...");
                alert.showAndWait();                      
                return true; 
            }    
        } 

        for(int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Phone Number must consist of 11 numbers only starting with 0, please enter a valid Phone Number...");
                alert.showAndWait();                      
                return true; 
            }    
        } 

        if(phoneNumber.length() != 11) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Phone Number must consist of 11 numbers only starting with 0, please enter a valid Phone Number...");
            alert.showAndWait(); 
            return true; 
        }  

        if(address.length() <= 5) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("please enter a valid Address...");
                alert.showAndWait(); 
                return true; 
        }                 

        return false; 
    }

    private static boolean checkDuplicatesInInput(String userName, String phoneNumber) {
        for(User user : users) {
            if((userName.equals(user.getUserName()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("User Name provided is already registered, please enter another User Name...");
                alert.showAndWait();
                return true; 
            }
            if((phoneNumber.equals(user.getPhoneNumber()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Phone Number provided is already registered, please enter another Phone Number...");
                alert.showAndWait();
                return true; 
            }
        }  
        return false; 
    }


    public static void main(String[] args) {
        
        // create an empty user which indicates that there is no user currently logged in (its index in the ArrayList is 0)
        addUser("", "", "", ""); 

        // create the admin user (its index in the ArrayList is 2)
        addUser("admin", "admin", "00000000000", ""); 

        // create a test user (its index in the ArrayList is 3)
        addUser("test", "test", "01123456789", "Cairo, Egypt"); 

        // run the javaFX program
        Application.launch(args);

    }



}






