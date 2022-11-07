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
import org.Fearsome_Foursome.Creatures.GrassCreature;
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
    // not strong or weak against anything
    public static final Move Tackle = new AttackMove(TACKLE_ACCURACY, TACKLE_DAMAGE, null, null);

    // now let us implement Agility for an example of a SUPPORT move instead of an attack move
    public static final int AGILITY_INCREASE = 50;
    public static final Move Agility = new SupportMove(CreatureAttribute.Speed, AGILITY_INCREASE);

    // SUPPORT move
    public static final int RECOVER_INCREASE = 50;
    public static final Move Recover = new SupportMove(CreatureAttribute.Health, RECOVER_INCREASE);

    // Strong Water ATTACK move
    public static final double SURF_ACCURACY = 0.8;
    public static final int SURF_DAMAGE = 150;
    public static final Move Surf = new AttackMove(SURF_ACCURACY, SURF_DAMAGE, FireCreature.class, WaterCreature.class);

    // Strong Grass ATTACK move
    public static final double LEAFBLADE_ACCURACY = 0.8;
    public static final int LEAFBLADE_DAMAGE = 150;
    // Strong against???
    public static final Move LeafBlade = new AttackMove(LEAFBLADE_ACCURACY, LEAFBLADE_DAMAGE, null, GrassCreature.class);

    // Strong Fire ATTACK move
    public static final double FLAMETHROWER_ACCURACY = 0.8;
    public static final int FLAMETHROWER_DAMAGE = 150;
    public static final Move Flamethrower = new AttackMove(FLAMETHROWER_ACCURACY, FLAMETHROWER_DAMAGE, WaterCreature.class, FireCreature.class);

    // Strong Normal ATTACK move
    public static final double HYPERBEAM_ACCURACY = 0.8;
    public static final int HYPERBEAM_DAMAGE = 150;
    // not weak or strong against anything in particular (ERIC FEEL FREE TO CHANGE THAT - just wanted to demonstrate how that could be implemented)
    public static final Move Hyperbeam = new AttackMove(HYPERBEAM_ACCURACY, HYPERBEAM_DAMAGE, null, null);

    // Weak Water ATTACK move
    public static final double WATERGUN_ACCURACY = 1.0;
    public static final int WATERGUN_DAMAGE = 100;
    public static final Move Watergun = new AttackMove(WATERGUN_ACCURACY, WATERGUN_DAMAGE, FireCreature.class, WaterCreature.class);

    // Weak Grass ATTACK move
    public static final double VINEWHIP_ACCURACY = 1.0;
    public static final int VINEWHIP_DAMAGE = 100;
    public static final Move Vinewhip = new AttackMove(VINEWHIP_ACCURACY, VINEWHIP_DAMAGE, null, GrassCreature.class);

    // Weak Fire ATTACK move
    public static final double EMBER_ACCURACY = 1.0;
    public static final int EMBER_DAMAGE = 100;
    public static final Move Ember = new AttackMove(EMBER_ACCURACY, EMBER_DAMAGE, WaterCreature.class, FireCreature.class);

}