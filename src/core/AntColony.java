package core;

import Bees.GhostBee;
import ants.ContainingAnt;
import ants.QueenAnt;

import java.util.ArrayList;

/**
 * An entire colony of ants and their tunnels.
 * @author Joel
 * @version Fall 2014
 */
public class AntColony
{
	public static final String QUEEN_NAME = "AntQueen"; //name of the Queen's place
	public static final int MAX_TUNNEL_LENGTH = 8;
	private int food; //amount of food available
	//private Place queenPlace; //where the queen is
	private ArrayList<Place> places; //the places in the colony
	private ArrayList<Place> beeEntrances; //places which bees can enter (the starts of the tunnels)
	QueenBox queenbox; //QueenBox the location of QueenAnt @author Anas Mudassar
	
	/**
	 * Creates a new ant colony with the given layout.
	 * @param numTunnels The number of tunnels (paths)
	 * @param tunnelLength The length of each tunnel
	 * @param moatFrequency The frequency of which moats (water areas) appear. 0 means that there are no moats
	 * @param startingFood The starting food for this colony.
	 */
	public AntColony(int numTunnels, int tunnelLength, int moatFrequency, int startingFood) {
		//simulation values
		this.food = startingFood;
		//init variables
		places = new ArrayList<Place>();
		beeEntrances = new ArrayList<Place>();
		queenbox = new QueenBox(QUEEN_NAME); //magic variable namexw

		tunnelLength = Math.min(tunnelLength, MAX_TUNNEL_LENGTH); //don't go off the screen!
		//set up tunnels, as a kind of linked-list
		Place curr, prev; //reference to current exit of the tunnel
		for (int tunnel = 0; tunnel < numTunnels; tunnel++) {
			System.out.println(moatFrequency);

			curr = queenbox; //start the tunnel's at the queen
			for (int step = 0; step < tunnelLength; step++) {
				prev = curr;
				if (moatFrequency == 0) {
					curr = new Place("tunnel[" + tunnel + "-" + step + "]", prev); // create new place with an exit that is the previous spot
					prev.setEntrance(curr); // the previous person's entrance is the new spot
					places.add(curr); // add new place to the list
				}
				if (moatFrequency != 0) {//Check if moat freq is not zero before making any water places
					if (moatFrequency == 1) { //make all the places as water places
						curr = new Water("tunnel[" + tunnel + "-" + step + "]", prev); // create new place with an exit that is the previous spot
						prev.setEntrance(curr); // the previous person's entrance is the new spot
						places.add(curr); // add new place to the list
					} else { // leave a gap between water places equal to the moat frequency
						if (step % moatFrequency == 0) {
							curr = new Water("tunnel[" + tunnel + "-" + step + "]", prev); // create new place with an exit that is the previous spot
							prev.setEntrance(curr); // the previous person's entrance is the new spot
							places.add(curr); // add new place to the list
						} else {
							curr = new Place("tunnel[" + tunnel + "-" + step + "]", prev); // create new place with an exit that is the previous spot
							prev.setEntrance(curr); // the previous person's entrance is the new spot
							places.add(curr); // add new place to the list
						}
					}
				}//
			}
			beeEntrances.add(curr); //current place is last item in the tunnel, so mark that it is a bee entrance
		} //loop to next tunnel

	}

	/**
	 * Returns an array of Places in this colony. Places are ordered by tunnel, with each tunnel's places listed start to end.
	 * @return The tunnels in this colony
	 */
	public Place[] getPlaces()
	{
		return places.toArray(new Place[0]);
	}
	
	/**
	 * Returns an array of places that the bees can enter into the colony
	 * @return Places the bees can enter
	 */
	public Place[] getBeeEntrances()
	{
		return beeEntrances.toArray(new Place[0]);
	}

	/**
	 * Returns the queen's location
	 * @return The queen's location
	 */
	public Place getQueenPlace()
	{
		return queenbox.getQueenLocation();
	}
	
	/**
	 * Returns the amount of available food
	 * @return the amount of available food
	 */
	public int getFood()
	{
		return food;
	}
	
	/**
	 * Increases the amount of available food
	 * @param amount The amount to increase by
	 */
	public void increaseFood(int amount)
	{
		food += amount;
	}
	
	/**
	 * Returns if there are any bees in the queen's location (and so the game should be lost)
	 * @return if there are any bees in the queen's location
	 */
	public boolean queenHasBees()
	{
		return this.queenbox.getBees().length  > 0;
	}

	/**
	 * @author Anas Mudassar
	 * This is the Default Ant Deploy Function
	 * @param place
	 * @param ant
	 */
	public void placeAnt(Place place, Ant ant){
		if ((food >= ant.getFoodCost() && place.getAnt() == null) || (food >= ant.getFoodCost() && place.getAnt() instanceof ContainingAnt && !(ant instanceof ContainingAnt)) || (food >= ant.getFoodCost() && !(place.getAnt() instanceof ContainingAnt) && ant instanceof ContainingAnt)) {
			if (place instanceof Water && (ant.isWaterSafe())) {
				System.out.println("from water side");
				this.food -= ant.getFoodCost();
				place.addInsect(ant);
			} else if (place instanceof Water && (!(ant.isWaterSafe()))) {
				System.out.println("This ant cannot swim");

			} else {
				System.out.println("from normal side");
				this.food -= ant.getFoodCost();
				place.addInsect(ant);
			}
		}
	}

	//place an ant if there is enough food available
	/**
	 * Places the given ant in the given tunnel IF there is enough available food. Otherwise has no effect
	 * If in case a bodyguard has to be added, it will check that already a bodyguard ant is not present at that place
	 * @param place Where to place the ant
	 * @param ant The ant to place
	 */
	public void deployAnt(Place place, Ant ant) {
		System.out.println(ant.isWaterSafe());
		/**
		 * @author Anas Mudassar
		 * The following code will check if there is already a Queen Ant in the Colony
		 * If there is no QueenAnt in the colony then QueenAnt can be placed
		 * If there is a QueenAnt in the colony then another QueenAnt cannot placed
		 */
		if ((food >= ant.getFoodCost() && place.getAnt() == null)) {
			if(ant.name == "QueenAnt1") //This will check the QueenAnt name
			{
				if(!queenbox.TrueQueen()) //This will check if there is No QueenAnt in colony
				{
						food -= ant.getFoodCost();
						place.addInsect(ant);
						queenbox.setQueenLocation(place, this);
				}
				else {
					System.out.println("There can only be one True Queen.");
				}
			}
			else {
				placeAnt(place, ant);
			}
		}
		else {
			System.out.println("Not enough food remains to place " + ant);
		}
	}

	/**
	 * Removes the ant inhabiting the given Place
	 * @param place Where to remove the ant from
	 */
	public void removeAnt(Place place)
	{
		if(place.getAnt() != null) {
			if (place.getAnt() instanceof QueenAnt){
				System.out.println("QueenAnt cannot be Remove");
			}
			else {
				place.removeInsect(place.getAnt());
			}
		}
	}
	
	/**
	 * Returns a list of all the ants currently in the colony
	 * @return a list of all the ants currently in the colony
	 */
	public ArrayList<Ant> getAllAnts() {
		ArrayList<Ant> ants = new ArrayList<Ant>();
		for (Place p : places) {
			if (p.getAnt() != null) {
				if (p.getAnt() instanceof ContainingAnt) { // check if the ant is a Containing ant
					//	
					if (((ContainingAnt) p.getAnt()).ObtainInsect() != null){ // if the above is true; check the encapsulated ant 
						ants.add(((ContainingAnt) p.getAnt()).ObtainInsect());// get the encapsulated ant so it performs same action of encapsulated ant
					}
				}

				ants.add(p.getAnt());
			}
		}
			return ants;
		}

	
	/**
	 * Returns a list of all the bees currently in the colony
	 * @return a list of all the bees currently in the colony
	 */
	public ArrayList<Bee> getAllBees()
	{
		ArrayList<Bee> bees = new ArrayList<Bee>();
		for(Place p : places)
		{
			for(Bee b : p.getBees())
				bees.add(b);
		}
		return bees;
	}

	public ArrayList<GhostBee> getAllGhostBees()
	{
		ArrayList<GhostBee> gbees = new ArrayList<GhostBee>();
		for(Place p : places)
		{
			for(GhostBee gb : p.getGhostBees())
				gbees.add(gb);
		}
		return gbees;
	}

	
	public String toString()
	{
		return "Food: "+this.food+"; "+getAllBees() + "; "+getAllGhostBees() + "; "+getAllAnts();
	}	
}
