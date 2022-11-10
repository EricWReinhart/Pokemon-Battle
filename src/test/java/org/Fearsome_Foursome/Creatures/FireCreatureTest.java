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
 * Description: Testing the FireCreature class
 *
 * *****************************************/

package org.Fearsome_Foursome.Creatures;

import org.Fearsome_Foursome.Moves.AttackType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireCreatureTest {

    /** Two {@link FireCreature}s to be used for testing */
    private FireCreature fireCreature0;
    private FireCreature fireCreature1;

    /** How many trials do we want to use to ensure that our aggressive moves are working with expected hit frequency? */
    public static final int NUM_TRIALS = 1000;

    /** Further, What are our thresholds for plausible lower and upper limits before concluding that the move is not behaving as expected? */
    public static final double LOWER_BOUND_ON_EXPECTED_ACCURACY = 0.8;
    public static final double UPPER_BOUND_ON_EXPECTED_ACCURACY = 1.2;


    /**
     * Simple method to initialize the two {@link FireCreature}s above
     */
    @BeforeEach
    void setUp() {
        fireCreature0 = new FireCreature(0);
        fireCreature1 = new FireCreature(1);
    }

    /**
     * Simple test to ensure that the name of the {@link FireCreature}s are correct
     */
    @Test
    void testName() {
        assertEquals("Charizard", fireCreature0.getName());
        assertEquals("Volcarona", fireCreature1.getName());
    }

    /**
     * A simple test to ensure that the Attack Moves are behaving as expected
     */
    @Test
    void testAttacking() {
        // set up the targeting
        fireCreature0.setTarget(fireCreature1);

        // keep track of the old values
        int fireCreature1OldHealth = fireCreature1.getHealth();

        // this should "Tackle" fireCreature2 over and over - make sure the health of fireCreature2 decreases around the expected amount of the time
        int numHits = 0;
        for (int i=0; i<NUM_TRIALS; i++) {
            fireCreature0.move(2);
            if (fireCreature1OldHealth - AttackType.Weak.getDamage() == fireCreature1.getHealth()){
                numHits++;
                // refresh fireCreature1
                fireCreature1 = new FireCreature(1);
                fireCreature0.setTarget(fireCreature1);
            }
        }

        // make sure the number of hits is within our expected range
        assertTrue( AttackType.Weak.getAccuracy()*LOWER_BOUND_ON_EXPECTED_ACCURACY*NUM_TRIALS < numHits && numHits < AttackType.Weak.getAccuracy()*UPPER_BOUND_ON_EXPECTED_ACCURACY*NUM_TRIALS);

    }

    /**
     * A simple test to ensure that the Support Moves are behaving as expected
     */
    @Test
    void testSupport() {
        // this should "Agility" fireCreature1
        int fireCreature0OldSpeed = fireCreature0.getSpeed();
        fireCreature0.move(3);
        assertTrue(fireCreature0OldSpeed < fireCreature0.getSpeed());
    }

}