package Test;

import core.AntColony;
import core.Bee;
import core.Place;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class FireAntTest {
    public static int DAMAGE = 1;
    public int damage = 3;

    public static int getDAMAGE() {
        return DAMAGE;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public static void setDAMAGE(int DAMAGE) {
        FireAntTest.DAMAGE = DAMAGE;
    }


    private final java.lang.Object obj = null;


    static Place place = new Place("place");
    private Object Bee;




    @Test
    public void getTargetTest() {
        FireAntTest fa = new FireAntTest();
        Bee bee1 = (Bee) place.getClosestBee(0, 0);
        assertEquals(bee1, place.getClosestBee(0, 0));
    }
}