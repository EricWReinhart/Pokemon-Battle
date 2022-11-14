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
    /** The player you control */
    private Player player;
    /** An AI enemy*/
    private Player enemy;
    /** Current Creature in play for player */
    private Creature playerCreatureUpFront;
    /** Current Enemy Creature in play */
    private Creature enemyCreatureUpFront;
    /** Whether the combat is over or not */
    private boolean combatOver = false;

    /** Initializes the players*/
    public Arena(){
        this.player = new Player();
        this.enemy = new Player();

    }

    /**
     * Method that sets up the combatants. It takes in an index to select a Creature to place
     * into battle. It sets up the target to the opposite Pokemon as well.
     *
     * @param playerTeamIdx an index of a Pokemon to choose
     * @param enemyTeamIdx an index for the enemy to choose
     * @return true or false depending on if the Pokemon is alive or dead
     */
    private boolean setUpCombatants(int playerTeamIdx, int enemyTeamIdx){
        // setting up the current Pokémon at a specific index making sure the creature is alive
        if(!(this.player.getPokeCreature(playerTeamIdx).equals(null))){
            this.playerCreatureUpFront = this.player.getPokeCreature(playerTeamIdx);

            // setting the targets
            this.playerCreatureUpFront.setTarget(this.enemyCreatureUpFront);
            this.enemyCreatureUpFront.setTarget(this.playerCreatureUpFront);
        }

        // do the same for enemy creature
        if(!(this.enemy.getPokeCreature(enemyTeamIdx).equals(null))){
            this.enemyCreatureUpFront = this.enemy.getPokeCreature(enemyTeamIdx);

            // setting the targets
            this.enemyCreatureUpFront.setTarget(this.playerCreatureUpFront);
            this.playerCreatureUpFront.setTarget(this.enemyCreatureUpFront);
        }

        // if either Pokemon is dead, return false
        else{
            return false;
        }

        // If both creatures that you are trying to select are alive
       return true;

    }

    /**
     * A method that checks the speed of each Creature and has them move successive.
     * If either team is dead combat over becomes true.
     * @param playerMove A move picked by the user
     * @param enemyMove A move picked randomly
     */
    private void turn(int playerMove, int enemyMove){
        // checking the speed to see who moves first
        if (playerCreatureUpFront.getSpeed() > enemyCreatureUpFront.getSpeed()){
            // player moves first
            playerCreatureUpFront.move(playerMove);

            // if the enemy is not dead after the player's attack then the enemy can move
            if(!(enemyCreatureUpFront.isDead())){
                enemyCreatureUpFront.move(enemyMove);
            }
            else{
                // the enemy's Pokemon is dead so increment amount of dead Pokemon by 1
                this.enemy.incrementDead();
            }

        }
        else{
            // enemy creature can move first
            enemyCreatureUpFront.move(enemyMove);

            // if the player is not dead after the enemy's attack then the enemy can move
            if(!(playerCreatureUpFront.isDead())){
                playerCreatureUpFront.move(enemyMove);
            }
            else{
                // the player's Pokemon is dead so increment amount of dead Pokemon by 1
                this.player.incrementDead();
            }

        }
        // Check if either team is dead, if so combatOver is true
        if(this.player.getDeadCount() == 6 || this.enemy.getDeadCount() == 6 )
            combatOver = true;
    }

    /**
     * Allows controller to bring up two Pokemon and pit them against each other.
     * @param playerCreatureIndex Index for a Pokemon chosen by user
     * @param enemyCreatureIndex Index for a Pokemon randomly chosen
     * @param playerMoveIndex Move for a Pokemon chosen by user
     * @param enemyMoveIndex Move for a Pokemon randomly chosen
     */
    public void playRound(int playerCreatureIndex, int enemyCreatureIndex, int playerMoveIndex, int enemyMoveIndex){
        if(combatOver){
            throw new IllegalStateException();
        }
        else{
           // sets up combatants and if true you can call turn
            if(setUpCombatants(playerCreatureIndex,enemyCreatureIndex)){
                turn(playerMoveIndex,enemyMoveIndex);
            }
        }
    }

}
   