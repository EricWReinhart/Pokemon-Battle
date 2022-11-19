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
    private ProgressBar playerHealthProgressBar;

    @FXML
    private Button swapPokemonButton;

    void initialize() {
        assert enemyHealthProgressBar != null : "fx:id=\"enemyHealthProgressBar\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton1 != null : "fx:id=\"moveButton1\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton2 != null : "fx:id=\"moveButton2\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton3 != null : "fx:id=\"moveButton3\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton4 != null : "fx:id=\"moveButton4\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert playerHealthProgressBar != null : "fx:id=\"selfHealthProgressBar1\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert swapPokemonButton != null : "fx:id=\"swapPokemonButton\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'pokemonArena.fxml'.";

    }

    /**
     * Set up the 2 current Pokemon up front by displaying their associated name, health, sprite, and moves
     */
    public void setUpPokemon(GameModel gameModel, int playerTeamidx, int enemyTeamidx) {
        // Set up combatants for battle by setting the targets
        gameModel.getArena().getArena().setUpCombatants(playerTeamidx, enemyTeamidx);

        // Store a reference to the player & enemy Pokemon up front
        Creature playerCreatureUpFront = gameModel.getPlayerCreatureUpFront();
        Creature enemyCreatureUpFront = gameModel.getEnemyCreatureUpFront();

        // Display the correct name, sprite, and health of both the player's and the enemy's Pokemon
        setUpNameSpriteHealth(playerCreatureUpFront, enemyCreatureUpFront);

        // Display the correct moves of the player's Pokemon
        setUpMoves(playerCreatureUpFront);
    }

    /**
     * Set up the name, sprite, and health bar of the current Pokemon in the Arena
     * @param playerCreatureUpFront player's current Pokemon
     * @param enemyCreatureUpFront enemy's current Pokemon
     */
    public void setUpNameSpriteHealth(Creature playerCreatureUpFront, Creature enemyCreatureUpFront) {
        // Set up the name for both Pokemon
        // TODO: double check methods to use
        // playerName.setText(playerCreatureUpFront.
        // enemyName.setText(enemyCreatureUpFront.

        // Set up the sprite for both Pokemon
        // TODO: how to access sprite object on the scene itself


        // Adjust the numerical display of health for both Pokemon (example: 500/500)
        // TODO: this

        // Adjust the progress bar to the remaining health for both Pokemon
        // TODO: test code for progress bar colors
//            playerCreatureUpFront.damage(250); // half health: yellow
//            playerCreatureUpFront.damage(200); // health bar < 33%: red
        playerHealthProgressBar.setProgress(1.0 * playerCreatureUpFront.getHealth() / playerCreatureUpFront.getMaxHealth());
        enemyHealthProgressBar.setProgress(1.0 * playerCreatureUpFront.getHealth() / playerCreatureUpFront.getMaxHealth());

        // Change the color of the progress bar depending on the percent health remaining for both Pokemon
        progressBarColor(playerHealthProgressBar);
        progressBarColor(enemyHealthProgressBar);
    }

    /**
     * Changes the color of the progress bar depending on the percent health remaining.
     * Green: health > 67%, Yellow: 33% < health < 67%, Red: health < 33%
     * @param progressBar player or enemy progress bar
     */
    public void progressBarColor(ProgressBar progressBar) {
        if (progressBar.getProgress() > 0.67) {
            progressBar.setStyle("-fx-accent: " + "green");
        }
        else if (progressBar.getProgress() > 0.33 && progressBar.getProgress() < 0.67) {
            progressBar.setStyle("-fx-accent: " + "yellow");
        }
        else if (progressBar.getProgress() < 0.33) {
            progressBar.setStyle("-fx-accent: " + "red");
        }
    }

    /**
     * Set up the name, color, and description for each of the 4 moves of that Pokemon
     */
    public void setUpMoves(Creature playerCreatureUpFront) {
        // TODO: add tooltips for each move
        // Set up the text and color of each move
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