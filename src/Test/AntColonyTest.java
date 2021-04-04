package Test;

import ants.HarvesterAnt;
import ants.ThrowerAnt;
import core.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ali
 * This class tests various functions of Ant colony class
 */
class AntColonyTest {
    Bee bee = new Bee(3);
    AntColony colony = new AntColony(1,5,0,5);
    Place place1 = new Place("place1");
    Place place2 = new Place("place2");
    Place place3 = new Place("place3",place1);
    Ant throwerAnt = new ThrowerAnt();
    Ant harvesterAnt = new HarvesterAnt();
    Place[] pl;
    ArrayList<Ant> PL;

    /**
     *This test checks the places returned by the getPlaces() function.
     * It is also a checker for constructor as constructor sets the number of places equal to the tunnel length
     */
    @Test
    void getPlaces() {
        pl = colony.getPlaces();
        assertEquals("tunnel[0-0]", pl[0].getName());
        assertEquals(5,pl.length);

    }


    /**
     * This method tests 2 points, as per the constructor of the class
     * 1- The name of the queen place should be "AntQueen"
     * 2- The entrance of the Queen place is the first item in the tunnel.
     */
    @Test
    void getQueenPlace() {
        assertEquals("AntQueen",colony.getQueenPlace().getName());
        assertEquals("tunnel[0-0]",colony.getQueenPlace().getEntrance().getName());

    }

    /**
     * Starting food in a colony is passed as a parameter to the constructor which in this case shlould be 5
     */
    @Test
    void getFood() {
        assertEquals(5, colony.getFood());

    }

    @Test
    void increaseFood() {
        harvesterAnt.action(colony);
        assertEquals(7,colony.getFood());
    }

    @Test
    void queenHasBees() {
        //place1.addInsect(bee);
        colony.getQueenPlace().addInsect(bee);
        assertEquals(true, colony.queenHasBees());

    }

    /**
     * This test is to check whether deploying an ant reduces total food.
     */
    @Test
    void deployAnt() {
        colony.deployAnt(place1,harvesterAnt);
        assertEquals(3,colony.getFood());
    }

    @Test
    void removeAnt() {
        place1.addInsect(harvesterAnt);
        colony.removeAnt(place1);
        assertEquals(null,place1.getAnt());
    }


}