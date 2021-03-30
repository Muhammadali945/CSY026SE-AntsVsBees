package ants;

import core.Ant;
import core.AntColony;
import core.Bee;


/*
 * @ author Ali
 * Hungry ants waits for the bee to come ot itslef as it has to eat it.
 * After eating the bee, it waits for the next three turns so that it can digest the bee.
 * @Params turn : This increases in every action. When it becomes a multiple of three, the condition for ant to attack becomes true.
 * */
public class HungryAnt extends Ant {

    private int turn; // tells whether its this ants turn to attack
    private boolean digested; // is basically the time required for ant to digest the bee.

    public HungryAnt() {
        super(1);
        this.setFoodCost(4);
        turn=0;
    }

    public Bee getTarget() {
        return place.getClosestBee(0,0);
    }

    public int getTurn() {
        return this.turn;
    }

    public void setTurn(int d) {
        this.turn=d;
    }

    public void action (AntColony colony) {
        Bee target = getTarget();
        if (target != null && getTurn()%3==0) {
            target.reduceArmor(target.getArmor());
            setTurn(getTurn()+1);
            digested=true;
        }
        else if (digested==true) {
            setTurn(getTurn()+1);
        }
    }
}
