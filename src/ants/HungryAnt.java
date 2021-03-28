package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An Ant that eats a random bee
 * @author Ahmed AL-KURDY
 */
public class HungryAnt extends Ant
{

    /**
     * Creates a new Hungry Ant
     */
    public HungryAnt()
    {
        super(1);
        this.setFoodCost(4);

    }


    public Bee getTarget()
    {
        return place.getClosestBee(0,3);
    }

    public void action(AntColony colony) {
        ThrowerAnt ta=new ThrowerAnt();
        Bee target = getTarget();
        if(target != null)
        {
            target.reduceArmor(ta.damage);
        }
        colony.increaseFood(4);
    }
}