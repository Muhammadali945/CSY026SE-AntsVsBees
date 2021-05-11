package Bees;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Place;

public class GhostBee extends Bee {
    /**
     * Creates a new bee with the given armor
     *
     * @param armor The bee's armor
     */
    public GhostBee(int armor) {
        super(3);
    }

    public void leavePlace()
    {
        this.place.removeGhostInsect(this);
    }

    public boolean isBlocked()
    {
        return this.place.getAnt() != null;
    }

    public void sting(Ant ant)
    {
        ant.reduceArmor(0);
    }

    public void GhostMoveTo(Place place)
    {
        this.place.removeGhostInsect(this);
        place.addGhostInsect(this);
    }

    public void action(AntColony colony)
    {
        //super.moveTo(super.place.getExit()); //This will move bee to next box
       super.action(colony);
       // GhostMoveTo(this.place.getExit());

    }
}
