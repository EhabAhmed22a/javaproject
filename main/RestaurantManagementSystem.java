// package JAVA;


// import javaapplication4.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class RestaurantManagementSystem extends Application {

    // Sample username and password for login
    private Label totalPriceLabel;
    Date orderTime=null;
    private Map<FoodItem, Integer> selectedItems = new HashMap<>();
    private static final String USERNAME = "a";
    private static final String PASSWORD = "p";

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        enterPage();
        primaryStage.show(); // Show the stage after setting up the scene
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
        Button menuButton       = new Button("Menu"); 
        Button loginButton      = new Button("Login"); 
        Button registerButton   = new Button("Register"); 

        // adjust their margin
        VBox.setMargin(menuButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(loginButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(registerButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        menuButton.setPrefSize(200,100); 
        loginButton.setPrefSize(200,100); 
        registerButton.setPrefSize(200,100); 
        
        // customize Buttons style
        menuButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 2em; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        loginButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 2em; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        registerButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 2em; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(menuButton);
        vBox.getChildren().add(loginButton);
        vBox.getChildren().add(registerButton);

        // create action of login Button
        menuButton.setOnAction(e -> {menuPage();});
        loginButton.setOnAction(e -> {loginPage();});
        registerButton.setOnAction(e -> {registerPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void loginPage() {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                // If credentials are valid, proceed to the next page
                tableRegistrationPage();
            } else {
                // Show error message for invalid credentials
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password");
                alert.showAndWait();
            }
        });

        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.getChildren().addAll(usernameField, passwordField, loginButton);
        Scene scene = new Scene(loginLayout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
    }

    private void menuPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("Menu");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the Buttons
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 
         
        // create the Buttons  
        Button menuButton       = new Button("Menu"); 
        Button loginButton      = new Button("Login"); 
        Button registerButton   = new Button("Register"); 

        // adjust their margin
        VBox.setMargin(menuButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(loginButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(registerButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        menuButton.setPrefSize(200,100); 
        loginButton.setPrefSize(200,100); 
        registerButton.setPrefSize(200,100); 
        
        // customize Buttons style
        menuButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 2em; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        loginButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 2em; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        registerButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 2em; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(menuButton);
        vBox.getChildren().add(loginButton);
        vBox.getChildren().add(registerButton);

        // create action of login Button
        menuButton.setOnAction(e -> {menuPage();});
        loginButton.setOnAction(e -> {loginPage();});
        registerButton.setOnAction(e -> {registerPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
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




    public static void main(String[] args) {
        Application.launch(args);
    }



}






