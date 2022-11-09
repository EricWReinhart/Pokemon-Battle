/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Group: Fearsome Foursome
 * Section: 02
 * Date: 11/7/22
 * Time: 1:32 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Moves
 * Class: StrongMove
 *
 * Description: Implementation of the StrongMove
 *
 * *****************************************/

package org.Fearsome_Foursome.Moves;

import org.Fearsome_Foursome.Creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class AttackMove implements Move{

    /** Probability that this attack will hit */
    private final double accuracy;

    /** Damage that this attack will inflict on a hit */
    private final int damage;

    /** Determination of whether this is a string or weak attack */
    private final AttackType type;

    /** Class which takes double damage from this move */
    private final Class strongAgainst;

    /** List of classes which take half damage from this move */
    private final List<Class> weakAgainstList;

    /**
     * Constructor for {@link AttackMove} class, which just initializes all the attributes
     * @param strongAgainst
     * @param weakAgainst
     */
    protected AttackMove(AttackType type, Class strongAgainst, List weakAgainst){
        this.type = type;
        this.accuracy = type.getAccuracy();
        this.damage = type.getDamage();
        this.strongAgainst = strongAgainst;
        this.weakAgainstList = weakAgainst;
    }

    /**
     * Override for the required 'actOn' method which will do something to the creatures involved
     * @param self
     * @param target
     */
    @Override
    public void actOn(Creature self, Creature target) {
        if (Math.random() < accuracy) {
            if (target.getClass().equals(strongAgainst)){
                // target takes double damage
                target.damage(2*damage);
            } else if (weakAgainstList != null && weakAgainstList.contains(target.getClass())){
                // target takes half damage
                target.damage((int)(0.5*damage));
            } else{
                // target takes normal damage
                target.damage(damage);
            }
        }
    }

    /**
     * Simple getter for the accuracy
     * @return double
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * Simple getter for the damage
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Simple method to determine if a certain {@link Class} takes reduced damage from this {@link Move}
     * @param className {@link Class}
     * @return boolean
     */
    public boolean isWeakAgainst(Class className){
        if (this.weakAgainstList == null)
            return false;
        return this.weakAgainstList.contains(className);
    }

    /**
     * Simple method to determine if a certain {@link Class} takes extra damage from this {@link Move}
     * @param className
     * @return boolean
     */
    public boolean isStrongAgainst(Class className){
        if (this.strongAgainst == null)
            return false;
        return this.strongAgainst.equals(className);
    }
}