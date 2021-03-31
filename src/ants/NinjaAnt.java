package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class NinjaAnt extends Ant{


    public NinjaAnt(){
        super(1);
        this.setBlockingAnt(true);
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
