package Test;

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
    /*Bee bee;
    AntColony colony;
    Place place1;
    Place place2;
    Place place3;*/
    Bee bee = new Bee(3);
    AntColony colony = new AntColony(1,5,0,5);
    Place place1 = new Place("place1");
    Place place2 = new Place("place1");
    Place place3 = new Place("place1");
    Ant throwerAnt = new ThrowerAnt();


    @Test
    void setPlace() {
        bee.setPlace(place1);
        assertEquals(place1,bee.getPlace());
    }

    @Test
    void getArmor() {
        assertEquals(3,bee.getArmor());
    }

    @Test
    void reduceArmorByAntAction() {
        place1.addInsect(bee);
        place1.removeInsect(throwerAnt);
        colony.deployAnt(place1,throwerAnt);
        throwerAnt.action(colony);
        assertEquals(2,bee.getArmor());
    }


    @Test
    void sting() {
        place1.addInsect(bee);
        place1.removeInsect(throwerAnt);
        colony.deployAnt(place1,throwerAnt);
        bee.sting(throwerAnt);
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

    @Test
    void isBlocked() {
        place1.addInsect(bee);
        place1.addInsect(throwerAnt);
        colony.deployAnt(place1,throwerAnt);
        assertEquals(true, bee.isBlocked());
        place1.removeInsect(throwerAnt);
        assertEquals(false, bee.isBlocked());
    }

    @Test
    void action() {

    }
}