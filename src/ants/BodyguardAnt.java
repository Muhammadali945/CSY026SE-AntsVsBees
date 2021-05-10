package ants;

import core.AntColony;

public class BodyguardAnt extends CoverAnt implements EncapsulationCharacter {

    public BodyguardAnt(){

        super();
        this.setFoodCost(4);
        this.setWaterSafe(true);

    }
    @Override
    public void action(AntColony colony){
        super.ObtainInsect().action(colony);

    }

}
