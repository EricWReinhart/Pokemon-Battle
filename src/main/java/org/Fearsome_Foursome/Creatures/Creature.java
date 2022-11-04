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

public abstract class Creature {

    private int health = 1000;

    public void damage(int amount){
        health -= amount;
    }

}