/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2022
 * Instructor: Pro. Brian King
 * Name: Connor Coles
 * Date: 11/8/22
 * Time: 2:47 PM
 *
 * Project: csci205_final_project
 * Class: Player
 * Description:
 *
 * Responsible for creating and managing the team.
 *
 ****************************************
 */

import org.Fearsome_Foursome.Creatures.Creature;
import org.Fearsome_Foursome.Creatures.FireCreature;
import org.Fearsome_Foursome.Creatures.GrassCreature;
import org.Fearsome_Foursome.Creatures.WaterCreature;


public class Player {

    /**
     * An ArrayList of Creatures
     */
    private Creature[] creatureArrayList = new Creature[6];

    /**
     * Creates a team
     */
    public Player(){
        //Creating a Fire creature for team
        creatureArrayList[0] = new FireCreature(0);
        creatureArrayList[1] = new FireCreature(1);

        //Creating a water Creature for team
        creatureArrayList[2] = new WaterCreature(0);
        creatureArrayList[3] = new WaterCreature(1);

        //Creating a water Creature for team
        creatureArrayList[3] = new GrassCreature(0);
        creatureArrayList[4] = new GrassCreature(1);
    }

    /** Allows use to get a poke creature at array*/
    public Creature getPokeCreature(int i){
        return creatureArrayList[i];
    }
}
   