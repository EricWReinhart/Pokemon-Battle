/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/12/22
 * Time: 11:05 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Screens.Menu* Class: MenuContoller
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.HelloPokemon;

import javax.sound.sampled.*;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;

    @FXML
    private Text author;

    @FXML
    private Button btnStart;

    @FXML
    private Button closeBtn;

    @FXML
    private ImageView bird;

    @FXML
    private ImageView dragonite;

    @FXML
    private ImageView grass1;

    @FXML
    private ImageView grass2;

    @FXML
    private ImageView grass3;

    @FXML
    private ImageView pikachu;

    @FXML
    private Label title;

    @FXML
    private Text tm;

    @FXML
    private Text version;

    @FXML
    private Button btnHardMode;

    @FXML
    void initialize() {
        assert Background != null : "fx:id=\"Background\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert bird != null : "fx:id=\"bird\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert dragonite != null : "fx:id=\"dragonite\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert grass1 != null : "fx:id=\"grass1\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert grass2 != null : "fx:id=\"grass2\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert grass3 != null : "fx:id=\"grass3\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert pikachu != null : "fx:id=\"pikachu\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert tm != null : "fx:id=\"tm\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert version != null : "fx:id=\"version\" was not injected: check your FXML file 'pokemonMenu.fxml'.";

    }

    /**
     * Go to the arena
     * @param mouseEvent
     */
    public void showArena(javafx.scene.input.MouseEvent mouseEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        // Randomize the teams and play battle music
        HelloPokemon.globalModel.getArena().refreshAll();
        HelloPokemon.playMusic("BattleMusic.wav");
        // Get the Stage object of this button
        Stage stage = (Stage) btnStart.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_ARENA);
        HelloPokemon.arenaController.setUpPokemon(0, 0);
        HelloPokemon.arenaController.setInitialBattleTextLog();
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
     * Set the {@link ArenaController} static hard mode boolean
     * @param mouseEvent
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * @throws IOException
     */
    public void setHard(MouseEvent mouseEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ArenaController.hardMode = !ArenaController.hardMode;
        showArena(mouseEvent);
    }

}
