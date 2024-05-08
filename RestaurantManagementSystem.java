package JAVA;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javaapplication4.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantManagementSystem extends Application {

    // Sample username and password for login
    private Label totalPriceLabel;
    private Date orderTime=new Date();
    private Map<FoodItem, Integer> selectedItems = new HashMap<>();
    private static final String USERNAME = "a";
    private static final String PASSWORD = "p";

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        loginPage();
        primaryStage.show(); // Show the stage after setting up the scene
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

       private void tableRegistrationPage() {
    // Prompt the user to select a table
    List<Table> availableTables = Table.getAvailableTables(); // Implement this method to retrieve available tables
    ChoiceDialog<Table> tableChoiceDialog = new ChoiceDialog<>(null, availableTables);
    tableChoiceDialog.setHeaderText("Select a table:");
    Optional<Table> selectedTableResult = tableChoiceDialog.showAndWait();

    if (selectedTableResult.isPresent()) {
        Table selectedTable = selectedTableResult.get();

        // Prompt the user to input order time
        TextInputDialog orderTimeDialog = new TextInputDialog();
        orderTimeDialog.setHeaderText("Enter order time (HH:mm):");
        Optional<String> orderTimeResult = orderTimeDialog.showAndWait();

        if (orderTimeResult.isPresent()) {
            // Parse the order time string to Date
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
                Date orderTime = sdf.parse(orderTimeResult.get());
                selectedTable.setOrderTime(orderTime);

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
                e.printStackTrace();
                // Error parsing order time
                // Handle this case as needed
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Invalid duration input
                // Handle this case as needed
            }
        } else {
            // Order time input cancelled
            // Handle this case as needed
        }
    } else {
        // Table selection cancelled
        // Handle this case as needed
    }
}
 

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
        launch(args);
    }
}