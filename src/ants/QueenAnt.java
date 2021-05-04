package ants;
import core.AntColony;

//import core.QueenPlace;

/**
 * An ant who is Queen in ant colony
 * Its Waterproof
 * IT have special powers of doubling the damage of nearby ants
 * Bees enter in Queen Ant Bos will win the game
 * Queen Cannot be removed
 * @author Anas Mudassar
 */
public class QueenAnt extends ScubaThrowerAnt
{

    /**
     * Creates a new Queen Ant.
     * Armor: 1, Food: 6, Damage: 1
     */
    public QueenAnt()
    {
        super(); //This is Armor value of the Ant
        this.setFoodCost(6); //This is the amount of food required for the Ant
        this.name = "QueenAnt1"; //This is the name of the Queen Ant

    }



    /**
     * @author Anas Mudassar
     * This is the action taken by the QueenAnt
    */

    public void action(AntColony colony) {
        super.action(colony);
    }
}



