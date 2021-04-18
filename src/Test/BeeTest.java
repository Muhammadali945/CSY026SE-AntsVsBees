package Test;

import ants.BodyguardAnt;
import ants.ThrowerAnt;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import core.Ant;


class BeeTest {
    /**
    * @author Muhammad
    * This class various functions associated with bee class including inherited methods from its super class ie insect
    * */
    Bee bee = new Bee(3);
    AntColony colony = new AntColony(1,5,0,10);
    Place place1 = new Place("place1");
    Place place2 = new Place("place2");
    Place place3 = new Place("place3",place1);
    Ant throwerAnt = new ThrowerAnt();
    Ant body = new BodyguardAnt();


    @Test
    void setPlace() {
        bee.setPlace(place1);
        assertEquals(place1,bee.getPlace());
    }

    @Test
    void getArmor() {
        assertEquals(3,bee.getArmor()); // default armor of bee is 3
    }

    /**
    * Checking whether ant reduces the armour of bee
    * */
    @Test
    void reduceArmorByAntAction() {
        place1.addInsect(bee);
        place1.addInsect(throwerAnt);
        colony.deployAnt(place1,throwerAnt);
        throwerAnt.action(colony);
        assertEquals(2,bee.getArmor());
    }

    // Stingfunction reduces armour of ant by 1, if it is blocked by it.
    @Test
    void sting() {
        place1.addInsect(bee);
        place1.addInsect(throwerAnt);
        place1.addInsect(body);
        colony.deployAnt(place1,throwerAnt);
        colony.deployAnt(place1, body);
        bee.action(colony);
        assertEquals(0,throwerAnt.getArmor());
    }


    @Test
    void moveTo() {
        bee.setPlace(place1);
        bee.moveTo(place2);
        assertEquals(place2,bee.getPlace());
    }

    @Test
    void leavePlace() {
        place1.addInsect(bee);
        System.out.println(bee.getPlace());
        bee.leavePlace();
        System.out.println(bee.getPlace());
        assertNotEquals(place1,bee.getPlace());
    }

    /** This function checks if an ant is present is the same place,
     * then bee must be blocked. (only differs in Ninja ant case as it cannot be seen)
     */

    @Test
    void isBlocked() {
        place1.addInsect(bee);
        place1.addInsect(throwerAnt);
        colony.deployAnt(place1,throwerAnt);
        assertEquals(true, bee.isBlocked());
        place1.removeInsect(throwerAnt);
        assertEquals(false, bee.isBlocked());
    }
    /**
    * The purpose of this test is to check 2 things in action function of bee:
    * 1- If insect it not present in the place, bee's action is to just exit that place.
    * 2- If insect is present, it will reduce insect's armour by 1, and then exit in next action.
    * */
    @Test
    void action() {
        place3.addInsect(bee);
        bee.action(colony);
        assertEquals(place1, bee.getPlace()); //should return place1, as place 1 is exit for place 3 (line # 25)

        place3.addInsect(bee);
        place3.addInsect(throwerAnt);
        bee.action(colony);
        assertEquals(0,throwerAnt.getArmor());// reduced thrower ant's armour
        assertEquals(place3, bee.getPlace());
        bee.action(colony); // call action one more time to make bee exit place3 now.
        assertEquals(place1, bee.getPlace());

    }
}