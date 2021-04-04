package Test;
import static org.junit.jupiter.api.Assertions.*;

import ants.*;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.jupiter.api.Test;

/**
 * @author Muhammad
 * This class test various methods and actions of the bodyguard ant
 * Initially a colony has been setup and some insects and places have been added for the testing purpose
 */

public class BodyguardAntTest {


    AntColony colony = new AntColony(1,5,0,20);
    Place place = new Place("place");
    BodyguardAnt bga = new BodyguardAnt();
    ThrowerAnt ta = new ThrowerAnt();
    NinjaAnt na = new NinjaAnt();
    HungryAnt ha = new HungryAnt();
    Bee bee1 = new Bee(3);
    Bee bee2 = new Bee(3);

    /**
     * This tests check:
     * 1- A bodyguard ant can be placed in  a block where an ant already exists.
     * 2- The ant's "isInAContaining" attribute must be set to true.
     * 3- After addition of bodyguard ant, console must display a message.
     */

    @Test
    void TestEncapsulateAntmethod() {
        place.addInsect(ta);
        place.addInsect(bga);
        assertEquals(true, ta.isInAContaining());
    }

    /**
     * To check obtainInsect method, returning the encapsulated ant inside the bodyguard ant
     */

    @Test
    void obtainInsect() {
        place.addInsect(ta);
        place.addInsect(bga);
        assertEquals(ta, bga.ObtainInsect());

    }

    @Test
    void getFoodCost() {
        assertEquals(4,bga.getFoodCost());
    }

    //Test for checking that if an ant is passed to this function, this function sets its "isInAContaing" attribute true
    @Test
    void isInAContaining() {
        bga.EncapsulateAnt(ta);
        assertEquals(true, ta.isInAContaining());

    }

    //Another method to test the food food decreased by adding a bodyguard ant to any ant.
    @Test
    void deployAnt() {

        colony.deployAnt(place,ta);
        colony.deployAnt(place,bga);
        place.addInsect(bee1);
        bga.action(colony);
        assertEquals(bga, place.getAnt());


        assertEquals(12,colony.getFood());
        assertEquals(2,bee1.getArmor());
    }

    @Test
    void getArmor() {
        assertEquals(2, bga.getArmor());
    }

    /**
     * To test that bodyguard ant acquires the action of its contained ant
     */
    @Test
    void TestBodyguardAntAction() {
        colony.deployAnt(place,ta); // add a thrower ant to colony
        colony.deployAnt(place,bga); // add a bodyguardAnt so it encapsulates ninja ant
        place.addInsect(bee1); // add a bee to the same place
        bga.action(colony); //

        // bodyguardAnt should take action of thrower ant, and reduce bee armor by 1.
        assertEquals(2, bee1.getArmor());

        //checking the same for hungry ant.

        bga.DeleteAnt(ta); //first remove thrower ant from BodyguardAnt
        colony.removeAnt(place);

        //repeat same procedure.
        colony.deployAnt(place,ha);
        colony.deployAnt(place,bga);


        bga.action(colony);
        assertEquals(0, bee1.getArmor());
        assertEquals(0,place.getBees().length);


    }
    /**
     * In 2 steps, this test checks that deleting a bodyguard ant method deletes the contained ant in a
     * body guard ant.
     */
    @Test
    void TestDeleteContainedAntInBodyguardAnt(){
        colony.deployAnt(place,ta); // add a thrower ant to colony
        colony.deployAnt(place,bga); // add a bodyguardAnt so it encapsulates ninja ant
        place.addInsect(bee1); // add a bee to the same place
        bga.action(colony); //

        // bodyguardAnt should take action of thrower ant, and reduce bee armor by 1.
        assertEquals(2, bee1.getArmor());

        //checking the same for hungry ant.

        bga.DeleteAnt(ta); //first remove thrower ant from BodyguardAnt
        assertEquals(null, bga.ObtainInsect());


    }
}
