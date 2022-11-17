/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/14/22
 * Time: 5:31 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Screens.View* Class: viewController
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.HelloPokemon;

public class SelectionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView background;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSelect;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private CheckBox checkBox3;

    @FXML
    private CheckBox checkBox4;

    @FXML
    private CheckBox checkBox5;

    @FXML
    private CheckBox checkBox6;

    @FXML
    private ProgressBar currentHealth1;

    @FXML
    private ProgressBar currentHealth2;

    @FXML
    private ProgressBar currentHealth3;

    @FXML
    private ProgressBar currentHealth4;

    @FXML
    private ProgressBar currentHealth5;

    @FXML
    private ProgressBar currentHealth6;

    @FXML
    private Text health1;

    @FXML
    private Text health2;

    @FXML
    private Text health3;

    @FXML
    private Text health4;

    @FXML
    private Text health5;

    @FXML
    private Text health6;

    @FXML
    private HBox pokemon1;

    @FXML
    private HBox pokemon2;

    @FXML
    private HBox pokemon3;

    @FXML
    private HBox pokemon4;

    @FXML
    private HBox pokemon5;

    @FXML
    private HBox pokemon6;

    @FXML
    private ImageView sprite1;

    @FXML
    private ImageView sprite2;

    @FXML
    private ImageView sprite3;

    @FXML
    private ImageView sprite4;

    @FXML
    private ImageView sprite5;

    @FXML
    private ImageView sprite6;

    @FXML
    private Text textSelection;

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert btnSelect != null : "fx:id=\"btnSelect\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert checkBox1 != null : "fx:id=\"checkBox1\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert checkBox2 != null : "fx:id=\"checkBox2\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert checkBox3 != null : "fx:id=\"checkBox3\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert checkBox4 != null : "fx:id=\"checkBox4\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert checkBox5 != null : "fx:id=\"checkBox5\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert checkBox6 != null : "fx:id=\"checkBox6\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert currentHealth1 != null : "fx:id=\"currentHealth1\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert currentHealth2 != null : "fx:id=\"currentHealth2\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert currentHealth3 != null : "fx:id=\"currentHealth3\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert currentHealth4 != null : "fx:id=\"currentHealth4\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert currentHealth5 != null : "fx:id=\"currentHealth5\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert currentHealth6 != null : "fx:id=\"currentHealth6\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert health1 != null : "fx:id=\"health1\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert health2 != null : "fx:id=\"health2\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert health3 != null : "fx:id=\"health3\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert health4 != null : "fx:id=\"health4\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert health5 != null : "fx:id=\"health5\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert health6 != null : "fx:id=\"health6\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert pokemon1 != null : "fx:id=\"pokemon1\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert pokemon2 != null : "fx:id=\"pokemon2\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert pokemon3 != null : "fx:id=\"pokemon3\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert pokemon4 != null : "fx:id=\"pokemon4\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert pokemon5 != null : "fx:id=\"pokemon5\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert pokemon6 != null : "fx:id=\"pokemon6\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert sprite1 != null : "fx:id=\"sprite1\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert sprite2 != null : "fx:id=\"sprite2\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert sprite3 != null : "fx:id=\"sprite3\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert sprite4 != null : "fx:id=\"sprite4\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert sprite5 != null : "fx:id=\"sprite5\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert sprite6 != null : "fx:id=\"sprite6\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert textSelection != null : "fx:id=\"textSelection\" was not injected: check your FXML file 'pokemonSelection.fxml'.";

    }

    /**
     * Method to select the Pokemon and switch the arena
     * @param mouseEvent
     */
    public void selectAndSwitchToArena(javafx.scene.input.MouseEvent mouseEvent) {
        // something, something
        this.switchToArena(mouseEvent);
    }

    /**
     * Method to switch back to the arena
     * @param mouseEvent
     */
    public void switchToArena(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage)background.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_ARENA);
    }

    /**
     * Method to return to the home screen
     * @param mouseEvent
     */
    public void returnHome(MouseEvent mouseEvent) {
        Stage stage = (Stage)background.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_MENU);
    }
}

