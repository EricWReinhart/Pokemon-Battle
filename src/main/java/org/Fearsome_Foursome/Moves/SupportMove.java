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

import javafx.scene.paint.Color;
import org.Fearsome_Foursome.Creatures.Creature;

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
     * @param self
     * @param target
     */
    @Override
    public void actOn(Creature self, Creature target) {
        // simply increase the relevant attribute of self
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
}