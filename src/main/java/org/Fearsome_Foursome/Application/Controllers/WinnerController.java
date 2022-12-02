/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/28/22
 * Time: 9:33 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Application.Controllers* Class: WinnerController
 *
 * Description:
 *
 * ****************************************
 */
/**
 * Sample Skeleton for 'winnerScreen.fxml' Controller Class
 */

package org.Fearsome_Foursome.Application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.HelloPokemon;

public class WinnerController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ash"
    private ImageView ash; // Value injected by FXMLLoader

    @FXML // fx:id="background"
    private ImageView background; // Value injected by FXMLLoader

    @FXML // fx:id="charizard"
    private ImageView charizard; // Value injected by FXMLLoader

    @FXML // fx:id="closeBtn"
    private Button closeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="homeBtn"
    private Button homeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private Text title; // Value injected by FXMLLoader

    @FXML // fx:id="win"
    private Text win; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ash != null : "fx:id=\"ash\" was not injected: check your FXML file 'winnerScreen.fxml'.";
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'winnerScreen.fxml'.";
        assert charizard != null : "fx:id=\"charizard\" was not injected: check your FXML file 'winnerScreen.fxml'.";
        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'winnerScreen.fxml'.";
        assert homeBtn != null : "fx:id=\"homeBtn\" was not injected: check your FXML file 'winnerScreen.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'winnerScreen.fxml'.";
        assert win != null : "fx:id=\"win\" was not injected: check your FXML file 'winnerScreen.fxml'.";

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
     * Method to return to the home screen
     * @param mouseEvent
     */
    public void returnHome(MouseEvent mouseEvent) {
        HelloPokemon.globalModel.getArena().refreshAll();
        Stage stage = (Stage)background.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_MENU);
    }
}


