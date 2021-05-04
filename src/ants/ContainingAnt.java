package ants;

import core.Ant;
import core.AntColony;

public class ContainingAnt extends Ant implements Containing {
    private Ant containedAnt = null;

    public ContainingAnt(){
        super(2, 0);
        //this.setFoodCost(4);
    }

    @Override
    public String toString() {
        return "ContainingAnt{" +
                "containedAnt=" + containedAnt +
                '}';
    }

    public void action (AntColony colony) {

    }
    @Override
    public boolean EncapsulateAnt(Ant incomingAnt) {
        if(containedAnt == null) {
            incomingAnt.setInAContaining(true);
            containedAnt = incomingAnt;
            return true;
        }
        return false;
    }

    @Override
    public boolean DeleteAnt(Ant incomingAnt) {
        if(containedAnt !=null && containedAnt==incomingAnt) {
            containedAnt=null;
            return true;
        }
        return false;
    }

    @Override
    public Ant ObtainInsect() {
        return containedAnt;
    }

//    public ContainingAnt (int armor, int foodCost) { //Surcharge
//        super(armor, foodCost);
//    }
}

