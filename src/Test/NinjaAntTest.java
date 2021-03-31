package Test;

import ants.HungryAnt;
import ants.NinjaAnt;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NinjaAntTest {
    AntColony colony = new AntColony(1,5,0,10);
    Place place1 = new Place("place1");
    Place place2 = new Place("place2");
    Place place3 = new Place("place3");
    Place place = new Place("place");
    NinjaAnt na = new NinjaAnt();
    Bee bee1 = new Bee(3);
    Bee bee2 = new Bee(3);
    Bee[] bees;





    @BeforeEach
    void setUp() {
        colony.deployAnt(place,na);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkBlockingStatue(){
        assertEquals(true , na.getBlockingAnt());
    }

    @Test
    void checkWhetherBeesBlockedByNinjaAnt(){
        place.addInsect(bee1);
        place.addInsect(na);


        assertEquals(false, bee1.isBlocked());

    }
    @Test
    void CheckDamageByNinjaAnt(){
        place.addInsect(bee1);
        place.addInsect(na);

        na.action(colony);

        assertEquals(2,bee1.getArmor());

    }

    @Test
    void CheckFoodCostForNinjaAnt(){
        assertEquals(4,colony.getFood());
    }

    @Test
    void CheckBeeShouldBeKilledIf3NinjaAntsInWay(){

        place1.addInsect(bee1);
        place1.addInsect(na);
        na.action(colony);
        place1.removeInsect(bee1);
        place2.addInsect(bee1);
        place2.addInsect(na);
        na.action(colony);
        place2.removeInsect(bee1);
        place3.addInsect(bee1);
        place3.addInsect(na);
        na.action(colony);
        place3.removeInsect(bee1);

        assertEquals(0,bee1.getArmor());


    }

}