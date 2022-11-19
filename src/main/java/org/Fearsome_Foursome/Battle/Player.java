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

import org.Fearsome_Foursome.Creatures.Creature;
import org.Fearsome_Foursome.Creatures.FireCreature;
import org.Fearsome_Foursome.Creatures.GrassCreature;
import org.Fearsome_Foursome.Creatures.WaterCreature;


public class Player {

    /**
     * An ArrayList of Creatures
     */
    private Creature[] creatureArray = new Creature[6];

    /**
     * Keeps track of how many of of the {@link Player}'s {@link Creature}s are dead
     */
    private int deadCount = 0;

    /**
     * Creates a team
     */
    public Player(){
        //Creating a Fire creature for team
        creatureArray[0] = new FireCreature(0);
        creatureArray[1] = new FireCreature(1);

        //Creating a water Creature for team
        creatureArray[2] = new WaterCreature(0);
        creatureArray[3] = new WaterCreature(1);

        //Creating a water Creature for team
        creatureArray[4] = new GrassCreature(0);
        creatureArray[5] = new GrassCreature(1);
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
   