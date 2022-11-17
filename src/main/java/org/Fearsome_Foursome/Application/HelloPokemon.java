package org.Fearsome_Foursome.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.Controllers.ArenaController;

import java.io.IOException;

// SOURCE FOR SCENE SWITCHING METHOD:
// https://github.com/bkingcs/MultiSceneTest

public class HelloPokemon extends Application {

    /** Static model to be used by MenuController, ArenaController, SelectionController */
    public static GameModel globalModel;

    /** Stores a reference to the Arena Controller */
    private ArenaController arenaController;

    /**
     * We need an enumeration for all of our Scenes - a public inner class
     */
    public enum GameScenes {

        /** There exist exactly 3 GameScenes objects - here they are */
        POKEMON_ARENA("/pokemonArena.fxml"),
        POKEMON_SELECTION("/pokemonSelection.fxml"),
        POKEMON_MENU("/pokemonMenu.fxml");

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

        // initialize the Arena Controller
        arenaController = new ArenaController(globalModel);

        // Load the FXML file. Obtain the root of the scene graph
        loadScene(primaryStage, GameScenes.POKEMON_MENU);

        // Set up both Pokemon on the Arena
        arenaController.setUpPokemon();
            // TODO: this same method is called whenever you swap in a new Pokemon

        // Set up the stage and show it
        primaryStage.setTitle("The Amazing Pokemon!");
        primaryStage.show();
    }

    /**
     * Use an FXMLLoader to create a Scene to set on the input stage
     * @param stage
     * @param scene
     * @throws IOException
     */
    public static void loadScene(Stage stage, GameScenes scene) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloPokemon.class.getResource(scene.getFileName()));
        try {
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
