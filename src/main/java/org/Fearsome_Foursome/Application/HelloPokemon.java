package org.Fearsome_Foursome.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.Controllers.*;

import java.io.IOException;
import java.util.Arrays;

// SOURCE FOR SCENE SWITCHING METHOD:
// https://github.com/bkingcs/MultiSceneTest

public class HelloPokemon extends Application {

    /** Static model to be used by MenuController, ArenaController, SelectionController */
    public static GameModel globalModel;

    /** Reference to Arena Controller */
    public static ArenaController arenaController;
    /** Reference to Menu Controller */
    public static MenuController menuController;
    /** Reference to Selection Controller */
    public static SelectionController selectionController;
    /** Reference to the WinnerScreen Controller */
    public static WinnerController winnerController;
    /** Reference to the LoserScreen Controller */
    public static LoserController loserController;

    /**
     * We need an enumeration for all of our Scenes - a public inner class
     */
    public enum GameScenes {

        /** There exist exactly 3 GameScenes objects - here they are */
        POKEMON_ARENA("/pokemonArena.fxml"),
        POKEMON_SELECTION("/pokemonSelection.fxml"),
        POKEMON_MENU("/pokemonMenu.fxml"),
        WINNER_SCREEN("/winnerScreen.fxml"),
        LOSER_SCREEN("/loserScreen.fxml");

        /** Attribute for a string which can load the scene */
        private final String fileName;

        /**
         * Not just anyone can call this constructor - set the fileName attribute
         * @param fileName
         */
        private GameScenes(String fileName){
            this.fileName = fileName;
        }

        /** Simple method to return the file name of the scene */
        public String getFileName() {
            return fileName;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // initialize the global model
        globalModel = new GameModel();

        // Load the FXML file. Obtain the root of the scene graph
        loadScene(primaryStage, GameScenes.POKEMON_MENU);

        // Set up the stage and show it
        primaryStage.setTitle("The Amazing Pokemon!");
        primaryStage.show();
    }


    /**
     * Use an FXMLLoader to create a Scene to set on the input stage. When loading in a scene, set its respective
     * controller up properly.
     * @param stage
     * @param scene
     * @throws IOException
     */
    public static void loadScene(Stage stage, GameScenes scene) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloPokemon.class.getResource(scene.getFileName()));
        try {
            Parent root = loader.load();
            if (scene.equals(GameScenes.POKEMON_ARENA)) {
                arenaController = loader.getController();
            }

            else if (scene.equals(GameScenes.POKEMON_MENU)) {
                menuController = loader.getController();
            }

            else if (scene.equals(GameScenes.POKEMON_SELECTION)) {
                selectionController = loader.getController();
            }

            else if (scene.equals(GameScenes.WINNER_SCREEN)) {
                winnerController = loader.getController();
            }

            else if (scene.equals(GameScenes.LOSER_SCREEN)) {
                loserController = loader.getController();
            }

            stage.setScene(new Scene(root));
            stage.setResizable(false);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Changes the color of the progress bar depending on the percent health remaining.
     * Green: health > 67%, Yellow: 33% < health < 67%, Red: health < 33%
     * @param progressBar player or enemy progress bar
     */
    public static void progressBarColor(ProgressBar progressBar) {
        if (progressBar.getProgress() > 0.67) {
            progressBar.setStyle("-fx-accent: " + "green");
        }
        else if (progressBar.getProgress() > 0.33 && progressBar.getProgress() < 0.67) {
            progressBar.setStyle("-fx-accent: " + "yellow");
        }
        else {
            progressBar.setStyle("-fx-accent: " + "red");
        }
    }

}
