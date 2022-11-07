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

import org.Fearsome_Foursome.Creatures.Creature;

public class SupportMove implements Move {

    /** What attribute will this Move modify? */
    private final CreatureAttribute attributeToChange;

    /** What bonus will this Move give to the relevant attribute? */
    private final int bonus;

    /**
     * Constructor for the {@link SupportMove} class, which initializes attributeToChange and bonus
     * @param attribute
     * @param bonus
     */
    public SupportMove(CreatureAttribute attribute, int bonus){
        this.attributeToChange = attribute;
        this.bonus = bonus;
    }

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
}