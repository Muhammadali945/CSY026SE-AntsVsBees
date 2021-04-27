package Test;
import ants.LongThrowerAnt;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Anas Mudassar
 * This class test different method and action of the LongThrowerAnt
 * A demo colony has been created to test the expected results from this test
 */
class LongThrowerAntTest {

    AntColony col = new AntColony(1,6,0,20); //Creates a new Colony
    Place pl = new Place("place"); //Creates a new place for insects
    LongThrowerAnt ltr = new LongThrowerAnt(); // Initializing the LongThrowerAnt
    Bee bee = new Bee(3); // Initializing the Bee

    /**
     * This Test will check the Food Cost required by the Long Thrower Ant
     */
    @Test
    void getFoodCost() {
        assertEquals(3,ltr.getFoodCost());
    }

    /**
     * This Test will check the Armor Value the Long Thrower Ant
     */
    @Test
    void getArmor() {
        assertEquals(1, ltr.getArmor());
    }

    /**
     * This Test will check the place where bee will become a target
     */
    @Test
    void getTarget() {
        assertEquals(bee.getPlace(), pl.getClosestBee(0,4));
    }

    /**
     * This Test will check the Action and Attack made by the Long Thrower Ant
     */
    @Test
    void action() {
        pl.addInsect(ltr); //This will add a Long Thrower Ant in the Colony
        pl.addInsect(bee); //This will add a Bee in the Colony
        ltr.action(col); //This is the Attack made by the Long Thrower Ant
        assertEquals(2, bee.getArmor()); //This is the Bee Armor value should left after the attack
    }

}