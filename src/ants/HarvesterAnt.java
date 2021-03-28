package ants;

import core.Ant;
import core.AntColony;

// Author: Ahmed AL-KURDY
// This is the harvester ant

public class HarvesterAnt extends Ant
{
	/**
	 * Creates a new Harvester Ant
	 */
	public HarvesterAnt()
	{
		super(1);
		this.setFoodCost(2);

	}

	public void action(AntColony colony)
	{
		//TODO: Should produce one additional food for the colony

		colony.increaseFood(2);

	}
}
