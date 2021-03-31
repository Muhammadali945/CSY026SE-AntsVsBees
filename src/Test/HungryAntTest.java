package Test;

import static org.junit.jupiter.api.Assertions.*;

import ants.HungryAnt;
import core.Bee;
import core.Place;
import core.AntColony;
import org.junit.jupiter.api.Test;

class HungryAntTest {
    AntColony colony = new AntColony(1,5,0,5);
    Place place = new Place("place");
    HungryAnt ha = new HungryAnt();
    Bee bee1 = new Bee(3);
    Bee bee2 = new Bee(3);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
//        place.addInsect(ha);
//        place.addInsect(bee1);
//        place.addInsect(bee2);
//
//        colony.deployAnt(place, ha);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void getTarget() {

    }

    @Test
    void getTurn() {
        HungryAnt ha = new HungryAnt();
        assertEquals(0,ha.getTurn());
    }

    @Test
    void setTurn() {
        ha.setTurn(3);
        assertEquals(3,ha.getTurn());
    }

    @Test
    void testFoodRequiredByHungryAnt() {
        place.addInsect(ha);
        place.addInsect(bee1);
        colony.deployAnt(place, ha);


        assertEquals(1,colony.getFood());
        //assertEquals(true, ha.action(););

    }

    @Test
    void testIncreaseInTurnValueAfterAction(){
        place.addInsect(ha);
        place.addInsect(bee1);
        colony.deployAnt(place, ha);

        ha.action(colony);
        ha.action(colony);
        assertEquals(2,ha.getTurn());
    }

    @Test
    void testTargetBeeInThePlace(){
        place.addInsect(ha);
        place.addInsect(bee1);
        colony.deployAnt(place, ha);

        assertEquals(bee1, ha.getTarget());

    }
    @Test
    void testCheckDamageToBeeAfterAction(){
        place.addInsect(ha);
        place.addInsect(bee1);
        ha.action(colony);
        assertEquals(0,bee1.getArmor());



    }
    @Test
    void testHungryAntsWaitTimeBeforeAttackingAnotherBee(){
        place.addInsect(ha);
        place.addInsect(bee1);
        ha.action(colony);
        assertEquals(0,bee1.getArmor());
        place.addInsect(bee2);
        ha.action(colony);
        assertNotEquals(0,bee2.getArmor());
        ha.action(colony);
        ha.action(colony);
        ha.action(colony);
        assertEquals(0,bee2.getArmor());


    }

}