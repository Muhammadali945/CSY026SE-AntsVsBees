package Test;
import ants.ShortThrowerAnt;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Anas Mudassar
 * This class test different method and action of the ShortThrowerAnt
 * A demo colony has been created to test the expected results from this test
 */
class ShortThrowerAntTest {

    AntColony col = new AntColony(1,6,0,20); //Creates a new Colony
    Place pl = new Place("place"); //Creates a new place for insects
    ShortThrowerAnt str = new ShortThrowerAnt(); // Initializing the ShortThrowerAnt
    Bee bee = new Bee(3); // Initializing the Bee

    /**
     * This Test will check the Food Cost required by the Short Thrower Ant
     */
    @Test
    void getFoodCost() {
        assertEquals(3,str.getFoodCost());
    }

    /**
     * This Test will check the Armor Value the Short Thrower Ant
     */
    @Test
    void getArmor() {
        assertEquals(1, str.getArmor());
    }

    /**
     * This Test will check the place where bee will become a target
     */
    @Test
    void getTarget() {
        assertEquals(bee.getPlace(), pl.getClosestBee(0,2));
    }

    /**
     * This Test will check the Action and Attack made by the Short Thrower Ant
     */
    @Test
    void action() {
        pl.addInsect(str); //This will add a Short Thrower Ant in the Colony
        pl.addInsect(bee); //This will add a Bee in the Colony
        str.action(col); //This is the Attack made by the Short Thrower Ant
        assertEquals(2, bee.getArmor()); //This is the Bee Armor value should left after the attack
    }

}