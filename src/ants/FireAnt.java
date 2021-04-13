package ants;
import core.*;

import static core.Bee.DAMAGE;
//import static org.junit.Assert.assertEquals;

/**
 * An ant who throws leaves at bees
 * @author YOUR NAME HERE
 */
// Author: Ahmed AL-KURDY

public class FireAnt extends Ant
{
    protected int damage;

    /*
     * Creates a new Fire Ant.
     * Armor: 1, FoodCost: 4, Damage: 3
     */
    public FireAnt()
    {
        super(1);
        this.setFoodCost(4);
        this.damage=3;
    }

    /**
     * Returns a target for this ant
     * @return A bee to target
     */

    public Bee getTarget()
    {
        return place.getClosestBee(0,0); //set the parameters to 0 so that they collide in the same place
    }

    public void action(AntColony colony)
    {
        FireAnt fa=new FireAnt();
        Bee target = getTarget(); // Creating an object for the target
        if(target != null) // if the target is not null (i.e. if there is a target)
        {
            target.reduceArmor(this.damage);
            place.removeInsect(place.getAnt()); // removes the ant

            if(fa.getArmor()<=0)
            {
                place.getClosestBee(0,1);
                Bee b= getTarget();
                if(fa.getPlace()==b.getPlace()) {
                    b.reduceArmor(this.damage);
                }
            }
        }


    }
}
