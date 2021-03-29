package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

import java.util.Random;

/**
 * An Ant that eats a random bee
 * @author Ahmed AL-KURDY
 */
public class HungryAnt extends Ant
{
    protected int damage;
    /**
     * Creates a new Hungry Ant
     */
    public HungryAnt()
    {
        super(1);
        this.setFoodCost(4);
        this.damage= 3;
    }


    public Bee getTarget(){
        return place.getClosestBee(0,3);
    }

    public void action(AntColony colony) {
        HungryAnt ha=new HungryAnt();
        Bee target = getTarget();

        if(target != null)
        {
            target.reduceArmor(ha.damage);

        }

    }
}