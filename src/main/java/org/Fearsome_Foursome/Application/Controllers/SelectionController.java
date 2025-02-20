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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Fearsome_Foursome.Application.HelloPokemon;
import org.Fearsome_Foursome.Creatures.Creature;

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
    private Button btnSelect1;

    @FXML
    private Button btnSelect2;

    @FXML
    private Button btnSelect3;

    @FXML
    private Button btnSelect4;

    @FXML
    private Button btnSelect5;

    @FXML
    private Button btnSelect6;

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
        assert btnSelect1 != null : "fx:id=\"checkBox1\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert btnSelect2 != null : "fx:id=\"checkBox2\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert btnSelect3 != null : "fx:id=\"checkBox3\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert btnSelect4 != null : "fx:id=\"checkBox4\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert btnSelect5 != null : "fx:id=\"checkBox5\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
        assert btnSelect6 != null : "fx:id=\"checkBox6\" was not injected: check your FXML file 'pokemonSelection.fxml'.";
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
     * Method to switch back to the arena
     * @param mouseEvent
     */
    public void switchToArena(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage) background.getScene().getWindow();
        HelloPokemon.loadScene(stage, HelloPokemon.GameScenes.POKEMON_ARENA);
        HelloPokemon.arenaController.setUpPokemon(HelloPokemon.globalModel.getArena().getPlayerUpFrontIndex(), HelloPokemon.globalModel.getArena().getEnemyUpFrontIndex());
    }

    /**
     * Called when the Cancel button is pressed
     * @param mouseEvent
     */
    public void switchIfAllowed(MouseEvent mouseEvent) {
        if (!ArenaController.justDied){
            this.switchToArena(mouseEvent);
        }
    }

    /**
     * Sets the {@link org.Fearsome_Foursome.Creatures.Creature} up front for the player to be the first {@link org.Fearsome_Foursome.Creatures.Creature}, if that {@link org.Fearsome_Foursome.Creatures.Creature} is alive
     * @param mouseEvent
     */
    public void pick1(MouseEvent mouseEvent) {
        pickCreature(1, mouseEvent);
    }

    /**
     * Self-explanatory what this method should do
     * @param mouseEvent
     */
    public void pick2(MouseEvent mouseEvent) {
        pickCreature(2, mouseEvent);
    }

    /**
     * Self-explanatory what this method should do
     * @param mouseEvent
     */
    public void pick3(MouseEvent mouseEvent) {
        pickCreature(3, mouseEvent);
    }

    /**
     * Self-explanatory what this method should do
     * @param mouseEvent
     */
    public void pick4(MouseEvent mouseEvent) {
        pickCreature(4, mouseEvent);
    }

    /**
     * Self-explanatory what this method should do
     * @param mouseEvent
     */
    public void pick5(MouseEvent mouseEvent) {
        pickCreature(5, mouseEvent);
    }

    /**
     * Self-explanatory what this method should do
     * @param mouseEvent
     */
    public void pick6(MouseEvent mouseEvent) {
        pickCreature(6, mouseEvent);
    }

    /**
     * Load up a certain creature
     * @param creatureNumber
     * @param mouseEvent
     */
    private void pickCreature(int creatureNumber, MouseEvent mouseEvent) {
        int playerIndex = creatureNumber - 1;
        Creature newCreature = HelloPokemon.globalModel.getArena().getPlayer().getPokeCreature(playerIndex);
        if (newCreature != HelloPokemon.globalModel.getArena().getPlayerCreatureUpFront() && HelloPokemon.arenaController.setUpPokemon(playerIndex, HelloPokemon.globalModel.getArena().getEnemyUpFrontIndex())){
            // they did not try to pick a dead Pokémon or the one that they already had
            this.switchToArena(mouseEvent);
            HelloPokemon.arenaController.setUpNameSpriteHealth(HelloPokemon.globalModel.getPlayerCreatureUpFront(), HelloPokemon.globalModel.getEnemyCreatureUpFront());
            HelloPokemon.arenaController.setPokemonSwapBattleLog();
            if (!ArenaController.justDied) {
                // the enemy needs to move now
                HelloPokemon.arenaController.playARound(mouseEvent, -1);
            } else {
                // MAYBE the enemy needs to move now if their speed is great enough - simulates starting a new round
                ArenaController.justDied = false;
                HelloPokemon.arenaController.playARound(mouseEvent, -2);
            }
        }
    }

    /**
     * Method to show the correct Pokémon for the given team
     */
    public void showPokemon() {
        try {
            File fileForSprite1 = new File("src/main/resources/Sprites/" + Creature.CREATURE_SPRITE_MAP.get(HelloPokemon.globalModel.getPlayer().getCreatureArray()[0].getName())[1]);
            sprite1.setImage(new Image(fileForSprite1.toURI().toURL().toExternalForm()));

            File fileForSprite2 = new File("src/main/resources/Sprites/" + Creature.CREATURE_SPRITE_MAP.get(HelloPokemon.globalModel.getPlayer().getCreatureArray()[1].getName())[1]);
            sprite2.setImage(new Image(fileForSprite2.toURI().toURL().toExternalForm()));

            File fileForSprite3 = new File("src/main/resources/Sprites/" + Creature.CREATURE_SPRITE_MAP.get(HelloPokemon.globalModel.getPlayer().getCreatureArray()[2].getName())[1]);
            sprite3.setImage(new Image(fileForSprite3.toURI().toURL().toExternalForm()));

            File fileForSprite4 = new File("src/main/resources/Sprites/" + Creature.CREATURE_SPRITE_MAP.get(HelloPokemon.globalModel.getPlayer().getCreatureArray()[3].getName())[1]);
            sprite4.setImage(new Image(fileForSprite4.toURI().toURL().toExternalForm()));

            File fileForSprite5 = new File("src/main/resources/Sprites/" + Creature.CREATURE_SPRITE_MAP.get(HelloPokemon.globalModel.getPlayer().getCreatureArray()[4].getName())[1]);
            sprite5.setImage(new Image(fileForSprite5.toURI().toURL().toExternalForm()));

            File fileForSprite6 = new File("src/main/resources/Sprites/" + Creature.CREATURE_SPRITE_MAP.get(HelloPokemon.globalModel.getPlayer().getCreatureArray()[5].getName())[1]);
            sprite6.setImage(new Image(fileForSprite6.toURI().toURL().toExternalForm()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.showProgressBars();
    }

    /**
     * Method to show the health of each of the Pokémon available for the player to select
     */
    public void showProgressBars() {
        // get a hold of all the different creatures
        Creature creature1 = HelloPokemon.globalModel.getPlayer().getPokeCreature(0);
        Creature creature2 = HelloPokemon.globalModel.getPlayer().getPokeCreature(1);
        Creature creature3 = HelloPokemon.globalModel.getPlayer().getPokeCreature(2);
        Creature creature4 = HelloPokemon.globalModel.getPlayer().getPokeCreature(3);
        Creature creature5 = HelloPokemon.globalModel.getPlayer().getPokeCreature(4);
        Creature creature6 = HelloPokemon.globalModel.getPlayer().getPokeCreature(5);

        // Adjust the progress bar to the remaining health for both Pokémon
        currentHealth1.setProgress(1.0 * creature1.getHealth() / creature1.getMaxHealth());
        HelloPokemon.progressBarColor(currentHealth1);
        currentHealth2.setProgress(1.0 * creature2.getHealth() / creature2.getMaxHealth());
        HelloPokemon.progressBarColor(currentHealth2);
        currentHealth3.setProgress(1.0 * creature3.getHealth() / creature3.getMaxHealth());
        HelloPokemon.progressBarColor(currentHealth3);
        currentHealth4.setProgress(1.0 * creature4.getHealth() / creature4.getMaxHealth());
        HelloPokemon.progressBarColor(currentHealth4);
        currentHealth5.setProgress(1.0 * creature5.getHealth() / creature5.getMaxHealth());
        HelloPokemon.progressBarColor(currentHealth5);
        currentHealth6.setProgress(1.0 * creature6.getHealth() / creature6.getMaxHealth());
        HelloPokemon.progressBarColor(currentHealth6);
    }
}

