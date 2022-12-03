/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Group: Fearsome Foursome
 * Section: 02
 * Date: 11/7/22
 * Time: 1:32 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Moves
 * Class: StrongMove
 *
 * Description: Implementation of the StrongMove
 *
 * *****************************************/

package org.Fearsome_Foursome.Moves;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.Fearsome_Foursome.Application.HelloPokemon;
import org.Fearsome_Foursome.Creatures.Creature;

import java.util.List;

public class AttackMove implements Move{

    /** Probability that this attack will hit */
    private final double accuracy;

    /** Damage that this attack will inflict on a hit */
    private final int damage;

    /** Determination of whether this is a string or weak attack */
    private final AttackType type;

    /** Class which takes double damage from this move */
    private final Class strongAgainst;

    /** List of classes which take half damage from this move */
    private final List<Class> weakAgainstList;

    /** Name of this {@link AttackMove} */
    private final String name;

    /** Description corresponding to this {@link Move} */
    private final String description;

    /** Color associated with this move */
    private final String color;

    /** The address which contains the .png sprite animation for said {@link SupportMove} */
    private final String imagePath;

    /**
     * Constructor for {@link AttackMove} class, which just initializes all the attributes
     * @param strongAgainst {@link Class}
     * @param weakAgainst {@link List}
     * @param name {@link String}
     */
    protected AttackMove(AttackType type, Class strongAgainst, List weakAgainst, String name, String description, String color){
        this.type = type;
        this.accuracy = type.getAccuracy();
        this.damage = type.getDamage();
        this.strongAgainst = strongAgainst;
        this.weakAgainstList = weakAgainst;
        this.name = name;
        this.description = description;
        this.color = color;
        this.imagePath = "Sprites/Moves/" + name + ".png";
    }

    /**
     * Override for the required 'getName' method which will return the corresponding name of this {@link AttackMove}
     * @return {@link String}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Override for the required 'getDescription' method which will return the corresponding description of this {@link AttackMove}
     * @return {@link String}
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Override for the required 'getColor' method which will return the corresponding color of this {@link AttackMove}
     * @return {@link String}
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * Override for the required 'actOn' method which will do something to the creatures involved
     * @param self
     * @param target
     */
    @Override
    public String actOn(Creature self, Creature target) {
        if (Math.random() <= accuracy) {
            if (target.getClass().equals(strongAgainst)){
                // target takes double damage
                target.damage(2*damage);
                return "\nIt's super effective!";
            } else if (weakAgainstList != null && weakAgainstList.contains(target.getClass())){
                // target takes half damage
                target.damage((int)(0.5*damage));
                return "\nIt's not very effective...";
            } else{
                // target takes normal damage
                target.damage(damage);
                return "";
            }
        }
        else {
            return "\nIt missed!";
        }
    }

    /**
     * Simple getter for the accuracy
     * @return double
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * Simple getter for the damage
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Simple method to determine if a certain {@link Class} takes reduced damage from this {@link Move}
     * @param className {@link Class}
     * @return boolean
     */
    public boolean isWeakAgainst(Class className){
        if (this.weakAgainstList == null)
            return false;
        return this.weakAgainstList.contains(className);
    }

    /**
     * Simple method to determine if a certain {@link Class} takes extra damage from this {@link Move}
     * @param className
     * @return boolean
     */
    public boolean isStrongAgainst(Class className){
        if (this.strongAgainst == null)
            return false;
        return this.strongAgainst.equals(className);
    }

    /**
     * Method to show this {@link AttackMove}'s animation
     * @param image - the {@link ImageView} which will portray this moves Sprite
     */
    @Override
    public void showAnimation(ImageView image) {
        // first make the image visible
        image.setImage(new Image(this.imagePath));
        image.setVisible(true);

        // needs to move and scale
        TranslateTransition translation = new TranslateTransition();
        ScaleTransition scale = new ScaleTransition();
        translation.setNode(image);
        translation.setDuration(Duration.millis(500));
        scale.setNode(image);
        scale.setDuration(Duration.millis(500));
        if (image == HelloPokemon.arenaController.attackMovePlayer){
            // player is attacking
            translation.setByX(250);
            translation.setByX(-20);
            scale.setToX(0.75);
            scale.setToY(0.75);
        } else if (image == HelloPokemon.arenaController.attackMoveEnemy) {
            // enemy is attacking
            translation.setByX(-250);
            translation.setByX(20);
            scale.setToX(1.0 + 1.0/3.0);
            scale.setToY(1.0 + 1.0/3.0);
        }
        translation.play();
        scale.play();

        image.setVisible(false);

    }
}