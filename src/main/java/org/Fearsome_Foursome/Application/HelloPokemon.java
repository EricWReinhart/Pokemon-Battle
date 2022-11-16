package org.Fearsome_Foursome.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloPokemon extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file. Obtain the root of the scene graph
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pokemonMenu.fxml"));
        Parent root = loader.load();

        // Set up the stage and show it
        primaryStage.setTitle("The Amazing Pokemon!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
