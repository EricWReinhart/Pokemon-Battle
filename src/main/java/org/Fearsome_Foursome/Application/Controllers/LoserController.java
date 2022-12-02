package org.Fearsome_Foursome.Application.Controllers;

/**
 * Sample Skeleton for 'loserScreen.fxml' Controller Class
 */


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.HelloPokemon;

public class LoserController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="background"
    private ImageView background; // Value injected by FXMLLoader

    @FXML // fx:id="closeBtn"
    private Button closeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="gameOver"
    private ImageView gameOver; // Value injected by FXMLLoader

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="question"
    private Label question; // Value injected by FXMLLoader

    @FXML // fx:id="sadPikachu"
    private ImageView sadPikachu; // Value injected by FXMLLoader

    @FXML // fx:id="startBtn"
    private Button startBtn; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'loserScreen.fxml'.";
        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'loserScreen.fxml'.";
        assert gameOver != null : "fx:id=\"gameOver\" was not injected: check your FXML file 'loserScreen.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'loserScreen.fxml'.";
        assert question != null : "fx:id=\"question\" was not injected: check your FXML file 'loserScreen.fxml'.";
        assert sadPikachu != null : "fx:id=\"sadPikachu\" was not injected: check your FXML file 'loserScreen.fxml'.";
        assert startBtn != null : "fx:id=\"startBtn\" was not injected: check your FXML file 'loserScreen.fxml'.";

    }

    /**
     * Quit the application
     * @param event
     */
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * Go to the arena
     * @param mouseEvent
     */
    public void returnHome(javafx.scene.input.MouseEvent mouseEvent) {
        // Get the Stage object of this button
        HelloPokemon.globalModel.getArena().refreshAll();
        Stage stage = (Stage) startBtn.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_MENU);
    }

}
