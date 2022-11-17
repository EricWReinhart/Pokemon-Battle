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
import org.Fearsome_Foursome.Battle.Arena;
import org.Fearsome_Foursome.Battle.Player;
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

    private Arena arena;
    private Player player;
    private Player enemy;
    private Creature playerCreatureUpFront;
    private Creature enemyCreatureUpFront;

    /**
     * Constructor for Arena Controller that creates references to the player and the enemy, their respective Pokemon
     * up front, and set the 2 Pokemon up for battle
     * @param gameModel the game model
     */
    public ArenaController(GameModel gameModel) {
        arena = gameModel.getArena();
        player = gameModel.getPlayer();
        enemy = gameModel.getEnemy();

        // Reference to player & enemy Pokemon up front for the first turn
        playerCreatureUpFront = player.getCreatureArray()[0];
        enemyCreatureUpFront = enemy.getCreatureArray()[0];

        // Set up combatants for battle
        // TODO: changed setupcombatants to public instead of private
        arena.getArena().setUpCombatants(0,0);
    }

    /**
     * Set up the 2 current Pokemon up front by displaying their associated name, health, sprite, and moves
     */
    public void setUpPokemon() {
        // Reference to the current 2 Pokemon up front
        // TODO: make sure that whenever pokemon are swapped out, the Arena object updates the correct
            // TODO: Pokemon before this is called:
        playerCreatureUpFront = arena.getPlayerCreatureUpFront();
        enemyCreatureUpFront = arena.getEnemyCreatureUpFront();

        // Display the correct name, sprite, and health of both the player's and the enemy's Pokemon
//        setUpNameSpriteHealth();

        // Display the correct moves of the player's Pokemon
        setUpMoves();
    }


    public void setUpNameSpriteHealth() {

    }

    /**
     * Set up the move name, color, and description
     */
    public void setUpMoves() {
        // TODO: add tooltips for each move
        moveButton1.setText(playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(0).getName());
        moveButton1.setStyle("-fx-background-color: " + playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(0).getColor());

        moveButton2.setText(playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(1).getName());
        moveButton2.setStyle("-fx-background-color: " + playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(1).getColor());

        moveButton3.setText(playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(2).getName());
        moveButton3.setStyle("-fx-background-color: " + playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(2).getColor());

        moveButton4.setText(playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(3).getName());
        moveButton4.setStyle("-fx-background-color: " + playerCreatureUpFront.getCREATURE_MOVE_MAP().get(Creature.class).get(3).getColor());
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