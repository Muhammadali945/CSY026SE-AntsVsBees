package core;

import ants.SlowThrowerAnt;

/**
 * Represents a ZombieBee
 * @author Ahmed AL-KURDY
 */
public class Zombie extends Insect
{
    private static final int DAMAGE = 1;

   /**
     * Creates a new ZombieBee with the given armor
     * @param armor The bee's armor
     */
    public Zombie(int armor)
    {
        super(armor);

    }

    public void sting(Ant ant)
    {
        ant.reduceArmor(DAMAGE); // This method causes the ant to have its armor being reduced
    }

    /**
     * Moves to the given place
     * @param place The place to move to
     */
    public void moveTo(Place place)
    {
        this.place.removeInsectZ(this);
        place.addInsectZ(this);
    }


    public void leavePlace()
    {
        this.place.removeInsectZ(this);
    }

    /**
     * Returns true if the ZombieBee cannot advance (because an ant is in the way)
     * @return if the ZombieBee can advance
     */
    public boolean isBlocked()
    {
        return this.place.getAnt() != null;
    }


    public void action(AntColony colony)
    {
       if(this.isBlocked())
       {
         sting(this.place.getAnt());
       }
       else if(this.armor > 0)
       {
           this.moveTo(this.place.getExit());
       }

    }
}

