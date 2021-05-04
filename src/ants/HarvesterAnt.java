package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 * @author YOUR NAME HERE
 */
public class HarvesterAnt extends Ant
{
	/**
	 * Creates a new Harvester Ant
	 */
	public HarvesterAnt()
	{
		super(1, 0);
		this.setFoodCost(2);
	}

	public void action(AntColony colony)
	{
		colony.increaseFood(2); // increases the food with 2
	}	
}
