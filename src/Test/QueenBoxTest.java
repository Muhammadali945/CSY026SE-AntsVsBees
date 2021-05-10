package Test;

import ants.QueenAnt;
import core.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Anas Mudassar
 * This class test different method and action of the QueenBox Class
 * A demo colony has been created to test the expected results from this test
 */

class QueenBoxTest {

    AntColony col = new AntColony(1,6,0,20); //Creates a new Colony
    Place pl = new Place("place"); //Creates a new place for insects
    Place water = new Water("water",pl); //Creates Water in Colony
    QueenAnt qa = new QueenAnt(); // Initializing the Queen Ant
    Bee bee = new Bee(3); // Initializing the Bee
    QueenBox qb = new QueenBox(qa.name); //Creates a Queen Place in the colony

    /**
     * This Test will check the name the Queen Ant
     */
    @Test
    void getQueenName() {
        assertEquals("QueenAnt1", qb.getName());
    }


    /**
     * This Test will check the place where bee will enter the Queen's Place
     */
    @Test
    void getBees() {
        assertEquals(bee.getPlace(), qa.getPlace());
    }

    /**
     * This Test will check the place of the Queen Ant
     */
    @Test
    void QueenLocation() {
        assertEquals(qa.getPlace(), qb.getAnt());
    }

    /**
     * This Test will check the the there is no Queen Ant before this Queen Ant
     */
    @Test
    void OneQueen() {
        assertEquals(false, qb.TrueQueen());
    }

}