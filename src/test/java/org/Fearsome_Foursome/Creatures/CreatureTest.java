/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Team: Fearsome Foursome
 * Section: 02
 * Date: 11/4/22
 * Time: 12:48 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Creatures
 * Class: FireCreature
 *
 * Description: Testing the different Creature sub classes
 *
 * *****************************************/

package org.Fearsome_Foursome.Creatures;

import org.Fearsome_Foursome.Moves.AttackMove;
import org.Fearsome_Foursome.Moves.CreatureAttribute;
import org.Fearsome_Foursome.Moves.SupportMove;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    /** How many trials do we want to use to ensure that our aggressive moves are working with expected hit frequency? */
    public static final int NUM_TRIALS = 1000;

    /** Further, What are our thresholds for plausible lower and upper limits before concluding that the move is not behaving as expected? */
    public static final double LOWER_BOUND_ON_EXPECTED_ACCURACY = 0.8;
    public static final double UPPER_BOUND_ON_EXPECTED_ACCURACY = 1.2;


    /** All the {@link Creature}s we have to test */
    private Creature first;
    private Creature second;
    private Creature third;
    private Creature fourth;
    private Creature fifth;
    private Creature sixth;
    private Creature seventh;
    private Creature eighth;
    
    /** A list of all the {@link Creature}s */
    private ArrayList<Creature> creatures;

    /**
     * Simple method to initialize the two {@link FireCreature}s above
     */
    @BeforeEach
    void setUp() {
        // set up the Creatures
        first = new FireCreature(0);
        second = new FireCreature(1);
        third = new WaterCreature(0);
        fourth = new WaterCreature(1);
        fifth = new GrassCreature(0);
        sixth = new GrassCreature(1);
        seventh = new NormalCreature(0);
        eighth = new NormalCreature(1);
        
        // add them to the creatures List
        creatures = new ArrayList<>();
        creatures.add(first);
        creatures.add(second);
        creatures.add(third);
        creatures.add(fourth);
        creatures.add(fifth);
        creatures.add(sixth);
        creatures.add(seventh);
        creatures.add(eighth);
    }

    /**
     * Simple test to ensure that the name of the {@link FireCreature}s are correct
     */
    @Test
    void testName() {
        // FireCreatures
        assertEquals("Charizard", first.getName());
        assertEquals("Volcarona", second.getName());

        // WaterCreatures
        assertEquals("Blastoise", third.getName());
        assertEquals("Gyarados", fourth.getName());

        // GrassCreatures
        assertEquals("Venusaur", fifth.getName());
        assertEquals("Sceptile", sixth.getName());

        // NormalCreatures
        assertEquals("Snorlax", seventh.getName());
        assertEquals("Staraptor", eighth.getName());

    }

    /**
     * A simple test to ensure that the Attack Moves are behaving as expected
     */
    @Test
    void testAttacking() {
        // test every possible pairing
        for (int i=0; i<creatures.size(); i++){
            for (int j=0; j< creatures.size(); j++){
                if (j != i){
                    // don't target yourself
                    assertTrue(this.attacksWork(creatures.get(i), creatures.get(j)));
                }
            }
        }
    }

    /**
     * Helper method to perform statistical test
     * @param hitter {@link Creature}
     * @param target {@link Creature}
     * @return int
     */
    private boolean attacksWork(Creature hitter, Creature target) {
        // set up targeting
        hitter.setTarget(target);

        List<Integer> attackIndices = new ArrayList<>();
        // find all the hitter's attacks
        for (int i=0; i<4; i++){
            if (Creature.CREATURE_MOVE_MAP.get(hitter.getClass()).get(i) instanceof AttackMove)
                attackIndices.add(i);
        }

        // make sure each attack behaves as expected
        for (int index : attackIndices){
            AttackMove theAttack = (AttackMove)Creature.CREATURE_MOVE_MAP.get(hitter.getClass()).get(index);

            // set up the damage scaling
            double scale = 0.0;
            if (theAttack.isWeakAgainst(target.getClass()))
                scale = 0.5;
            else if (theAttack.isStrongAgainst(target.getClass()))
                scale = 2.0;
            else
                scale = 1.0;

            // now count the number of hits
            int numHits = 0;
            int oldTargetHealth = target.getHealth();
            for (int i=0; i<NUM_TRIALS; i++){
                hitter.move(index);
                if (target.getHealth() == oldTargetHealth - (int)(theAttack.getDamage()*scale)){
                    numHits++;
                    // and refresh the target
                    target.health = target.maxHealth;
                }
            }

            // ensured the number of hits is around the expected number
            if (!(theAttack.getAccuracy()*LOWER_BOUND_ON_EXPECTED_ACCURACY*NUM_TRIALS < numHits && numHits < theAttack.getAccuracy()*UPPER_BOUND_ON_EXPECTED_ACCURACY*NUM_TRIALS))
                return false;
        }

        return true;
    }

    /**
     * A simple test to ensure that the Support Moves are behaving as expected
     */
    @Test
    void testSupports() {
        for (Creature pokemon : creatures)
            assertTrue(this.supportsWork(pokemon));
    }

    /**
     * Method to ensure that SupportMoves are working correctly
     * @param mover {@link Creature}
     * @return boolean
     */
    private boolean supportsWork(Creature mover){
        List<Integer> supportIndices = new ArrayList<>();
        // find all the hitter's attacks
        for (int i=0; i<4; i++){
            if (Creature.CREATURE_MOVE_MAP.get(mover.getClass()).get(i) instanceof SupportMove)
                supportIndices.add(i);
        }

        // test to make sure all the supports work as expected
        for (int index : supportIndices){
            SupportMove theSupport = (SupportMove)Creature.CREATURE_MOVE_MAP.get(mover.getClass()).get(index);

            // we are changing the health
            if (theSupport.getAttributeToChange().equals(CreatureAttribute.Health)){
                int oldHealth = mover.getHealth();
                mover.move(index);
                if (!(mover.getHealth() == oldHealth + theSupport.getBonus()))
                    return false;
            }

            // we are changing the speed
            if (theSupport.getAttributeToChange().equals(CreatureAttribute.Speed)){
                int oldSpeed = mover.getSpeed();
                mover.move(index);
                if (!(mover.getSpeed() == oldSpeed + theSupport.getBonus()))
                    return false;
            }

            // we are changing the maximum health
            if (theSupport.getAttributeToChange().equals(CreatureAttribute.MaxHealth)){
                int oldMaxHealth = mover.getMaxHealth();
                mover.move(index);
                if (!(mover.getMaxHealth() == oldMaxHealth + theSupport.getBonus()))
                    return false;
            }

        }

        return true;
    }

}