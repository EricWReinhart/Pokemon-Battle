/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Team: Fearsome Foursome
 * Section: 02
 * Date: 11/4/22
 * Time: 12:48 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Creatures
 * Class: FireCreature
 *
 * Description:
 *
 * *****************************************/

package org.Fearsome_Foursome.Moves;

import org.Fearsome_Foursome.Creatures.Creature;

/**
 * A functional interface that takes in a target {@link Creature} and does something to it
 */
public interface Move {

    /**
     *  Method that must be implemented by anything that implements the Move interface
     *  Will the action help oneself or hurt another? We cannot be sure so provide both arguments
     *  */
    public void actOn(Creature self, Creature target);

}