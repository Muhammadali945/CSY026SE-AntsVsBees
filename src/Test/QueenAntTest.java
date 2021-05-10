package Test;

import ants.QueenAnt;
import ants.ThrowerAnt;
import core.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Anas Mudassar
 * This class test different method and action of the QueenAnt
 * A demo colony has been created to test the expected results from this test
 */

class QueenAntTest {

    AntColony col = new AntColony(1,6,0,20); //Creates a new Colony
    Place pl = new Place("place"); //Creates a new place for insects
    QueenBox QB = new QueenBox("Queen");
    Place placeExit = new Place("placeExit", QB);
    Place water = new Water("water",pl); //Creates Water in Colony
    QueenAnt qa = new QueenAnt(); // Initializing the QueenAnt
    Bee bee = new Bee(3); // Initializing the Bee
    ThrowerAnt ta = new ThrowerAnt(); // Initialize other ant
    AntGame game = new AntGame(col, Hive.makeFullHive() );


    /**
     * This Test will check the Food Cost required by the Queen Ant
     */
    @Test
    void getFoodCost() {
        assertEquals(6,qa.getFoodCost());
    }

    /**
     * This Test will check the Armor Value the Queen Ant
     */
    @Test
    void getArmor() {
        assertEquals(1, qa.getArmor());
    }

    /**
     * This Test will check the Queen is Water Safe
     */
    @Test
    void QueenWaterSafe() {
        assertEquals(true, qa.waterSafe);
    }

    /**
     * This Test will check the place where bee will become a target
     */
    @Test
    void getTarget() {
        assertEquals(bee.getPlace(), pl.getClosestBee(0,3));
    }

    /**
     * This Test will check the Action and Attack made by the Queen Ant
     */
    @Test
    void action() {
        pl.addInsect(qa); //This will add a Queen Ant in the Colony
        pl.addInsect(bee); //This will add a Bee in the Colony
        qa.action(col); //This is the Attack made by the Queen Ant
        assertEquals(2, bee.getArmor()); //This is the Bee Armor value should left after the attack
        //assertEquals(2,ta.getDamage());
    }

    /**
     * @ author Muhammad
     * This test will check whether Queen Ant increases the damage of other ants in same place
     */
    @Test
    void checkOtherAntsIncreasedDamage(){

        placeExit.addInsect(qa);
        pl.addInsect(ta);
        placeExit.addInsect(bee);
        ta.action(col);
        assertEquals(1,bee.getArmor());
    }

    @Test
    void QueenAntDies(){
        col.deployAnt(QB,qa);
        col.deployAnt(placeExit, ta);
        QB.setQueenLocation(QB, col);
        QB.addInsect(bee);
        bee.action(col);
        assertEquals(true,col.queenHasBees());
    }
}