package ants;
import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees for short distance
 * @author Anas Mudassar
 */
public class ShortThrowerAnt extends ThrowerAnt
{
    /**
     * Creates a new Short Thrower Ant.
     * Armor: 1, Food: 3, Damage: 1
     */
    public ShortThrowerAnt()
    {
        super(); //This is Armor value of the Ant
        this.setFoodCost(3); //This is the amount of food required for the Ant
    }

    /**
     * Returns a target for ShortThrowerAnt
     * @return A bee to target
     */
    public Bee getTarget()
    {
        return place.getClosestBee(0,2);
    }

    public void action(AntColony colony)
    {
        Bee target = getTarget();
        if(target != null)
        {
            target.reduceArmor(super.damage);
        }
    }
}

