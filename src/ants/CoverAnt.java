package ants;

import core.Ant;
import core.AntColony;

/**
 * @author Muhammad
 * This is an abstract class for the bodyguard ants and has been designed so the bodyguard ant can  inherit
 * more features and function.
 * It implements EncapsulationCharacter for its characteristic features.
 * It has a memeber function of type ant, which it has to provide cover for.
 */
public class CoverAnt extends Ant implements EncapsulationCharacter {
    private Ant containedAnt = null;

    // constructor
    public CoverAnt(){
        super(2, 0);
        //this.setFoodCost(4);
    }

    @Override
    public String toString() {
        return "ContainingAnt{" +
                "containedAnt=" + containedAnt +
                '}';
    }
    // This function would be over ride in the inherited class.
    public void action (AntColony colony) {

    }
    // This function receives th ant already present at the place of deployment
    @Override
    public boolean EncapsulateAnt(Ant incomingAnt) {
        if(containedAnt == null) {
            incomingAnt.setInAContaining(true);
            containedAnt = incomingAnt;
            return true;
        }
        return false;
    }
// Function for deleting the encapsulated ant and is used while removing an
// instance of cover ant when ots armor is finished
    @Override
    public boolean DeleteAnt(Ant incomingAnt) {
        if(containedAnt !=null && containedAnt==incomingAnt) {
            containedAnt=null;
            return true;
        }
        return false;
    }
// To return the ant encapsulated. This function will be used to get the action of the encapsulated ant
    @Override
    public Ant ObtainInsect() {
        return containedAnt;
    }

//    public ContainingAnt (int armor, int foodCost) { //Surcharge
//        super(armor, foodCost);
//    }
}

