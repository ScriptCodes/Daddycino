package com.example.daddycino;

import DataReader.FileIO;
import UserRelated.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField UsernameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Label statusLabel;

    private ArrayList<User> users;
    @FXML
    private Stage userChoices = new Stage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize your users collection
        users = new FileIO().readUserData();
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String username = UsernameField.getText();
        String password = PasswordField.getText();

        // Validate login credentials
        boolean isValidLogin = validateLogin(users, username, password);

        if (isValidLogin) {
            Platform.runLater(() -> {

                try {
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuGUI.fxml"));
                    Parent root = loader.load();
                    userChoices.setScene(new Scene(root));;
                    userChoices.show();

                } catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                    //showErrorDialog("Error1", "An error occurred while loading the next screen.");
                }
            });
        } else {
            statusLabel.setText("Invalid username or password");
        }
    }

    private boolean validateLogin(ArrayList<User> users, String username, String password) {
        // Validate the entered username and password
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Set the user as logged in
                user.setLoggedIn(true);
                // Save the updated user data
                //new FileIO().saveUserData(users);
                return true;
            }
        }
        return false;
    }
}
