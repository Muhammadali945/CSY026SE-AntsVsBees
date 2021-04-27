package Test;

import ants.SlowThrowerAnt;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BeeTest {
    /**
    * @author Anas Mudassar
    * This class test different method and action of the Bee after attacked by SlowThrowerAnt
    * */
    Bee bee = new Bee(3);
    AntColony colony = new AntColony(1,6,0,20); //Creates a new Colony
    Place pl = new Place("place");
    SlowThrowerAnt SlAnt = new SlowThrowerAnt();


    /**
     * @author Anas Mudassar
     * This Test is to check the Turn Count for a new BEE
     */
    @Test
    void getTurn() {
        Bee be = new Bee(3); //Initializing a new Bee
        assertEquals(0,be.Turn()); //This will check the new Bee Turn Count
    }

    /**
     * @author Anas Mudassar
     * This Test is to check the Turn Count for a BEE after 3 turn
     */
    @Test
    void setTurn() {
        Bee be = new Bee(3); //Initializing a new Bee
        be.TurnCount(3); // This will set the turn count of the bee to 3
        assertEquals(3,be.Turn()); //This will check the turn number for the bee according to 3
    }


    /**
    * @author Anas Mudassar
    * This is to check the Action of the BEE after each turn when attacked by SlowThrowerAnt
    * */
    @Test
    void action() {

        pl.addInsect(SlAnt); //Place SlowThrowerAnt into the Colony
        pl.addInsect(bee); //Place Bee into the Colony
        SlAnt.action(colony); //Action of the SlowThrowerAnt
        bee.action(colony); //First Action of the Bee
        assertEquals(1,bee.Turn()); //This will check the Bee Turn Count after 1 turn
        bee.action(colony); //Second Action of the Bee
        assertEquals(2,bee.Turn()); //This will check the Bee Turn Count after 2 turn
        assertEquals(0,SlAnt.getArmor()); //Armor Value of SlowThrowerAnt after 2 turns attack by Bee

    }
}