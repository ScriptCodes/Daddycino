package com.example.daddycino;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Pane root;


    public void switchScene1(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("LoginGUI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchScene2(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("LoginGUI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
