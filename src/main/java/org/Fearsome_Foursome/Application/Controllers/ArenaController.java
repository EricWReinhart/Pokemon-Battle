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

    /**
     * Set up the 2 current Pokemon up front by displaying their associated name, health, sprite, and moves
     */
    public void setUpPokemon(GameModel gameModel, int playerTeamidx, int enemyTeamidx) {
        // Reference to player & enemy Pokemon up front for the first turn
        Creature playerCreatureUpFront = gameModel.getPlayer().getCreatureArray()[playerTeamidx];
        Creature enemyCreatureUpFront = gameModel.getEnemy().getCreatureArray()[enemyTeamidx];

        // Set up combatants for battle
        gameModel.getArena().getArena().setUpCombatants(playerTeamidx, enemyTeamidx);

        // TODO: may not need all of that ^^ think through the logic first

        // Reference to the current 2 Pokemon up front
        // TODO: make sure that whenever pokemon are swapped out, the Arena object updates the correct
            // TODO: Pokemon before this is called:
    //        playerCreatureUpFront = arena.getPlayerCreatureUpFront();
    //        enemyCreatureUpFront = arena.getEnemyCreatureUpFront();

        // Display the correct name, sprite, and health of both the player's and the enemy's Pokemon
//        setUpNameSpriteHealth();

        // Display the correct moves of the player's Pokemon
        setUpMoves(playerCreatureUpFront);
    }


    public void setUpNameSpriteHealth() {
    }

    /**
     * Set up the name, color, and description for each of the 4 moves of that Pokemon
     */
    public void setUpMoves(Creature playerCreatureUpFront) {
        // TODO: add tooltips for each move
        moveButton1.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(0).getName());
        moveButton1.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(0).getColor());

        moveButton2.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(1).getName());
        moveButton2.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(1).getColor());

        moveButton3.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(2).getName());
        moveButton3.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(2).getColor());

        moveButton4.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(3).getName());
        moveButton4.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(3).getColor());
    }


    /**
     * Switch to the Pokemon Selection screen and set up the current Pokemon on the arena
     * @param mouseEvent
     */
    public void switchToSelection(MouseEvent mouseEvent) {
        Stage stage = (Stage)swapPokemonButton.getScene().getWindow();
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