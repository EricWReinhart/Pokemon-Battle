/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Group: Fearsome Foursome
 * Section: 02
 * Date: 11/10/22
 * Time: 9:34 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.GameMVC.Model.Controller
 * Class: GameController
 *
 * Description: Controller component of the Game MVC
 *
 * *****************************************/

package org.Fearsome_Foursome.Application.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.GameModel;
import org.Fearsome_Foursome.Application.HelloPokemon;
import org.Fearsome_Foursome.Creatures.Creature;
import org.Fearsome_Foursome.Moves.Move;

import java.util.ArrayList;
import java.util.HashMap;

public class ArenaController {

    @FXML
    private ProgressBar enemyHealthProgressBar;
    @FXML
    private Button btnQuit;

    @FXML
    private Button moveButton1;

    @FXML
    private Button moveButton2;

    @FXML
    private Button moveButton3;

    @FXML
    private Button moveButton4;

    @FXML
    private ProgressBar selfHealthProgressBar1;

    @FXML
    private Button swapPokemonButton;

    void initialize() {
        assert enemyHealthProgressBar != null : "fx:id=\"enemyHealthProgressBar\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton1 != null : "fx:id=\"moveButton1\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton2 != null : "fx:id=\"moveButton2\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton3 != null : "fx:id=\"moveButton3\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton4 != null : "fx:id=\"moveButton4\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert selfHealthProgressBar1 != null : "fx:id=\"selfHealthProgressBar1\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert swapPokemonButton != null : "fx:id=\"swapPokemonButton\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'pokemonArena.fxml'.";

    }

    /** Reference to the gameModel */
    private GameModel gameModel;

    private Creature playerCreatureUpFront;
    private Creature enemyCreatureUpFront;

    /**
     * Constructor for Arena Controller that stores a reference to the gameModel
     * @param gameModel the game model
     */
    public ArenaController(GameModel gameModel) {
        gameModel = gameModel;
        playerCreatureUpFront = gameModel.getPlayerCreatureUpFront();
        enemyCreatureUpFront = gameModel.getEnemyCreatureUpFront();
    }

    public void setUpPokemon() {
        moveButton1.setText(playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(0).getName());
//        moveButton1.


        }

    /**
     * Switch to the Pokemon Selection screen and set up the current Pokemon on the arena
     * @param mouseEvent
     */
    public void switchToSelection(MouseEvent mouseEvent) {
        Stage stage = (Stage)swapPokemonButton.getScene().getWindow();
        setUpPokemon();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_SELECTION);
    }

    /**
     * Return to home screen
     * @param mouseEvent
     */
    public void goHome(MouseEvent mouseEvent) {
        Stage stage = (Stage)btnQuit.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_MENU);
    }
}