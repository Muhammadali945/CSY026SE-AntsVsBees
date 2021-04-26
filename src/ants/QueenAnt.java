package ants;
import core.*;

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
    protected int damage;
    public String QName = "AntQueen";
    private AntColony AC;
    private AntGame AG;
    //private QueenPlace QP;
    private ScubaThrowerAnt Scuba;
    public QueenAnt QAnt;
    public int NumOfQueen = 0;
    public boolean TrueQueen;
    public boolean CopyQueen;
    public int QNo;




    /**
     * Creates a new Queen Ant.
     * Armor: 1, Food: 6, Damage: 1
     */
    public QueenAnt()
    {

        super(); //This is Armor value of the Ant
        this.damage = 1; // This is Damage Value of the Ant
        this.setFoodCost(6); //This is the amount of food required for the Ant
       // this.NumOfQueen = this.NumOfQueen+1;
        //this.QNo = this.NumOfQueen;
        Counting();

    }

    /**
     * This function is to get the Number of Queens
     * @author Anas Mudassar
     */
    public int Count()
    {
        return this.NumOfQueen;
    }

    /**
     * This function is to set the Number of Queens after every turn
     * @author Anas Mudassar
     */
    public void QueenCount(int c)
    {
        this.NumOfQueen =c;
    }

    public void Counting(){
        this.QueenCount(this.Count() + 1);
    }

    /**
     * Returns a target for QueenAnt
     * @return A bee to target
     */

    public Bee getTarget()
    {
        return place.getClosestBee(0,3);
    }

    /**
     * Returns a Position for QueenAnt
     * @return queens Posiiton
     */
    public Place getQueen()
    {
        return this.getPlace();
    }


    public void action(AntColony colony) {

        Bee target = getTarget();
        QueenAnt QA = new QueenAnt();
        //Ant[] ants = this.place.getAnts();
            if (Count() <= 1) {
                super.action(colony);
                //QP.setQueenPlace(this.getQueen(),colony);

                this.TrueQueen = true;
                QA.TrueQueen = false;
            }
        else if  (Count()>1) {
            this.reduceArmor(this.armor);
            //place.removeInsect(place.getAnt());
        }


    }
}



