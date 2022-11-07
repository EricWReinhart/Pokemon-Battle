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
import org.Fearsome_Foursome.Creatures.FireCreature;
import org.Fearsome_Foursome.Creatures.WaterCreature;

/**
 * This class just has a bunch of static inner classes defined, each of which implement the Move interface.
 * Any move in our game is defined HERE
 */
public class Moves {
    // TODO: reformat moves either by type or by Strong / Weak / Support (change Tackle to 100% accuracy, Weak move)

    // start with the Tackle move, which is an ATTACK move
    // before defining each move, set up relevant constants
    public static final double TACKLE_ACCURACY = 1.0;
    public static final int TACKLE_DAMAGE = 100;
    public static final Move Tackle = (Creature self, Creature target) -> {
        if (Math.random() < TACKLE_ACCURACY)
            target.damage(TACKLE_DAMAGE);
    };

    // now let us implement Agility for an example of a SUPPORT move instead of an attack move
    public static final int AGILITY_INCREASE = 50;
    public static final Move Agility = (Creature self, Creature target) -> {
        self.increaseSpeed(AGILITY_INCREASE);
    };

    // SUPPORT move
    public static final int RECOVER_INCREASE = 50;
    public static final Move Recover = (Creature self, Creature target) -> {
        self.increaseHealth(RECOVER_INCREASE);
    };

    // Strong Water ATTACK move
    public static final double SURF_ACCURACY = 0.8;
    public static final int SURF_DAMAGE = 150;
    public static final Move Surf = (Creature self, Creature target) -> {
        if (Math.random() < SURF_ACCURACY)
            target.damage(SURF_DAMAGE);
    };

    // Strong Grass ATTACK move
    public static final double LEAFBLADE_ACCURACY = 0.8;
    public static final int LEAFBLADE_DAMAGE = 150;
    public static final Move LeafBlade = (Creature self, Creature target) -> {
        if (Math.random() < LEAFBLADE_ACCURACY)
            target.damage(LEAFBLADE_DAMAGE);
    };

    // Strong Fire ATTACK move
    public static final double FLAMETHROWER_ACCURACY = 0.8;
    public static final int FLAMETHROWER_DAMAGE = 150;
    public static final Move Flamethrower = (Creature self, Creature target) -> {
        if (Math.random() < FLAMETHROWER_ACCURACY)
            target.damage(FLAMETHROWER_DAMAGE);
    };

    // Strong Normal ATTACK move
    public static final double HYPERBEAM_ACCURACY = 0.8;
    public static final int HYPERBEAM_DAMAGE = 150;
    public static final Move Hyperbeam = (Creature self, Creature target) -> {
        if (Math.random() < HYPERBEAM_ACCURACY)
            target.damage(HYPERBEAM_DAMAGE);
    };

    // Weak Water ATTACK move
    public static final double WATERGUN_ACCURACY = 1.0;
    public static final int WATERGUN_DAMAGE = 100;
    public static final Move Watergun = (Creature self, Creature target) -> {
        if (Math.random() < WATERGUN_ACCURACY) {
            if (target.getClass().equals(FireCreature.class)){
                target.damage(2*WATERGUN_DAMAGE);
            } else if (target.getClass().equals(WaterCreature.class)){
                target.damage((int)0.5*WATERGUN_DAMAGE);
            } else{
                target.damage(WATERGUN_DAMAGE);
            }
        }
    };

    // Weak Grass ATTACK move
    public static final double VINEWHIP_ACCURACY = 1.0;
    public static final int VINEWHIP_DAMAGE = 100;
    public static final Move Vinewhip = (Creature self, Creature target) -> {
        if (Math.random() < VINEWHIP_ACCURACY)
            target.damage(VINEWHIP_DAMAGE);
    };

    // Weak Fire ATTACK move
    public static final double EMBER_ACCURACY = 1.0;
    public static final int EMBER_DAMAGE = 100;
    public static final Move Ember = (Creature self, Creature target) -> {
        if (Math.random() < EMBER_ACCURACY)
            target.damage(EMBER_DAMAGE);
    };

}