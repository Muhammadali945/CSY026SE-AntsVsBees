package ants;

//public class WallAnt {
//}
import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 * @author YOUR NAME HERE
 */
//Author AHMED

public class WallAnt extends Ant
{
    /**
     * Creates a new Harvester Ant
     */
    public WallAnt()
    {
        super(4);
        this.setFoodCost(4);


    }

    public void action(AntColony colony)
    {
        //TODO: Should produce one additional food for the colony

//        colony.increaseFood(4);
    }
}

