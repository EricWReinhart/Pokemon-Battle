/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Team: Fearsome Foursome
 * Section: 02
 * Date: 11/4/22
 * Time: 11:43 AM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Creatures
 * Class: Creature
 *
 * Description:
 *
 * *****************************************/

package org.Fearsome_Foursome.Creatures;

import java.util.HashMap;

/**
 * An abstract class which has attributes and methods shared by all different types of creatures
 */
public abstract class Creature {

    /** We need a map of functional interfaces denoting 4 moves to a certain {@link Creature} class */
    private static final HashMap<Class, Move> CREATURE_MOVE_MAP = new HashMap<>();

    /** The current health of the Creature */
    private int health = 1000;

    /**
     * Simple method to damange a {@link Creature} by a certain amount
     * @param amount
     */
    public void damage(int amount){
        health -= amount;
    }

    /**
     * This constructor is mainly initializing the CREATURE_MOVE_MAP
     */
    protected Creature() {
        CREATURE_MOVE_MAP.put(FireCreature.class, Moves.Tackle);

    }

}