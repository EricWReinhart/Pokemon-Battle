/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Group: Fearsome Foursome
 * Section: 02
 * Date: 11/7/22
 * Time: 1:33 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Moves
 * Class: SupportMove
 *
 * Description: Implementation of a SupportMove
 *
 * *****************************************/

package org.Fearsome_Foursome.Moves;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.Fearsome_Foursome.Application.HelloPokemon;
import org.Fearsome_Foursome.Creatures.Creature;

import java.io.File;
import java.io.IOException;

public class SupportMove implements Move {

    /** What attribute will this Move modify? */
    private final CreatureAttribute attributeToChange;

    /** What bonus will this Move give to the relevant attribute? */
    private final int bonus;

    /** Name corresponding to this {@link Move} */
    private final String name;

    /** Description corresponding to this {@link Move} */
    private final String description;

    /** {@link String} corresponding to this {@link Move} */
    private final String color;

    /** Action done by the move such as healing or increasing speed */
    private String moveAction;

    /** The address which contains the .png sprite animation for said {@link SupportMove} */
    private final String imagePath;

    /**
     * Constructor for the {@link SupportMove} class, which initializes attributeToChange and bonus
     * @param type {@link SupportType}
     * @param name {@link String}
     */
    public SupportMove(SupportType type, String name, String description, String color){
        this.attributeToChange = type.getAttributeToModify();
        this.bonus = type.getAmountToIncrease();
        this.name = name;
        this.description = description;
        this.color = color;
        this.imagePath = "src/main/resources/Sprites/" + name + ".png";
    }

    /**
     * Overridden method to return the name of this {@link SupportMove}
     * @return {@link String}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Override for the required 'getDescription' method which will return the corresponding description of this {@link SupportMove}
     * @return {@link String}
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Overridden method to return the {@link String} of this {@link SupportMove}
     * @return {@link String}
     */
    @Override
    public String getColor() { return color; }

    /**
     * What does this move DO to all parties involved?
     * @param self {@link Creature}
     * @param target {@link Creature}
     */
    @Override
    public String actOn(Creature self, Creature target) {
        // simply increase the relevant attribute of self
        switch (attributeToChange) {
            case Health:
                self.increaseHealth(bonus);
                moveAction = "\nRecovered " + SupportType.Healing.amountToIncrease + " health!";
                break;
            case MaxHealth:
                self.increaseMaxHealth(bonus);
                break;
            case Speed:
                self.increaseSpeed(bonus);
                moveAction = "\nIncreased speed by " + SupportType.Speeding.amountToIncrease + "!";
                break;
        }
        // depending on the attacking Creature, this affects which animation we are using
        if (self == HelloPokemon.globalModel.getArena().playerCreatureUpFront){
            this.showAnimation(HelloPokemon.arenaController.supportMovePlayer, HelloPokemon.arenaController.playerSprite);
        } else if (self == HelloPokemon.globalModel.getArena().enemyCreatureUpFront){
            this.showAnimation(HelloPokemon.arenaController.supportMoveEnemy, HelloPokemon.arenaController.enemySprite);
        }
        return moveAction;
    }

    /**
     * Testing version of this method
     * @param self - {@link Creature}
     * @param target - {@link Creature}
     */
    @Override
    public void actOnNoAnimation(Creature self, Creature target) {
        switch (attributeToChange) {
            case Health:
                self.increaseHealth(bonus);
                break;
            case MaxHealth:
                self.increaseMaxHealth(bonus);
                break;
            case Speed:
                self.increaseSpeed(bonus);
                break;
        }
    }

    /**
     * Simple getter for the attribute which is changed
     * @return {@link CreatureAttribute}
     */
    public CreatureAttribute getAttributeToChange() {
        return attributeToChange;
    }

    /**
     * Simple getter for the bonus amount
     * @return int
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * Method to show the animation for said {@link SupportMove}
     */
    @Override
    public void showAnimation(ImageView moveImage, ImageView creatureImage) {
        // just make the supporting move visible for a certain amount of time
        try {
            File fileForMoveSprite = new File(this.imagePath);
            moveImage.setImage(new Image(fileForMoveSprite.toURI().toURL().toExternalForm()));
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(moveImage.visibleProperty(), true)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(moveImage.visibleProperty(), false))
            );
            timeline.play();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}