package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 * @author YOUR NAME HERE
 */
// Author: Ahmed AL-KURDY

public class FireAnt extends Ant
{
    protected int damage;

 /*
     * Creates a new Thrower Ant.
     * Armor: 1, Food: 0, Damage: 1
     */
    public FireAnt()
    {
        super(1);
        this.setFoodCost(4);

    }

    /**
     * Returns a target for this ant
     * @return A bee to target
     */

    public Bee getTarget()
    {
        return place.getClosestBee(0,3);
    }

    public void action(AntColony colony)
    {
        FireAnt fa=new FireAnt();

        colony.increaseFood(4);


        Bee target = getTarget();
        if(fa.getArmor()==0 && fa.getArmor()==target.getArmor())
        {
            this.damage=3;
            target.reduceArmor(this.damage);
            System.out.println("\n Armor reduced accordingly.");

        }

    }
}
