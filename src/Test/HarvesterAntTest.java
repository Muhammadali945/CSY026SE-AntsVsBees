package Test;
import ants.HarvesterAnt;
import core.AntColony;
import core.Place;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Anas Mudassar
 * This class test different method and action of the HarvesterAnt
 * A demo colony has been created to test the expected results from this test
 */
class HarvesterAntTest {

    AntColony col = new AntColony(1,6,0,24); //Creates a new Colony
    Place pl = new Place("place"); //Creates a new place for insects
    HarvesterAnt ha = new HarvesterAnt(); // Initializing the Harvester Ant


    /**
     * This Test will check the Food Cost required by the Harvester Ant
     */
    @Test
    void getFoodCost() {
        assertEquals(2,ha.getFoodCost());
    }

    /**
     * This Test will check the Armor Value the Harvester Ant
     */
    @Test
    void getArmor() {
        assertEquals(1, ha.getArmor());
    }

    /**
     * This Test will check the Action made by the Harvester Ant
     */
    @Test
    void action() {
        pl.addInsect(ha); //This will add a Harvester Ant in the Colony
        ha.action(col); //This is the Action made by the Harvester Ant
        assertEquals(26, col.getFood()); //This is the Food Amount in colony should increase by 2 after the Harvester Ant Action
    }

}