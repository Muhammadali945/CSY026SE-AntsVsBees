package ants;

import core.AntColony;
import core.Bee;

public class StunThrowerAnt extends ThrowerAnt {

    protected int damage; // This is attack damage of the ant

    /**
     * Creates a new Ant, with a food cost of 4.
     * @author Anas Mudassar
     * The armor of the ant.
     */
    public StunThrowerAnt()
    {
        super(); // Armour of Ant
        this.damage = 1; //Set Attack Damage of Ant
        this.setFoodCost(6); //Set Food Cost required for the Ant
    }

    // This function is to get the targeted Bee
    public Bee getTarget()
    {
        return place.getClosestBee(0,3);
    }

    //This is the action done by the Ant against the Bees
    public void action(AntColony colony)
    {
        Bee target = getTarget();
        if(target != null)
        {
            //target.reduceArmor(this.damage); //This will reduce bee's armor
            target.turn = 1;
            target.attack = true;
            target.StunCount(1);
        }
    }
}

