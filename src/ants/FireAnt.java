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
        this.damage= 1;
    }

    /**
     * Returns a target for this ant
     * @return A bee to target
     */

    public Bee getTarget()
    {
        return place.getClosestBee(0,3);
    }

    // The following function reduces the armor of the bees and sets the value of damage to 3
    // and kills both the the ant and the bee once they co-locate
    public void setFireAntArmor(FireAnt fa, Bee target)
    {
        if(target != null)
        {
            fa.damage=3;
            target.DAMAGE=3;
            target.reduceArmor(target.DAMAGE);
            place.removeInsect(this);
        }
    }
    public void action(AntColony colony)
    {
        FireAnt fa=new FireAnt();
        Bee target = getTarget();
        setFireAntArmor(fa,target ); //Call to the function setFireAntArmor

    }
}
