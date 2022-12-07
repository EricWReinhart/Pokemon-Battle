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
import org.Fearsome_Foursome.Creatures.NormalCreature;
import org.Fearsome_Foursome.Moves.AttackMove;
import org.Fearsome_Foursome.Moves.Move;
import org.Fearsome_Foursome.Moves.Moves;

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
     */
    private String turn(int playerMoveIndex){
        String battleTextLog;

        // checking the speed to see who moves first and return an appropriate
        battleTextLog = performExchangeOfAttacks(playerMoveIndex);

        // Check if either team is dead, if so combatOver is true
        if(this.player.getDeadCount() == 6 || this.enemy.getDeadCount() == 6 )
            combatOver = true;

        return battleTextLog;
    }

    /**
     * Method to record the {@link String} for the player moving first
     * @param playerMoveIndex
     * @return {@link String}
     */
    private String performExchangeOfAttacks(int playerMoveIndex) {
        String battleTextLog;
        // player moves first
        battleTextLog = "Your " + playerCreatureUpFront.getName() + " used " + Creature.CREATURE_MOVE_MAP.get(playerCreatureUpFront.getClass()).get(playerMoveIndex).getName() + ". ";
        battleTextLog += playerCreatureUpFront.move(playerMoveIndex);

        // if the enemy is not dead after the player's attack then the enemy can move
        if(!(enemyCreatureUpFront.isDead())){
            // should the enemy switch?
            String oldEnemyCreatureUpFrontName = enemyCreatureUpFront.getName();
            if (ArenaController.hardMode && this.smartToSwitchEnemy()){
                this.makeEnemyBestChoice();
                if (!oldEnemyCreatureUpFrontName.equals(enemyCreatureUpFront.getName())) {
                    // were they able to make a change?
                    battleTextLog += "\nThe opponent sent out " + enemyCreatureUpFront.getName() + "!";
                    // update the view
                    HelloPokemon.arenaController.setUpPokemon(playerCreatureUpFrontIndex, enemyCreatureUpFrontIndex);
                    // now, the new Pokémon may be allowed to attack
                    if (enemyCreatureUpFront.getSpeed() > playerCreatureUpFront.getSpeed()) {
                        // if the enemy is fast enough, they get to attack
                        battleTextLog += performEnemyAttack();
                    }
                } else {
                    // then the enemy could not make a change even though it would have been nice to - just attack
                    battleTextLog += performEnemyAttack();
                }
            } else {
                // the enemy should not switch, so just attack
                battleTextLog += performEnemyAttack();
            }
        }
        else{
            // the enemy's Pokémon is dead so increment amount of dead Pokémon by 1
            this.enemy.incrementDead();
        }
        return battleTextLog;
    }

    /**
     * Look through the enemy's Pokémon - depending on the player's Pokémon one of them is a better choice
     */
    private void makeEnemyBestChoice() {
        // this method will only run if the enemy has Pokémon left which are alive
        Comparator<Creature> creatureComparator = (creature1, creature2) -> {
            return creature2.getHealth() - creature1.getHealth();
        };
        TreeSet<Creature> strongAgainstCreatures = new TreeSet<>(creatureComparator);
        TreeSet<Creature> nonVulnerableCreatures = new TreeSet<>(creatureComparator);
        TreeSet<Creature> allCreatures = new TreeSet<>(creatureComparator);
        HashMap<Creature, Integer> indices = new HashMap<>();

        // look through the Pokémon
        for (int i=0; i<enemy.getCreatureArray().length; i++){
            Creature creature = this.enemy.getPokeCreature(i);
            indices.put(creature, i);
            if (!creature.isDead()) {
                // does the enemy have something strong against the player Pokémon?
                if (creature.hasStrongMoveAgainst(playerCreatureUpFront.getClass())) {
                    strongAgainstCreatures.add(creature);
                }
                // does the enemy have something that is not weak against the player Pokémon?
                if (!this.playerCreatureUpFront.hasStrongMoveAgainst(creature.getClass())) {
                    nonVulnerableCreatures.add(creature);
                }
                // it's a living creature - if nothing else is available it will have to do
                allCreatures.add(creature);
            }
        }

        // look through the sorted Pokémon
        if (!strongAgainstCreatures.isEmpty()){
            enemyCreatureUpFront = strongAgainstCreatures.iterator().next();
        } else if (!nonVulnerableCreatures.isEmpty()){
            enemyCreatureUpFront = nonVulnerableCreatures.iterator().next();
        } else {
            enemyCreatureUpFront = allCreatures.iterator().next();
        }
        enemyCreatureUpFrontIndex = indices.get(enemyCreatureUpFront);
    }

    /**
     * Determine if it would be a good idea for the enemy to switch out its Pokémon up to bat
     * @return boolean
     */
    private boolean smartToSwitchEnemy() {
        if (playerCreatureUpFront.hasStrongMoveAgainst(enemyCreatureUpFront.getClass()) && enemy.hasNonWeakAgainstCreature(playerCreatureUpFront.getClass())){
            // then holy shit the enemy had better switch Pokémon
            return true;
        }
        // otherwise
        if (enemyCreatureUpFront.hasWeakMoveAgainst(playerCreatureUpFront.getClass()) && enemy.hasNonWeakMoveAgainstCreature(playerCreatureUpFront.getClass())){
            // then the enemy does not have effective attacks against the player - worth switching for the enemy
            return true;
        }
        // else
        return false;
    }

    /**
     * Allows controller to bring up two Pokémon and pit them against each other.
     * @param playerMoveIndex Move for a Pokémon chosen by user
     */
    public String playRound(int playerMoveIndex){
        if(combatOver){
            throw new IllegalStateException();
        }
        else{
           // sets up combatants and if true you can call turn
            return turn(playerMoveIndex);
        }
    }

    /**
     * Make the enemy attack the player - potentially necessary whenever a swapping occurs
     * @return {@link String}
     */
    public String performEnemyAttack() {
        int enemyMoveIndex = this.pickEnemyMoveIndex();
        String message = "\nThe opponent's " + enemyCreatureUpFront.getName() + " used " + enemyCreatureUpFront.getMove(enemyMoveIndex).getName() + "!";
        message += enemyCreatureUpFront.move(enemyMoveIndex);
        if (playerCreatureUpFront.isDead()){
            player.incrementDead();
        }
        return message;
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

    /**
     * Depending on if the enemy is smart or random, an index will be returned to represent the enemy's move
     *
     * @return int - the enemy's Move index
     */
    private int pickEnemyMoveIndex() {
        if (!ArenaController.hardMode) {
            Random rand = new Random();
            return rand.nextInt(4);
        } else {
            return this.makeDecisionForEnemy();
        }
    }

    /**
     * When an enemy is smart, this is the decision process they will go through to select a move
     * @return int - the enemy's Move index
     */
    private int makeDecisionForEnemy() {
        if (this.enemyCreatureUpFront instanceof NormalCreature) {
            // map the different indices
            int heal = -1;
            int speed = -1;
            int tackle = -1;
            int hyperbeam = -1;
            for (int i = 0; i < 4; i++) {
                Move move = this.enemyCreatureUpFront.getMove(i);
                if (move == Moves.Recover) {
                    heal = i;
                } else if (move == Moves.Agility) {
                    speed = i;
                } else if (move == Moves.Tackle) {
                    tackle = i;
                } else {
                    hyperbeam = i;
                }
            }
            if (this.playerCreatureUpFront.getHealth() >= this.playerCreatureUpFront.getMaxHealth() / 2) {
                // if the enemy is high on health, go for a hyperbeam attack
                return hyperbeam;
            } else if (this.enemyCreatureUpFront.getMaxHealth() / 3 <= this.enemyCreatureUpFront.getHealth() && this.enemyCreatureUpFront.getHealth() <= this.enemyCreatureUpFront.getMaxHealth() / 2) {
                // if we are in a productive window to heal, then heal
                // too low? then we're going to be dead soon so just deal some damage
                // too high? then we don't need to heal so do something else instead
                return heal;
            } else if (this.playerCreatureUpFront.getSpeed() > this.enemyCreatureUpFront.getSpeed()) {
                // the enemy has been procrastinating speed - it should get more speed
                return speed;
            } else {
                // final move decision
                return tackle;
            }
        } else {
            // map the different indices
            int strong = -1;
            int accurate = -1;
            int tackle = -1;
            int agility = -1;
            AttackMove strongAttack = (AttackMove) Moves.Tackle;
            // actually get a hold of the move because we need to test what it is strong and weak against (which will be the same for the accurate attack)
            for (int i = 0; i < 4; i++) {
                Move move = this.enemyCreatureUpFront.getMove(i);
                if (move instanceof AttackMove && ((AttackMove) move).getAccuracy() < 1) {
                    strong = i;
                    strongAttack = (AttackMove) move;
                } else if (move instanceof AttackMove && move != Moves.Tackle) {
                    accurate = i;
                } else if (move == Moves.Tackle) {
                    tackle = i;
                } else {
                    agility = i;
                }
            }
            // is the target weak against the strong/accurateAttacks?
            if (strongAttack.isStrongAgainst(this.playerCreatureUpFront.getClass()) && this.playerCreatureUpFront.getHealth() >= this.playerCreatureUpFront.getMaxHealth() / 2) {
                // if target it at more than half health, go for the big damage with the elemental strong attack
                return strong;
            } else if (strongAttack.isStrongAgainst(this.playerCreatureUpFront.getClass())) {
                // if target is not at more than half health, go with guaranteed hits with the elemental accurate attack
                return accurate;
            } else if (!strongAttack.isWeakAgainst(this.playerCreatureUpFront.getClass()) && this.playerCreatureUpFront.getHealth() >= this.playerCreatureUpFront.getMaxHealth() / 2) {
                // it will at least be neutrally effective
                return strong;
            } else if (!strongAttack.isWeakAgainst(this.playerCreatureUpFront.getClass())) {
                // still, the accurate attack will at least be neutrally effective
                return accurate;
            } else if (this.playerCreatureUpFront.getSpeed() > 1.3 * this.enemyCreatureUpFront.getSpeed()) {
                // if this happens, the creature has not bumped up its speed in a while - may be worth doing
                return agility;
            } else {
                // if we are here, any elemental attacks are weak against the target, so we should tackle
                return tackle;
            }
        }
    }
}