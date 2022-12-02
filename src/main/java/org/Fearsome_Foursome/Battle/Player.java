package org.Fearsome_Foursome.Battle;/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2022
 * Instructor: Pro. Brian King
 * Group: Fearsome Foursome
 * Date: 11/8/22
 * Time: 2:47 PM
 *
 * Project: csci205_final_project
 * Class: Battle.Player
 * Description:
 *
 * Responsible for creating and managing the team.
 *
 ****************************************
 */

import org.Fearsome_Foursome.Creatures.*;

import java.util.Arrays;
import java.util.HashSet;


public class Player {

    /**
     * An ArrayList of Creatures
     */
    private Creature[] creatureArray = new Creature[6];

    /**
     * Keeps track of how many of the {@link Player}'s {@link Creature}s are dead
     */
    private int deadCount = 0;


    /**
     * Creates a team of random Pokemon
     */
    public Player(){
        // Create an Array of all possible Pokemon
        Creature[] creatureOptions = {new FireCreature(0), new FireCreature(1), new WaterCreature(0),
                                      new WaterCreature(1), new GrassCreature(0), new GrassCreature(1),
                                      new NormalCreature(0), new NormalCreature(1)};
        // Create a HashSet of the indices of Pokemon have already been chosen
        HashSet<Integer> picked = new HashSet<>();

        int randIndex;
        int currentCreatureArrayIndex = 0;

        // While the array of the player's Pokemon still has an empty slot, obtain a random Pokemon's index
        // and add it to the player's team but do not allow repeats
        while (Arrays.asList(creatureArray).contains(null)) {
            randIndex = (int) (Math.random() * 8);
            if (!picked.contains(randIndex)) {
                picked.add(randIndex);
                creatureArray[currentCreatureArrayIndex] = creatureOptions[randIndex];
                currentCreatureArrayIndex++;
            }
        }
    }

    /** Allows use to get a poke creature at array*/
    public Creature getPokeCreature(int i){
        Creature potentialCreature = creatureArray[i];

//        // don't want to return a dead creature
//        if (potentialCreature.isDead()) {
//            return null;
//        }

        // the creature is alive - that's fine
        return potentialCreature;
    }
    // TODO: added this method commented out some of getPokeCreature method to fix an issue when setting up combatants
    public boolean potentialCreatureIsDead(int i) {
        Creature potentialCreature = creatureArray[i];
        return potentialCreature.isDead();
    }

    /** Allows incrementation of the number of dead {@link Creature}s */
    public void incrementDead(){
        deadCount++;
    }

    /** Getter for the amount of recorded dead {@link Creature}s */
    public int getDeadCount() { return deadCount; }

    public Creature[] getCreatureArray() {
        return creatureArray;
    }
}
   