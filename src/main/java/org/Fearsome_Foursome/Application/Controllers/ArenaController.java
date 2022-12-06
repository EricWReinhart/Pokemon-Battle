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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.HelloPokemon;
import org.Fearsome_Foursome.Creatures.Creature;

public class ArenaController {

    @FXML
    public ImageView attackMoveEnemy;

    @FXML
    public ImageView attackMovePlayer;

    @FXML
    public ImageView supportMoveEnemy;

    @FXML
    public ImageView supportMovePlayer;

    @FXML
    public ImageView enemyTackleSprite;

    @FXML
    public ImageView playerTackleSprite;

    @FXML
    public ImageView playerSprite;

    @FXML
    public ImageView enemySprite;

    @FXML
    private TextField playerName;

    @FXML
    private TextField enemyName;

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
    private ProgressBar enemyHealthProgressBar;

    @FXML
    private TextArea battleTextLog;

    @FXML
    private Button swapPokemonButton;

    @FXML
    void initialize() {
        assert attackMoveEnemy != null : "fx:id=\"attackMoveEnemy\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert attackMovePlayer != null : "fx:id=\"attackMovePlayer\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert battleTextLog != null : "fx:id=\"battleTextLog\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert enemyHealthProgressBar != null : "fx:id=\"enemyHealthProgressBar\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert enemyName != null : "fx:id=\"enemyName\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert enemySprite != null : "fx:id=\"enemySprite\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert enemyTackleSprite != null : "fx:id=\"enemyTackleSprite\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton1 != null : "fx:id=\"moveButton1\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton2 != null : "fx:id=\"moveButton2\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton3 != null : "fx:id=\"moveButton3\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton4 != null : "fx:id=\"moveButton4\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert playerHealthProgressBar != null : "fx:id=\"playerHealthProgressBar\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert playerName != null : "fx:id=\"playerName\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert playerSprite != null : "fx:id=\"playerSprite\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert playerTackleSprite != null : "fx:id=\"playerTackleSprite\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert supportMoveEnemy != null : "fx:id=\"supportMoveEnemy\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert supportMovePlayer != null : "fx:id=\"supportMovePlayer\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert swapPokemonButton != null : "fx:id=\"swapPokemonButton\" was not injected: check your FXML file 'pokemonArena.fxml'.";
    }

    /**
     * Did a player creature just die?
     */
    public static boolean justDied = false;

    /**
     * Text that explains what is happening in the battle
     */
    private String battleText = "";

    /**
     * Index of the most recently fainted Pokémon belonging to the user
     */
    private static int previousDeadUserPokemonIndex;

    /**
     * Is the user playing against a smart opponent or a random opponent?
     */
    public static boolean hardMode = false;

    /**
     * Set up the 2 current Pokémon up front by displaying their associated name, health, sprite, and moves
     */
    public boolean setUpPokemon(int playerTeamIdx, int enemyTeamIdx) {
        // we need to make the Move images hidden
        enemyTackleSprite.setVisible(false);
        playerTackleSprite.setVisible(false);
        attackMoveEnemy.setVisible(false);
        attackMovePlayer.setVisible(false);
        supportMoveEnemy.setVisible(false);
        supportMovePlayer.setVisible(false);

        if (!HelloPokemon.globalModel.getArena().setUpCombatants(playerTeamIdx, enemyTeamIdx)) {
            // SOMEBODY'S DEAD, and the way we have this set up is such that this could only happen if the user selects a dead Pokémon
            return false;
        }

        // Display the correct name, sprite, and health of both the player's and the enemy's Pokémon
        setUpNameSpriteHealth(HelloPokemon.globalModel.getArena().playerCreatureUpFront,HelloPokemon.globalModel.getArena().enemyCreatureUpFront);

        // Display the correct moves of the player's Pokémon
        setUpMoves(HelloPokemon.globalModel.getArena().playerCreatureUpFront);

        // we were successful in setting up the Pokémon
        return true;
    }

    /**
     * Set up the name, sprite, and health bar of the current Pokémon in the Arena
     *
     * @param playerCreatureUpFront player's current Pokémon
     * @param enemyCreatureUpFront  enemy's current Pokémon
     */
    public void setUpNameSpriteHealth(Creature playerCreatureUpFront, Creature enemyCreatureUpFront) {
        // Display the name for both Pokémon
        playerName.setText(playerCreatureUpFront.getName());
        enemyName.setText(enemyCreatureUpFront.getName());
        playerName.setEditable(false);
        enemyName.setEditable(false);

        // Display the sprite for both Pokémon
        playerSprite.setImage(new Image("Sprites/" + Creature.CREATURE_SPRITE_MAP.get(playerCreatureUpFront.getName())[0]));
        enemySprite.setImage(new Image("Sprites/" + Creature.CREATURE_SPRITE_MAP.get(enemyCreatureUpFront.getName())[1]));

        // Adjust the progress bar to the remaining health for both Pokémon
        playerHealthProgressBar.setProgress(1.0 * playerCreatureUpFront.getHealth() / playerCreatureUpFront.getMaxHealth());
        enemyHealthProgressBar.setProgress(1.0 * enemyCreatureUpFront.getHealth() / enemyCreatureUpFront.getMaxHealth());

        // Change the color of the progress bar depending on the percent health remaining for both Pokémon
        HelloPokemon.progressBarColor(playerHealthProgressBar);
        HelloPokemon.progressBarColor(enemyHealthProgressBar);
    }

    /**
     * Set up the name, color, and tooltip description for each of the 4 moves of the player's Pokémon
     */
    public void setUpMoves(Creature playerCreatureUpFront) {
        // Set the text, color, and tooltip with a description of each move
        moveButton1.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(0).getName());
        moveButton1.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(0).getColor());
        Tooltip moveTooltip1 = new Tooltip(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(0).getDescription());
        moveButton1.setTooltip(moveTooltip1);

        moveButton2.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(1).getName());
        moveButton2.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(1).getColor());
        Tooltip moveTooltip2 = new Tooltip(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(1).getDescription());
        moveButton2.setTooltip(moveTooltip2);

        moveButton3.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(2).getName());
        moveButton3.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(2).getColor());
        Tooltip moveTooltip3 = new Tooltip(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(2).getDescription());
        moveButton3.setTooltip(moveTooltip3);

        moveButton4.setText(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(3).getName());
        moveButton4.setStyle("-fx-background-color: " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(3).getColor());
        Tooltip moveTooltip4 = new Tooltip(Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(3).getDescription());
        moveButton4.setTooltip(moveTooltip4);
    }

    /**
     * When a move is clicked, a round is started. Both Pokémon up front target each other and attack in order of
     * speed. The player's Pokémon uses the selected move and the enemy's Pokémon uses a random move.
     *
     * @param mouseEvent      {@link MouseEvent}
     * @param playerMoveIndex index of the move that the player selects
     */
    public void playARound(MouseEvent mouseEvent, int playerMoveIndex) {
        if (playerMoveIndex >= 0) {
            // Play a round, which is an exchange of two Moves, led by the Player
            battleTextLog.setText(HelloPokemon.globalModel.getArena().playRound(playerMoveIndex));

            // Check if at least 1 Pokémon in the Arena is dead
            if (HelloPokemon.globalModel.getArena().playerCreatureUpFront.isDead()) {
                // player died
                handlePlayerCreatureDeath(mouseEvent);
            } else if (HelloPokemon.globalModel.getArena().enemyCreatureUpFront.isDead()) {
                // then the enemy died
                handleEnemyCreatureDeath();
            }
        } else {
            // the player just switched Pokémon
            if (!justDied &&HelloPokemon.globalModel.getArena().enemyCreatureUpFront.getSpeed() >=HelloPokemon.globalModel.getArena().playerCreatureUpFront.getSpeed()) {
                battleTextLog.setText(HelloPokemon.globalModel.getArena().makeEnemyAttack());
                if (HelloPokemon.globalModel.getArena().playerCreatureUpFront.isDead()) {
                    this.handlePlayerCreatureDeath(mouseEvent);
                }
            } else {
                // if the Pokémon was switched by the player because one of their Pokémon DIED, the enemy does not get to attack regardless of their speed
                justDied = false;
            }
        }

        // At the end of each turn, set up the health bar of the Pokémon again
        setUpNameSpriteHealth(HelloPokemon.globalModel.getArena().playerCreatureUpFront,HelloPokemon.globalModel.getArena().enemyCreatureUpFront);
    }

    /**
     * How should the controller respond when an enemy {@link Creature} dies?
     */
    private void handleEnemyCreatureDeath(){
        if (HelloPokemon.globalModel.getArena().isCombatOver()) {
            // player must have won
            this.loadWinnerScreen();
        } else {
            // enemy randomly switches Pokémon
            battleText = "The opponent's " + HelloPokemon.globalModel.getArena().enemyCreatureUpFront.getName() + " fainted!";
            HelloPokemon.globalModel.getArena().setUpCombatants(HelloPokemon.globalModel.getArena().getPlayerUpFrontIndex(),HelloPokemon.globalModel.getArena().getRandomNotDeadFromEnemy());
            battleText += "\nThe opponent sent out " + HelloPokemon.globalModel.getArena().enemyCreatureUpFront.getName() + "!";
            // explain what happens in the battle log to the user
            battleTextLog.setText(battleText);
        }
    }

    /**
     * What should the {@link ArenaController} do when a player {@link Creature} dies?
     * @param mouseEvent - necessary for switching scenes
     */
    private void handlePlayerCreatureDeath(MouseEvent mouseEvent) {
        if (HelloPokemon.globalModel.getArena().isCombatOver()) {
            // player must have lost
            this.loadLoserScreen();
        } else {
            // player did not lose but must change Pokémon
            justDied = true;
            previousDeadUserPokemonIndex = HelloPokemon.globalModel.getArena().getPlayerUpFrontIndex();
            this.switchToSelection(mouseEvent);
        }
    }

    /**
     * Method to load the winner screen
     */
    private void loadWinnerScreen() {
        Stage stage = (Stage) btnQuit.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.WINNER_SCREEN);
    }

    /**
     * Method to load the loser screen
     */
    private void loadLoserScreen() {
        Stage stage = (Stage) btnQuit.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.LOSER_SCREEN);
    }

    /**
     * User chooses Move 1 or 2 or 3 or 4
     *
     * @param mouseEvent {@link MouseEvent}
     */
    public void chooseMoveOne(MouseEvent mouseEvent) {
        playARound(mouseEvent, 0);
    }

    public void chooseMoveTwo(MouseEvent mouseEvent) {
        playARound(mouseEvent, 1);
    }

    public void chooseMoveThree(MouseEvent mouseEvent) {
        playARound(mouseEvent, 2);
    }

    public void chooseMoveFour(MouseEvent mouseEvent) {
        playARound(mouseEvent, 3);
    }

    /**
     * Switch to the Pokémon Selection screen and set up the current Pokémon on theHelloPokemon.globalModel.getArena()
     *
     * @param mouseEvent {@link MouseEvent}
     */
    public void switchToSelection(MouseEvent mouseEvent) {
        Stage stage = (Stage) swapPokemonButton.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_SELECTION);
        HelloPokemon.selectionController.showPokemon();
    }

    /**
     * Return to home screen
     *
     * @param mouseEvent {@link MouseEvent}
     */
    public void goHome(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnQuit.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_MENU);
    }

    /**
     * Set the battle log for the very start of the battle
     */
    public void setInitialBattleTextLog() {
        battleText = "You sent out " +HelloPokemon.globalModel.getArena().playerCreatureUpFront.getName() + "!\nThe opponent sent out " +HelloPokemon.globalModel.getArena().enemyCreatureUpFront.getName() + "!";
        battleTextLog.setText(battleText);
    }

    /**
     * If either Pokémon in the Arena faints or is swapped out, then display an appropriate message
     * in the battle log
     */
    public void setPokemonSwapBattleLog() {
        // If the user's Pokémon just died, tell the user which Pokémon died and which Pokémon is being swapped in
        if (justDied) {
            battleText = "Your " + HelloPokemon.globalModel.getArena().getPlayer().getPokeCreature(previousDeadUserPokemonIndex).getName() + " fainted!\nYou sent out " +HelloPokemon.globalModel.getArena().playerCreatureUpFront.getName() + "!";
        } else {
            // User's Pokémon is not dead but the user is swapping to a different Pokémon
            battleText = "You sent out " + HelloPokemon.globalModel.getArena().playerCreatureUpFront.getName() + "!";
        }
        // Update the battle log with the correct message
        battleTextLog.setText(battleText);
    }
}