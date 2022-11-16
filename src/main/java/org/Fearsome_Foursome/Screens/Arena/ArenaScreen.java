/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2022
 * Instructor: Pro. Brian King
 * Date: 11/14/22
 * Time: 11:26 AM
 *
 * Project: csci205_final_project
 * Class: Game Application
 * Description: Application for launching the arena
 *
 *
 ****************************************
 */
package org.Fearsome_Foursome.Screens.Arena;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ArenaScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file. Obtain the root of the scene graph
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pokemonArena.fxml"));
        Parent root = loader.load();

        // Set up the stage and show it
        primaryStage.setTitle("The Arena!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
   