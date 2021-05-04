package core;

/**
 * @author Anas Mudassar
 * This Class is to check and mark QueenAnt's Location in the Colony
 */
public class QueenBox extends Place {
    public static Place queenLocation = null;

    /**
     * @author Anas Mudassar
     * Creates a QueenAnt's Location in the Colony
     * @param Name The name of the QueenAnt
     */
    public QueenBox (String Name){
        super(Name);
    }

    /**
     * Check the Bees locations throughout the colony
     * If Bee is in QueenAnt's Location
     * Or Bee is in End of the Tunnel
     */
    public Bee[] getBees()  {
        if(queenLocation != null) //This will check
        {
            Bee[] BeeGetQueen = queenLocation.bees.toArray(new Bee[0]); // Bees enter the Queen Place
            Bee[] BeeAtEnd = this.bees.toArray(new Bee[0]); // Bees reach the end of the Tunnel
            if(BeeGetQueen == null) //Check if there is no bee at QueenAnt's Location
            {
                return BeeAtEnd;
            }
            else if(BeeAtEnd== null) //Check if there is no Bee at the End of Tunnel
            {
                return BeeGetQueen;
            }
            else {
                int BeeGetQueenLength=BeeGetQueen.length;
                int BeeAtEndLength = BeeAtEnd.length;
                Bee[] Together = new Bee[BeeGetQueenLength + BeeAtEndLength];

                return Together;
            }
        }
        return this.bees.toArray(new Bee[0]);
    }

    /**
     * @author Anas Mudassar
     * This function is to set the QueenAnt's Location in the colony
     * @param place
     * @param colony
     */
    public void setQueenLocation(Place place,AntColony colony){
        queenLocation = place;
        for(Place places:colony.getPlaces()){
            if (places.getExit() == place)
            {
                queenLocation.setEntrance(places);
            }
        }
    }

    /**
     * @author Anas Mudassar
     * This function is to get the QueenAnt's Location from the Colony
     * @return QueenAnt's Location
     */
    public Place getQueenLocation (){
        if(queenLocation == null)
        {
            return this;
        }
        else {
            return queenLocation;
        }
    }

    /**
     * @author Anas Mudassar
     * This Function is to check that if there is a QueenAnt in the colony
     * @return
     */
    public boolean TrueQueen(){
        if(queenLocation == null)
        {
            return false ;
        }
        else {
            return true;
        }
    }
}
