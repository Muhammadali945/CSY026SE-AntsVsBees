package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * @author Muhammad
 * This class is responsible for handling Ninja ant which has a property of blocking ant set to true.
 * It is not blocked by bee and the damage is done. Ninja ant can not die.
 */

public class NinjaAnt extends Ant{


    public NinjaAnt(){
        super(1, 1);
        this.setBlockingAnt(true); // this sets it invisible to bee.
        this.setFoodCost(6);


    }
    public void action(AntColony colony) {
        Bee[] targets = this.place.getBees();
        if (targets.length > 0) {
            for (Bee b : targets) {
                b.reduceArmor(1);
            }
        }
    }

}
