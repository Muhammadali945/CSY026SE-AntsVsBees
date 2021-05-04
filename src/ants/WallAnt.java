package ants;

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
        super(4,0);
        this.setFoodCost(4);
    }

    public void action(AntColony colony)
    {

    }
}

