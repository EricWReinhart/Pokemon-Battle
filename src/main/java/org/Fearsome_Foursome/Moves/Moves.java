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

import javafx.scene.paint.Color;
import org.Fearsome_Foursome.Creatures.FireCreature;
import org.Fearsome_Foursome.Creatures.GrassCreature;
import org.Fearsome_Foursome.Creatures.WaterCreature;

import java.util.Arrays;

/**
 * This class just has a bunch of static inner classes defined, each of which implement the Move interface.
 * Any move in our game is defined HERE
 */
public class Moves {

    // SUPPORT move Agility to raise user's speed
    public static final Move Agility = new SupportMove(SupportType.Speeding, "AGILITY", "Raise user's speed by 50 points", Color.ORANGE);

    // SUPPORT move Recover to heal the user
    public static final Move Recover = new SupportMove(SupportType.Healing, "RECOVER", "Restore user's health by 150 points", Color.GREEN);

    // Strong Normal ATTACK move Hyperbeam
    public static final Move Hyperbeam = new AttackMove(AttackType.Strong, null, null,
                                                    "HYPERBEAM", "Type: Normal\nDamage: 150\nAccuracy: 80", Color.YELLOW);

    // Strong Water ATTACK move Surf
    public static final Move Surf = new AttackMove(AttackType.Strong, FireCreature.class,
                                                Arrays.asList(GrassCreature.class, WaterCreature.class),
                                            "SURF", "Type: Water\nDamage: 150\nAccuracy: 80", Color.AQUAMARINE);

    // Strong Grass ATTACK move LeafBlade
    public static final Move LeafBlade = new AttackMove(AttackType.Strong, WaterCreature.class,
                                                Arrays.asList(FireCreature.class, GrassCreature.class),
                                                    "LEAFBLADE", "Type: Grass\nDamage: 150\nAccuracy: 80", Color.GREENYELLOW);

    // Strong Fire ATTACK move Flamethrower
    public static final Move Flamethrower = new AttackMove(AttackType.Strong, GrassCreature.class,
                                                Arrays.asList(WaterCreature.class, FireCreature.class),
                                                    "FLAMETHROWER", "Type: Fire\nDamage: 150\nAccuracy: 80", Color.RED);

    // Weak Normal ATTACK move Tackle
    public static final Move Tackle = new AttackMove(AttackType.Weak, null, null,
                                                "Type: Normal\nDamage: 100\nAccuracy: 100", "TACKLE", Color.YELLOW);

    // Weak Water ATTACK move Watergun
    public static final Move Watergun = new AttackMove(AttackType.Weak, FireCreature.class,
                                                Arrays.asList(GrassCreature.class, WaterCreature.class),
                                                "Type: Water\nDamage: 100\nAccuracy: 100", "WATERGUN", Color.AQUAMARINE);

    // Weak Grass ATTACK move Vinewhip
    public static final Move Vinewhip = new AttackMove(AttackType.Weak, WaterCreature.class,
                                                Arrays.asList(FireCreature.class, GrassCreature.class),
                                                "Type: Grass\nDamage: 100\nAccuracy: 100", "VINEWHIP", Color.YELLOWGREEN);

    // Weak Fire ATTACK move Ember
    public static final Move Ember = new AttackMove(AttackType.Weak, GrassCreature.class,
                                               Arrays.asList(WaterCreature.class, FireCreature.class),
                                                "Type: Fire\nDamage: 100\nAccuracy: 100", "EMBER", Color.RED);

}