package ants;

import core.Ant;
import core.AntColony;

public class BodyguardAnt extends ContainingAnt implements Containing {

    public BodyguardAnt(){

        super();
        this.setFoodCost(4);

    }
    @Override
    public void action(AntColony colony){
        super.ObtainInsect().action(colony);

    }

}
