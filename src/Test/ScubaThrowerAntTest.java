package Test;

import ants.ScubaThrowerAnt;
import ants.WallAnt;
import core.AntColony;
import core.Bee;
import core.Place;
import core.Water;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ants.*;

/**
 * @author Muhammad
 * This class test various methods and actions of the scuba thrower ant
 * Initially a colony has been setup and some insects and places have been added for the testing purpose
 */


class ScubaThrowerAntTest {
    Bee bee = new Bee(3);
    AntColony colony = new AntColony(1,5,1,10);

    Place place = new Place("place");
    Place water = new Water("water",place);
    ScubaThrowerAnt sta = new ScubaThrowerAnt();

    
    @Test
    void isWaterSafe() {
        assertEquals(true,sta.waterSafe);
    }

    @Test
    void TestPlaceScubaThrowerAntInWater() {
        water.addInsect(sta);
        colony.deployAnt(water,sta);
        assertEquals(sta, water.getAnt());
    }

    @Test
    void TestActionOfScubaThrowerAnt() {
        colony.deployAnt(place, sta); // add a scuba thrower ant to colony
        place.addInsect(bee); // add a bee to the same place
        sta.action(colony); // ant takes action

        // Scuba Thrower should take action of thrower ant, and reduce bee armor by 1.
        assertEquals(2, bee.getArmor());
    }

    @Test
    void TestStingOnScubaAnt(){
        colony.deployAnt(place, sta); // add a scuba thrower ant to colony
        place.addInsect(bee); // add a bee to the same place
        bee.action(colony); // bee takes action

        assertEquals(0, sta.getArmor());
    }


}