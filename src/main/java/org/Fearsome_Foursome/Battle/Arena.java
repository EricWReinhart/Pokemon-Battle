/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2022
 * Instructor: Pro. Brian King
 * Name: Connor Coles
 * Date: 11/13/22
 * Time: 1:49 PM
 *
 * Project: csci205_final_project
 * Class: Arena
 * Description:
 *
 *
 ****************************************
 */
package org.Fearsome_Foursome.Battle;

import org.Fearsome_Foursome.Creatures.Creature;

public class Arena {
    /**The player you control*/
    private Player player;
    /** An AI enemy*/
    private Player enemy;

    /** Current Creature in play for player*/
    private Creature playerCreatureUpFront;

    /** Current Enemy Creature in play */

    private Creature enemyCreatureUpFront;
    /**Whether the combat is over or not*/
    private boolean combatOver = false;

    /** Initializes the players*/
    public Arena(){
        this.player = new Player();
        this.enemy = new Player();

    }

    /**
     * Method that sets up the combatants. It takes in an index to select a Creature to place
     * into battle. It sets up the target to the opposite pokemon as well.
     *
     * @param playerTeamIdx an index of a pokemon to choose
     * @param enemyTeamIdx an index for the enemy to choose
     * @return true or false depending on if the pokemon is alive or dead
     */
    private boolean setUpCombatants(int playerTeamIdx, int enemyTeamIdx){
        //setting up the current Pokémon at a specific index making sure the creature is alive
        if(!(this.player.getPokeCreature(playerTeamIdx).equals(null))){
            this.playerCreatureUpFront = this.player.getPokeCreature(playerTeamIdx);

            //setting the targets
            this.playerCreatureUpFront.setTarget(this.enemyCreatureUpFront);
            this.enemyCreatureUpFront.setTarget(this.playerCreatureUpFront);
        }
        //if dead return false
        else{
            return false;
        }

        //do the same for enemy creature
        if(!(this.enemy.getPokeCreature(enemyTeamIdx).equals(null))){
            this.enemyCreatureUpFront = this.enemy.getPokeCreature(enemyTeamIdx);

            //setting the targets
            this.enemyCreatureUpFront.setTarget(this.playerCreatureUpFront);
            this.playerCreatureUpFront.setTarget(this.enemyCreatureUpFront);
        }
        else{
            return false;
        }

        //If the both creatures that you are trying to select are alive
       return true;

    }

    /**
     *
     * @param playerMove
     * @param enemyMove
     */
    private void turn(int playerMove, int enemyMove){

        //checking the speed to see who moves first
        if (playerCreatureUpFront.getSpeed() > enemyCreatureUpFront.getSpeed()){
            playerCreatureUpFront.move(1);
            enemyCreatureUpFront.move(1);
        }
        else{
            enemyCreatureUpFront.move(1);
            playerCreatureUpFront.move(1);
        }
    }



}
   