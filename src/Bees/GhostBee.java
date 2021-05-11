package Bees;

import core.AntColony;
import core.Bee;
import core.Place;

public class GhostBee extends Bee{
    /**
     * Creates a new bee with the given armor
     *
     * @param armor The bee's armor
     */
    public GhostBee(int armor) {
        super(armor);
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
        //GhostMoveTo(this.place.getExit());
    }
}
