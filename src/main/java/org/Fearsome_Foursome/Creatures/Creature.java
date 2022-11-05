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

import org.Fearsome_Foursome.Moves.Move;
import org.Fearsome_Foursome.Moves.Moves;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An abstract class which has attributes and methods shared by all different types of creatures
 */
public abstract class Creature {

    /** Default attribute values */
    protected static final int DEFAULT_HEALTH = 1000;
    protected static final int DEFAULT_SPEED = 100;

    /** We need a map of functional interfaces denoting 4 moves to a certain {@link Creature} class */
    public static final HashMap<Class, ArrayList<Move>> CREATURE_MOVE_MAP = new HashMap<>();

    /** A map of all the different possible Pokémon names our app will include*/
    public static final HashMap<Class, ArrayList<String>> CREATURE_NAME_MAP = new HashMap<>();

    // CONCLUDES THE STATIC MEMBERS

    /** The current attribute values of this particular {@link Creature} instance */
    protected int health;
    protected int speed;

    /** The name of the {@link Creature} determines what sprite is associate with it */
    protected String name;

    /** Setting this target determines whom aggressive moves attack */
    protected Creature target;

    /**
     * This constructor is mainly initializing the CREATURE_MOVE_MAP
     */
    protected Creature() {
        // FIRST, in terms of what we want to do for this specific creature
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;

        // if some creature was created, then this was already initialized, so we're done
        if (!CREATURE_MOVE_MAP.isEmpty())
            return;

        // establish the fireCreature actions and names
        addFireCreatureActions();
        addFireCreatureNames();

        // establish ...

        // establish ...

        // establish ...


    }

    /**
     * Private method to add all the turns the {@link FireCreature} class can do into the dictionary
     */
    private void addFireCreatureActions(){
        CREATURE_MOVE_MAP.put(FireCreature.class, new ArrayList<>());
        ArrayList<Move> fireCreatureMoves = CREATURE_MOVE_MAP.get(FireCreature.class);

        // now add all the Moves to the relevant list
        fireCreatureMoves.add(Moves.Tackle);
        fireCreatureMoves.add(Moves.Agility);
        // third move
        // fourth move
    }

    /**
     * Private method to add all the names of the {@link FireCreature} Pokémon
     */
    private void addFireCreatureNames(){
        CREATURE_NAME_MAP.put(FireCreature.class, new ArrayList<>());
        ArrayList<String> fireCreatureNames = CREATURE_NAME_MAP.get(FireCreature.class);

        fireCreatureNames.add("Charizard");
        fireCreatureNames.add("Volcarona");
        // any other specific Pokémon names we are allowing
    }

    /**
     * Given the index in the list of moves available to this {@link Creature}, perform that move
     * @param i
     */
    public void move(int i){
        // let's make this VERY clear - first get the Move from the list of moves this particular Creatures most specific class is allowed
        Move functionalInterfaseMove = CREATURE_MOVE_MAP.get(this.getClass()).get(i);

        // now call that Move's actOn method on 'this' and 'target' - at least one of those two Creatures will be changed
        functionalInterfaseMove.actOn(this, this.target);
    }

    /**
     * Simple method to damage a {@link Creature} by a certain amount
     * @param amount
     */
    public void damage(int amount){
        this.health -= amount;
    }

    /**
     * Simple method to boost the speed of a {@link Creature}
     * @param amount
     */
    public void increaseSpeed(int amount){
        this.speed += amount;
    }

    /**
     * A simple method to select the {@link Creature}'s target for when they perform aggressive moves
     * @param target
     */
    public void setTarget(Creature target){
        this.target = target;
    }

    /**
     * Simple getter for the {@link Creature}'s name
     * @return {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Simple getter for the current health attribute
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * Simple getter for the current speed attribute
     * @return int
     */
    public int getSpeed() {
        return speed;
    }
}