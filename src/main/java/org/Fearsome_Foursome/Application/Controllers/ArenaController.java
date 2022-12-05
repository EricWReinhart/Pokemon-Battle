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
import org.Fearsome_Foursome.Battle.Arena;
import org.Fearsome_Foursome.Creatures.Creature;
import java.util.Random;

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

    void initialize() {
        assert enemyHealthProgressBar != null : "fx:id=\"enemyHealthProgressBar\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton1 != null : "fx:id=\"moveButton1\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton2 != null : "fx:id=\"moveButton2\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton3 != null : "fx:id=\"moveButton3\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert moveButton4 != null : "fx:id=\"moveButton4\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert playerHealthProgressBar != null : "fx:id=\"selfHealthProgressBar1\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert swapPokemonButton != null : "fx:id=\"swapPokemonButton\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert playerName != null : "fx:id=\"playerName\" was not injected: no injectable field found in FXML Controller class for the id 'playerName'";
        assert enemyName != null : "fx:id=\"playerName\" was not injected: no injectable field found in FXML Controller class for the id 'playerName'";
        assert battleTextLog != null : "fx:id=\"battleTextLog\" was not injected: check your FXML file 'pokemonArena.fxml'.";    }

    /** The active Arena */
    private Arena arena;
    /** Player's Pokémon currently in battle */
    private Creature playerCreatureUpFront;
    /** Enemy's Pokémon currently in battle */
    private Creature enemyCreatureUpFront;
    /** Index of the player's current Pokémon in the Arena */
    private int playerTeamIndex;
    /** Index of the enemy's current Pokémon in the Arena */
    private int enemyTeamIndex;
    /** Did a player creature just die? */
    public static boolean justDied = false;
    /** Text that explains what is happening in the battle */
    private String battleText = "";
    /** Index of the most recently fainted Pokémon belonging to the user */
    private static int previousDeadUserPokemonIndex;

    /**
     * Set up the 2 current Pokémon up front by displaying their associated name, health, sprite, and moves
     */
    public boolean setUpPokemon(int playerTeamIdx, int enemyTeamIdx) {
        // Store reference to the Arena itself
        arena = HelloPokemon.globalModel.getArena();

        // we need to make the Move images hidden
        enemyTackleSprite.setVisible(false);
        playerTackleSprite.setVisible(false);
        attackMoveEnemy.setVisible(false);
        attackMovePlayer.setVisible(false);
        supportMoveEnemy.setVisible(false);
        supportMovePlayer.setVisible(false);

        if (!arena.setUpCombatants(playerTeamIdx, enemyTeamIdx)){
            // SOMEBODY'S DEAD, and the way we have this set up is such that this could only happen if the user selects a dead Pokémon
            return false;
        }

        // Store a reference to the player & enemy Pokémon up front and their indices in each team
        playerCreatureUpFront = HelloPokemon.globalModel.getPlayerCreatureUpFront();
        enemyCreatureUpFront = HelloPokemon.globalModel.getEnemyCreatureUpFront();
        playerTeamIndex = playerTeamIdx;
        enemyTeamIndex = enemyTeamIdx;

        // Display the correct name, sprite, and health of both the player's and the enemy's Pokémon
        setUpNameSpriteHealth(playerCreatureUpFront, enemyCreatureUpFront);

        // Display the correct moves of the player's Pokémon
        setUpMoves(playerCreatureUpFront);

        // we were successful in setting up the Pokémon
        return true;
    }

    /**
     * Set up the name, sprite, and health bar of the current Pokémon in the Arena
     * @param playerCreatureUpFront player's current Pokémon
     * @param enemyCreatureUpFront enemy's current Pokémon
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
     * @param mouseEvent {@link MouseEvent}
     * @param playerMoveIndex index of the move that the player selects
     */
    public void playARound(MouseEvent mouseEvent, int playerMoveIndex) {
        // Generate a random move slot for the enemy to use
        Random rand = new Random();
        int enemyRandomMoveIndex = rand.nextInt(4);

        // Play a round by having both Pokémon on the Arena use a move and show text of what happens
        battleTextLog.setText(arena.playRound(playerTeamIndex, enemyTeamIndex, playerMoveIndex, enemyRandomMoveIndex));

        // Check if at least 1 Pokémon in the Arena is dead
        if (playerCreatureUpFront.isDead()) {
            // player died
            if (arena.isCombatOver()) {
                // player must have lost
                this.loadLoserScreen();
            } else {
                // player did not lose but must change Pokémon
                justDied = true;
                previousDeadUserPokemonIndex = playerTeamIndex;
                this.switchToSelection(mouseEvent);
            }
        } else if (enemyCreatureUpFront.isDead()){
            // then the enemy died
            if (arena.isCombatOver()) {
                // player must have won
                this.loadWinnerScreen();
            } else {
                // enemy randomly switches Pokémon
                battleText = "The opponent's " + enemyCreatureUpFront.getName() + " fainted!";
                arena.setUpCombatants(arena.getPlayerUpFrontIndex(), arena.getRandomNotDeadFromEnemy());
                enemyCreatureUpFront = arena.getEnemyCreatureUpFront();
                battleText += "\nThe opponent sent out " + enemyCreatureUpFront.getName() + "!";
                // explain what happens in the battle log to the user
                battleTextLog.setText(battleText);
            }
        }

        // At the end of each turn, set up the health bar of the Pokémon again
        setUpNameSpriteHealth(playerCreatureUpFront, enemyCreatureUpFront);
    }

    /**
     * Method to load the winner screen
     */
    private void loadWinnerScreen() {
        Stage stage = (Stage)btnQuit.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.WINNER_SCREEN);
    }

    /**
     * Method to load the loser screen
     */
    private void loadLoserScreen() {
        Stage stage = (Stage)btnQuit.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.LOSER_SCREEN);
    }

    /**
     * User chooses Move 1 or 2 or 3 or 4
     * @param mouseEvent {@link MouseEvent}
     */
    public void chooseMoveOne(MouseEvent mouseEvent) { playARound(mouseEvent, 0); }
    public void chooseMoveTwo(MouseEvent mouseEvent) { playARound(mouseEvent, 1); }
    public void chooseMoveThree(MouseEvent mouseEvent) { playARound(mouseEvent, 2); }
    public void chooseMoveFour(MouseEvent mouseEvent) { playARound(mouseEvent, 3); }

    /**
     * Switch to the Pokémon Selection screen and set up the current Pokémon on the arena
     * @param mouseEvent {@link MouseEvent}
     */
    public void switchToSelection(MouseEvent mouseEvent) {
        Stage stage = (Stage)swapPokemonButton.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_SELECTION);
        HelloPokemon.selectionController.showPokemon();
    }

    /**
     * Return to home screen
     * @param mouseEvent {@link MouseEvent}
     */
    public void goHome(MouseEvent mouseEvent) {
        Stage stage = (Stage)btnQuit.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_MENU);
    }

    /**
     * Return the index of the player's Pokémon randomly, such that they are not dead
     * @return int
     */
    public int getRandomNotDeadPlayer() {
        return arena.getRandomNotDeadFromPlayer();
    }

    /**
     * Return the index of the enemy {@link Creature} who is currently up to bat
     * @return int
     */
    public int getEnemyUpFrontIndex() {
        return enemyTeamIndex;
    }

    /**
     * Set the battle log for the very start of the battle
     */
    public void setInitialBattleTextLog() {
        battleText = "You sent out " + playerCreatureUpFront.getName() + "!\nThe opponent sent out "+ enemyCreatureUpFront.getName() + "!";
        battleTextLog.setText(battleText);
    }

    /**
     * If either Pokémon in the Arena faints or is swapped out, then display an appropriate message
     * in the battle log
     */
    public void setPokemonSwapBattleLog() {
        // If the user's Pokémon just died, tell the user which Pokémon died and which Pokémon is being swapped in
        if (justDied) {
            battleText = "Your " + arena.getPlayer().getPokeCreature(previousDeadUserPokemonIndex).getName() + " fainted!\nYou sent out " + playerCreatureUpFront.getName() + "!";
            justDied = false;
        } else {
            // User's Pokémon is not dead but the user is swapping to a different Pokémon
            battleText = "You sent out " + playerCreatureUpFront.getName() + "!";
        }
        // Update the battle log with the correct message
        battleTextLog.setText(battleText);
    }
}