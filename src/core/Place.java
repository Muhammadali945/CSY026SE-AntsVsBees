package core;

import ants.EncapsulationCharacter;
import ants.ContainingAnt;

import java.util.ArrayList;

/**
 * Represents a location in the game
 * @author Joel
 * @version Fall 2014
 */
public class Place
{
	private String name; //a name we can use for debugging
	private Place exit; //where you leave this place to
	private Place entrance; //where you enter this place from
	protected ArrayList<Bee> bees; //bees currently in the place
	private Ant ant; //ant (singular) currently in the place
	private ArrayList<Zombie> zombies; //Zombies currently in place
	/**
	 * Creates a new place with the given name and exit
	 * @param name The place's name
	 * @param exit The place's exit
	 */
	public Place(String name, Place exit)
	{
		this.name = name;
		this.exit = exit;
		this.entrance = null;
		this.bees = new ArrayList<Bee>();
		this.zombies=new ArrayList<Zombie>(); //recently added to constructor
		this.ant = null;
	}
	
	/**
	 * Creates a new place with the given name
	 * @param name The place's name
	 */
	public Place(String name)
	{
		this(name, null);
	}
	
	/**
	 * Returns the place's ant
	 * @return the place's ant
	 */
	public Ant getAnt()
	{
		return ant;
	}
	
	/**
	 * Returns an array of the place's bees
	 * @return an array of the place's bees
	 */
	public Bee[] getBees()
	{
		return bees.toArray(new Bee[0]);
	}

	/**
	 * Returns an array of the place's bees
	 * @return an array of the place's bees
	 */
	public Zombie[] getZombies()
	{
		return zombies.toArray(new Zombie[0]);
	}

	/**
	 * Returns a nearby bee, up to the maxDistance ahead. If multiple bees are the same distance, a random bee is chosen
	 * @param minDistance The minimum distance away (in Places) a bee can be. A value of -1 means no min distance
	 * @param maxDistance The maximum distance away (in Places) a Bee can be. A value of -1 means no max distance
	 * @return A random nearby bee.
	 */
	public Bee getClosestBee(int minDistance, int maxDistance)
	{
		Place p = this;
		for(int dist = 0; p!=null && dist <= maxDistance; dist++)
		{
			if(dist >= minDistance && p.bees.size() > 0)
				return p.bees.get((int)(Math.random()*p.bees.size())); //pick a random bee
			p = p.entrance;
		}
		return null;
	}
	////////////////////////////////////////////////////////////////
	/**
	 * Author: Ahmed AL-KURDY
	 * Returns a nearby zombie, up to the maxDistance ahead. If multiple zombie are the same distance, a random zombie is chosen
	 * @param minDistance The minimum distance away (in Places) a zombie can be. A value of -1 means no min distance
	 * @param maxDistance The maximum distance away (in Places) a Zombie can be. A value of -1 means no max distance
	 * @return A random nearby Zombie.
	 */


	public Zombie getClosestZombie(int minDistance, int maxDistance)
	{
		Place p = this;
		for(int dist = 0; p!=null && dist <= maxDistance; dist++)
		{
			if(dist >= minDistance && p.zombies.size() > 0)
				return p.zombies.get((int)(Math.random()*p.zombies.size())); //pick a random bee
			p = p.entrance;
		}
		return null;
	}

	////////////////////////////////////////////////////////////////
	/**
	 * Returns the name of the place
	 * @return the name of the place
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the exit of the place
	 * @return the exit of the place
	 */
	public Place getExit()
	{
		return exit;
	}
	
	/**
	 * Sets the entrance to the place
	 * @param entrance The entrance to the place
	 */
	public void setEntrance(Place entrance)
	{
		this.entrance = entrance;
	}
	
	/**
	 * Returns the entrance to the place
	 * @return the entrance to the place
	 */
	public Place getEntrance()
	{
		return this.entrance;
	}
	
	/**
	 * Adds an ant to the place. If there is already an ant, this method has no effect
	 * If the ant at this place is a bodyguard ant, it wont have any effect
	 * If ant in the place is not a bodyguard, it calls the Encapsuale ant() method of
	 * containing ants to set the "inacontaining" property of this ant to true and the  adds a containing ant to this place.
	 * @param ant The ant to add to the place.
	 */
	public void addInsect(Ant ant)
	{
		if(this.ant == null)
		{
			this.ant = ant;
			ant.setPlace(this);
		}
		/**
		 * @author Muhammad
		 */
		else if (this.ant != null && !(this.ant instanceof EncapsulationCharacter) && ant instanceof EncapsulationCharacter) {
			if (((EncapsulationCharacter) ant).EncapsulateAnt(this.ant)) {
				this.ant = ant;
				ant.setPlace(this);
				System.out.println("A Bodyguard Ant has been placed in this " + this);
			}
			else {
				System.out.println("Already an ant con in " + this);
			}
		}
		else {
			System.out.println("Already an ant in " + this); //report error
		}
	}

	/**
	 * Adds a bee to the place
	 * @param bee The bee to add to the place.
	 */
	public void addInsect(Bee bee)
	{
		bees.add(bee);
		bee.setPlace(this);
	}	

	//Adds a zombie to the place.

	public void addInsectZ(Zombie zombie)
	{
		zombies.add(zombie);
		zombie.setPlace(this);
	}



	/**
	 * Removes the ant from the place. If the given ant is not in this place, this method has no effect
	 * @param ant The ant to remove from the place
	 */
	public void removeInsect(Ant ant)
	{
		if(this.ant == ant) {
			if (this.ant instanceof ContainingAnt) {// first check if it is a bodyguard ant
				this.ant = (((EncapsulationCharacter) ant).ObtainInsect()); // get the ant which is protected by bodyguard
				ant.setPlace(this); // replace this place by the actual ant behind the bodyguard ant
			}
			else{
				this.ant = null;
				ant.setPlace(null);
			}
		}

		else
			System.out.println(ant + " is not in "+this);
	}
	
	/**
	 * Removes the bee from the place. If the given bee is not in this place, this method has no effect
	 * @param bee The bee to remove from the place.
	 */
	public void removeInsect(Bee bee)
	{
		if(bees.contains(bee))
		{
			bees.remove(bee);
			bee.setPlace(null);
		}
		else
			System.out.println(bee + " is not in "+this);
	}
	////////////////////////////////////////////////////////////////////////////////
	/**
	 * Removes the zombie from the place. If the given zombie is not in this place, this method has no effect
	 * @param zombie The zombie to remove from the place.
	 */
	public void removeInsectZ(Zombie zombie)
	{
		if(zombies.contains(zombie))
		{
			zombies.remove(zombie);
			zombie.setPlace(null);
		}
		else
			System.out.println(zombie + " is not in "+this);
	}
	/////////////////////////////////////////////////////////////////////////////




	public String toString()
	{
		return name;
	}	
}
