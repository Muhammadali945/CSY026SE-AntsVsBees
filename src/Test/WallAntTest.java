package Test;

import ants.ThrowerAnt;
import ants.WallAnt;
import core.Ant;
import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.Test;

import static Test.FireAntTest.place;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallAntTest {
    Bee bee = new Bee(3);
    AntColony colony = new AntColony(1,5,0,5);

    Place place = new Place("place");

    WallAnt wa = new WallAnt();

    @Test
    public void action() {
        place.addInsect(wa);
        place.addInsect(bee);
        bee.action(colony);
        assertEquals(3,wa.getArmor(),0);
        assertEquals(wa.getArmor(),bee.getArmor(),0);
    }
}