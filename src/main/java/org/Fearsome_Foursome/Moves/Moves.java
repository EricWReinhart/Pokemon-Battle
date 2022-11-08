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

import java.util.Arrays;
import java.util.List;

/**
 * This class just has a bunch of static inner classes defined, each of which implement the Move interface.
 * Any move in our game is defined HERE
 */
public class Moves {
    // Set up damage and accuracy for strong and weak moves
    public static final double STRONG_ACCURACY = 0.8;
    public static final int STRONG_DAMAGE = 150;
    public static final double WEAK_ACCURACY = 1.0;
    public static final int WEAK_DAMAGE = 100;

    // SUPPORT move Agility to raise user's speed
    public static final int AGILITY_INCREASE = 50;
    public static final Move Agility = new SupportMove(CreatureAttribute.Speed, AGILITY_INCREASE);

    // SUPPORT move Recover to heal the user
    public static final int RECOVER_INCREASE = 50;
    public static final Move Recover = new SupportMove(CreatureAttribute.Health, RECOVER_INCREASE);

    // Strong Normal ATTACK move Hyperbeam
    public static final Move Hyperbeam = new AttackMove(STRONG_ACCURACY, STRONG_DAMAGE, null, null);

    // Strong Water ATTACK move Surf
    public static final Move Surf = new AttackMove(STRONG_ACCURACY, STRONG_DAMAGE, FireCreature.class,
                                                Arrays.asList(GrassCreature.class, WaterCreature.class));

    // Strong Grass ATTACK move LeafBlade
    public static final Move LeafBlade = new AttackMove(STRONG_ACCURACY, STRONG_DAMAGE, WaterCreature.class,
                                                Arrays.asList(FireCreature.class, GrassCreature.class));

    // Strong Fire ATTACK move Flamethrower
    public static final Move Flamethrower = new AttackMove(STRONG_ACCURACY, STRONG_DAMAGE, GrassCreature.class,
                                                Arrays.asList(WaterCreature.class, FireCreature.class));

    // Weak Normal ATTACK move Tackle
    public static final Move Tackle = new AttackMove(WEAK_ACCURACY, WEAK_DAMAGE, null, null);

    // Weak Water ATTACK move Watergun
    public static final Move Watergun = new AttackMove(WEAK_ACCURACY, WEAK_DAMAGE, FireCreature.class,
                                                Arrays.asList(GrassCreature.class, WaterCreature.class));

    // Weak Grass ATTACK move Vinewhip
    public static final Move Vinewhip = new AttackMove(WEAK_ACCURACY, WEAK_DAMAGE, WaterCreature.class,
                                                Arrays.asList(FireCreature.class, GrassCreature.class));

    // Weak Fire ATTACK move Ember
    public static final Move Ember = new AttackMove(WEAK_ACCURACY, WEAK_DAMAGE, GrassCreature.class,
                                               Arrays.asList(WaterCreature.class, FireCreature.class));

}