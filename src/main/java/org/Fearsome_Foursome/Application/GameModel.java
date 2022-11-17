/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Group: Fearsome Foursome
 * Section: 02
 * Date: 11/17/22
 * Time: 2:02 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Application
 * Class: GameModel
 *
 * Description: The Model needed by our game, ONE instance of which will be accessible to all controllers
 *
 * *****************************************/

package org.Fearsome_Foursome.Application;

import org.Fearsome_Foursome.Battle.Arena;
import org.Fearsome_Foursome.Creatures.Creature;

public class GameModel {

    /** Access to the battling Arena */
    private Arena arena;

    /**
     * Initialize the Arena with 2 players and their respective teams of Pokemon
     */
    public GameModel() {
        arena = new Arena();
    }

    public Creature getPlayerCreatureUpFront() {
        return arena.getPlayerCreatureUpFront();
    }

    public Creature getEnemyCreatureUpFront() {
        return arena.getEnemyCreatureUpFront();
    }


}