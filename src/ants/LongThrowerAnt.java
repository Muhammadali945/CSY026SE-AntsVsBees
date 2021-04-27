package ants;
import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees for Long distance
 * @author Anas Mudassar
 */
public class LongThrowerAnt extends Ant
{
    protected int damage;

    /**
     * Creates a new Long Thrower Ant.
     * Armor: 1, Food: 3, Damage: 1
     */
    public LongThrowerAnt()
    {
        super(1); //This is Armor value of the Ant
        this.damage = 1; // This is Damage Value of the Ant
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

    public void action(AntColony colony)
    {
        Bee target = getTarget();
        if(target != null)
        {
            target.reduceArmor(this.damage);
        }
    }
}


