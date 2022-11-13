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
     * A method that checks the speed of each Creature and has them move succesively.
     * If either team is dead combat over becomes true.
     * @param playerMove A move picked by the user
     * @param enemyMove A move picked randomly
     */
    private void turn(int playerMove, int enemyMove){

        //checking the speed to see who moves first
        if (playerCreatureUpFront.getSpeed() > enemyCreatureUpFront.getSpeed()){
            //player moves first
            playerCreatureUpFront.move(playerMove);

            // If not dead after hit they can move
            if(!(enemyCreatureUpFront.isDead())){
                enemyCreatureUpFront.move(enemyMove);
            }
            else{
                //they are dead make sure to increment amount of dead pokemon
                this.enemy.incrementDead();
            }

        }
        else{
            //enemy creature can move first
            enemyCreatureUpFront.move(enemyMove);

            //if the creature is not dead it can move
            if(!(playerCreatureUpFront.isDead())){
                playerCreatureUpFront.move(enemyMove);
            }
            else{
                this.player.incrementDead();
            }

        }
        //Checking to if either team is dead, if so combat over is true
        if( this.player.getDeadCount() == 6 || this.enemy.getDeadCount() == 6 )
            combatOver = true;
    }

    /**
     * Allows controller to bring up two pokemon and pit them against each other.
     * @param playerCreatureIndex Index for a pokemon chosen by user
     * @param enemyCreatureIndex Index for a pokemon randomly chosen
     * @param playerMoveIndex Move for a pokemon chosen by user
     * @param enemyMoveIndex Move for a pokemon randomly chosen
     */
    public void playRound(int playerCreatureIndex, int enemyCreatureIndex, int playerMoveIndex, int enemyMoveIndex){
        if(combatOver){
            throw new IllegalStateException();
        }
        else{
           //sets up combatants and if true you can call turn
            if(setUpCombatants(playerCreatureIndex,enemyCreatureIndex)){
                turn(playerMoveIndex,enemyMoveIndex);
            }
        }
    }

}
   