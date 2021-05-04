package ants;
import core.AntColony;
import core.Bee;
import core.Zombie;

/**
 * An ant who throws leaves at bees for Long distance
 * @author Anas Mudassar
 */
public class LongThrowerAnt extends ThrowerAnt
{

    /**
     * Creates a new Long Thrower Ant.
     * Armor: 1, Food: 3, Damage: 1
     */
    public LongThrowerAnt()
    {
        super(); //This is Armor value of the Ant
        this.setFoodCost(3); //This is the amount of food required for the Ant
    }

    /**
     * Returns a target for LongThrowerAnt
     * @return A bee to target
     */
    public Bee getTarget()
    {
        return place.getClosestBee(0,4);
    }

    ////////////////////////////////////////////
    public Zombie getTargetZ()
    {
        return place.getClosestZombie(0,4);
    }
    ////////////////////////////////////////////
    public void action(AntColony colony)
    {
        Bee target = getTarget();
        if(target != null)
        {
            target.reduceArmor(super.damage);
        }
    }
}


