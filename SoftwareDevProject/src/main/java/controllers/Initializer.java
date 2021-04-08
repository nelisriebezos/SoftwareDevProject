package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Initializer extends Application{
    public static void main(String[] args) throws IOException {
    	Manager.getInstance().leesIn();
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        String fxmlPagina = "/UI/login.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
        Parent root = loader.load();
        stage.setTitle("Home");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
