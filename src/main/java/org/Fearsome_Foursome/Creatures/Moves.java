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

package org.Fearsome_Foursome.Creatures;

/**
 * This class just has a bunch of static inner classes defined, each of which implement the Move interface.
 * Any move in our game is defined HERE
 */
public class Moves {

    // before defining each move, set up some relevant constants
    private static final double tackleAccuracy = 0.8;
    public static final Move Tackle = (Creature target) -> {
                                            if (Math.random() < tackleAccuracy)
                                                target.damage(100);
                                        };

}