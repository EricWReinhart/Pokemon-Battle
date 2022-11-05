/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Team: Fearsome Foursome
 * Section: 02
 * Date: 11/4/22
 * Time: 1:15 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Creatures
 * Class: Moves
 *
 * Description: A class which contains all the different Move Implementations we will have in the game
 *
 * *****************************************/

package org.Fearsome_Foursome.Moves;

import org.Fearsome_Foursome.Creatures.Creature;

/**
 * This class just has a bunch of static inner classes defined, each of which implement the Move interface.
 * Any move in our game is defined HERE
 */
public class Moves {

    // start with the Tackle move, which is an ATTACK move
    // before defining each move, set up relevant constants
    public static final double TACKLE_ACCURACY = 0.8;
    public static final int TACKLE_DAMAGE = 100;
    public static final Move Tackle = (Creature self, Creature target) -> {
                                            if (Math.random() < TACKLE_ACCURACY)
                                                target.damage(TACKLE_DAMAGE);
                                        };

    // now let us implement Agility for an example of a SUPPORT move instead of an attack move
    public static final int AGILITY_INCREASE = 10;
    public static final Move Agility = (Creature self, Creature target) -> {
                                            self.increaseSpeed(AGILITY_INCREASE);
                                        };

}