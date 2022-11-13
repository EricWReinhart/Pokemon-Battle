package org.Fearsome_Foursome.Pokemons.Arena2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Pokemons.Arena2.model.ParticleSystemModel;

import java.io.IOException;

public class ParticleSystemMain extends Application {
    private ParticleSystemModel theModel;
    private ParticleSystemController theController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.theModel = new ParticleSystemModel();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/lab11/particlesim.fxml"));
        Parent root = loader.load();
        this.theController = loader.getController();
        this.theController.setModel(theModel);

        // Set up our stage
        primaryStage.setTitle("Particle Simulator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
