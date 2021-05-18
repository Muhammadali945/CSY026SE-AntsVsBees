package ants;

import core.AntColony;

/**
 * @author Muhammad
 * The bodyguard ant is a CoverAnt and it implements functions declared in interface EncapsulationCharacter
 * It has a food cost of 4 and can be deployed on water areas well
 * It cover an already deployed ants and protects it from damage until its own armot is finished.
 */

public class BodyguardAnt extends CoverAnt implements EncapsulationCharacter {

    public BodyguardAnt(){

        super();
        this.setFoodCost(4);
        this.setWaterSafe(true);

    }
    // Takes the action of the ant which it encapsulates.
    @Override
    public void action(AntColony colony){
        super.ObtainInsect().action(colony);

    }

}
