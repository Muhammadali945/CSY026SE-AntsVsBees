package ants;

import core.AntColony;


public class ScubaThrowerAnt extends ThrowerAnt{

    public  ScubaThrowerAnt(){
       super();
       this.setWaterSafe(true);
       this.setFoodCost(5);
    }

    @Override
    public void action(AntColony colony) {
        super.action(colony);
    }
}
