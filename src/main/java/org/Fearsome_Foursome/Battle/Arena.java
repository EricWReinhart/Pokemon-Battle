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

import org.Fearsome_Foursome.Application.Controllers.ArenaController;
import org.Fearsome_Foursome.Application.HelloPokemon;
import org.Fearsome_Foursome.Creatures.Creature;
import org.Fearsome_Foursome.Moves.AttackMove;
import org.Fearsome_Foursome.Moves.Move;
import org.Fearsome_Foursome.Moves.SupportMove;

import java.util.*;

public class Arena {
    /** The player you control */
    private Player player;

    /** An AI enemy*/
    private Player enemy;

    /** Current Creature in play for player */
    public Creature playerCreatureUpFront;

    /** Current Enemy Creature in play */
    public Creature enemyCreatureUpFront;

    /** Whether the combat is over or not */
    private boolean combatOver = false;

    /** Corresponding indices of the two {@link Creature}s for the player who are up front to move */
    private int playerCreatureUpFrontIndex;

    /** Corresponding indices of the two {@link Creature}s for the enemy who are up front to move */
    private int enemyCreatureUpFrontIndex;

    /** Text log of each turn of the battle */
    private String battleTextLog;

    /** Initializes the players*/
    public Arena(){
        this.player = new Player();
        this.enemy = new Player();
    }

    /**
     * Method that sets up the combatants. It takes in an index to select a Creature to place
     * into battle. It sets up the target to the opposite Pokémon as well.
     *
     * @param playerTeamIdx an index of a Pokémon to choose
     * @param enemyTeamIdx an index for the enemy to choose
     * @return true or false depending on if the Pokémon is alive or dead
     */
    public boolean setUpCombatants(int playerTeamIdx, int enemyTeamIdx){
        // set up the enemy creature Pokémon
        if(!this.enemy.potentialCreatureIsDead(enemyTeamIdx)){
            this.enemyCreatureUpFront = this.enemy.getPokeCreature(enemyTeamIdx);
            this.enemyCreatureUpFrontIndex = enemyTeamIdx;
        }

        // setting up the current Pokémon at a specific index making sure the creature is alive
        if(!this.player.potentialCreatureIsDead(playerTeamIdx)){
            this.playerCreatureUpFront = this.player.getPokeCreature(playerTeamIdx);
            this.playerCreatureUpFrontIndex = playerTeamIdx;

            // setting the targets
            this.enemyCreatureUpFront.setTarget(this.playerCreatureUpFront);
            this.playerCreatureUpFront.setTarget(this.enemyCreatureUpFront);
        }
        // if the player tries to load a dead Pokémon, return false
        else{
            return false;
        }

        // If the player selected a live creature
        return true;

    }

    /**
     * A method that checks the speed of each Creature and has them move successively.
     * If either team is dead combat over becomes true.
     * @param playerMoveIndex A move picked by the user
     * @param enemyMoveIndex A move picked randomly
     */
    private String turn(int playerMoveIndex, int enemyMoveIndex){

        // checking the speed to see who moves first and return an appropriate
        if (playerCreatureUpFront.getSpeed() >= enemyCreatureUpFront.getSpeed()){
            // player moves first
            battleTextLog = "Your " + playerCreatureUpFront.getName() + " used " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(playerMoveIndex).getName() + ". ";
            battleTextLog += playerCreatureUpFront.move(playerMoveIndex);

            // if the enemy is not dead after the player's attack then the enemy can move
            if(!(enemyCreatureUpFront.isDead())){
                // should the enemy switch?
                if (this.smartToSwitchEnemy()){
                    enemyCreatureUpFront = this.bestEnemyChoice();
                    battleTextLog += "\nThe opponent sent out " + enemyCreatureUpFront.getName() + "!";
                    HelloPokemon.arenaController.setUpPokemon(playerCreatureUpFrontIndex, enemyCreatureUpFrontIndex);
                }
                battleTextLog += "\nThe opponent's " + enemyCreatureUpFront.getName() + " used " + Creature.CREATURE_MOVE_MAP.get(enemyCreatureUpFront.getClass()).get(enemyMoveIndex).getName() + ". ";
                battleTextLog += enemyCreatureUpFront.move(enemyMoveIndex);
                // great - now did the player die after the enemy moved?
                if (playerCreatureUpFront.isDead()){
                    player.incrementDead();
                }
            }
            else{
                // the enemy's Pokémon is dead so increment amount of dead Pokémon by 1
                this.enemy.incrementDead();
            }

        }
        else{
            // enemy creature can move first
            battleTextLog = "The opponent's " + enemyCreatureUpFront.getName() + " used " + Creature.CREATURE_MOVE_MAP.get(enemyCreatureUpFront.getClass()).get(enemyMoveIndex).getName() + ". ";
            battleTextLog += enemyCreatureUpFront.move(enemyMoveIndex);

            // if the player is not dead after the enemy's attack then the enemy can move
            if(!(playerCreatureUpFront.isDead())){
                battleTextLog += "\nYour " + playerCreatureUpFront.getName() + " used " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(playerMoveIndex).getName() + ". ";
                battleTextLog += playerCreatureUpFront.move(playerMoveIndex);
                // great - now did the enemy die after the player moved?
                if (enemyCreatureUpFront.isDead()){
                    this.enemy.incrementDead();
                }
            }
            else{
                // the player's Pokémon is dead so increment amount of dead Pokémon by 1
                this.player.incrementDead();
            }

        }
        // Check if either team is dead, if so combatOver is true
        if(this.player.getDeadCount() == 6 || this.enemy.getDeadCount() == 6 )
            combatOver = true;

        return battleTextLog;
    }

    /**
     * Look through the enemy's Pokémon - depending on the player's Pokémon one of them is a better choice
     * @return {@link Creature}
     */
    private Creature bestEnemyChoice() {
        // this method will only run if the enemy has Pokémon left which are alive

        Comparator<Creature> creatureComparator = (creature1, creature2) -> {
            return creature1.getHealth() - creature2.getHealth();
        };
        TreeSet<Creature> strongAgainstCreatures = new TreeSet<>(creatureComparator);
        TreeSet<Creature> allCreatures = new TreeSet<>(creatureComparator);
        HashMap<Creature, Integer> indices = new HashMap<>();

        // look through the Pokémon
        for (int i=0; i<enemy.getCreatureArray().length; i++){
            Creature creature = this.enemy.getPokeCreature(i);
            indices.put(creature, i);
            if (!creature.isDead()) {
                if (creature.hasStrongMoveAgainst(playerCreatureUpFront.getClass())) {
                    strongAgainstCreatures.add(creature);
                }
                allCreatures.add(creature);
            }
        }

        // look through the sorted Pokémon
        Creature creatureToReturn;
        if (!strongAgainstCreatures.isEmpty()){
            creatureToReturn = strongAgainstCreatures.iterator().next();
        } else {
            creatureToReturn = allCreatures.iterator().next();
        }
        enemyCreatureUpFrontIndex = indices.get(creatureToReturn);
        return creatureToReturn;
    }

    /**
     * Determine if it would be a good idea for the enemy to switch out its Pokémon up to bat
     * @return boolean
     */
    private boolean smartToSwitchEnemy() {
        if (playerCreatureUpFront.hasStrongMoveAgainst(enemyCreatureUpFront.getClass())){
            // then holy shit the enemy had better switch Pokémon
            return true;
        }
        // otherwise
        if (enemyCreatureUpFront.hasWeakMoveAgainst(playerCreatureUpFront.getClass())){
            // then the enemy does not have effective attacks against the player - worth switching for the enemy
            return true;
        }
        // else
        return false;
    }

    /**
     * Allows controller to bring up two Pokémon and pit them against each other.
     * @param playerCreatureIndex Index for a Pokémon chosen by user
     * @param enemyCreatureIndex Index for a Pokémon randomly chosen
     * @param playerMoveIndex Move for a Pokémon chosen by user
     * @param enemyMoveIndex Move for a Pokémon randomly chosen
     */
    public String playRound(int playerCreatureIndex, int enemyCreatureIndex, int playerMoveIndex, int enemyMoveIndex){
        if(combatOver){
            throw new IllegalStateException();
        }
        else{
           // sets up combatants and if true you can call turn
            if(setUpCombatants(playerCreatureIndex,enemyCreatureIndex)){
                return turn(playerMoveIndex,enemyMoveIndex);
            }
        }
        return ""; // this statement should never be hit
    }

    /** Simple getter for the player up front */
    public Player getPlayer() { return player; }

    /** Simple getter for the enemy */
    public Player getEnemy() { return enemy; }

    /** Simple getter for a certain friendly {@link Creature} */
    public Creature getPlayerCreatureUpFront() { return playerCreatureUpFront; }

    /** Simple getter for a certain enemy {@link Creature} */
    public Creature getEnemyCreatureUpFront() { return enemyCreatureUpFront; }

    /** Refresh both the Player and Enemy teams */
    public void refreshAll() {
        this.player = new Player();
        this.enemy = new Player();
        this.combatOver = false;
    }

    /**
     * Simple getter for the player's up front {@link Creature} index
     * @return int
     */
    public int getPlayerUpFrontIndex() {
        return playerCreatureUpFrontIndex;
    }

    /**
     * Simple getter for the enemy's up front {@link Creature} index
     * @return int
     */
    public int getEnemyUpFrontIndex() {
        return enemyCreatureUpFrontIndex;
    }

    /**
     * Simple getter for the value of combatOver
     * @return boolean
     */
    public boolean isCombatOver() {
        return combatOver;
    }

    /**
     * Return a random index of a Pokémon from the Enemy which is alive
     * @return int
     */
    public int getRandomNotDeadFromEnemy() {
        Creature[] creatures = enemy.getCreatureArray();
        return getAliveIndex(creatures);
    }

    /**
     * Return a random index of a Pokémon from the Player which is alive
     * @return int
     */
    public int getRandomNotDeadFromPlayer() {
        Creature[] creatures = player.getCreatureArray();
        return getAliveIndex(creatures);
    }

    /**
     * Given an array of creatures, return the index of a randomly alive one
     * @param creatures
     * @return int
     */
    private int getAliveIndex(Creature[] creatures) {
        ArrayList<Integer> alive = new ArrayList<>();
        for (int i=0; i<creatures.length; i++){
            if (!creatures[i].isDead()){
                alive.add(i);
            }
        }
        if (alive.size() == 0){
            return -1;
        } else {
            return alive.get((int)(Math.random()*alive.size()));
        }
    }
}