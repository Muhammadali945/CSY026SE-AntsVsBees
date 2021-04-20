package core;

import ants.SlowThrowerAnt;

/**
 * Represents a Bee
 * @author Anas Mudassar
 */
public class Bee extends Insect
{
	private static final int DAMAGE = 1;
	public int turn; //This is turn used by the bee
	public boolean attack; //This is to access the bee attack from SlowThrowerAnt
	SlowThrowerAnt sl = new SlowThrowerAnt();
	
	/**
	 * Creates a new bee with the given armor
	 * @param armor The bee's armor
	 */
	public Bee(int armor)
	{
		super(armor);
		turn=0; //initialising the turn
		attack = false; //by default attack will be false
	}

	/**
	 * This function is to get the value of current turn
	 * @author Anas Mudassar
 	 */
	public int Turn()
	{
		return this.turn;
	}

	/**
	 * This function is to set the value of turn after every turn
	 * @author Anas Mudassar
	 */
	public void TurnCount(int c)
	{
		this.turn =c;
	}
	/**
	 * Deals damage to the given ant
	 * @param ant The ant to sting
	 */
	public void sting(Ant ant)
	{
		ant.reduceArmor(DAMAGE);
	}
	
	/**
	 * Moves to the given place
	 * @param place The place to move to
	 */
	public void moveTo(Place place)
	{
		this.place.removeInsect(this);
		place.addInsect(this);
	}

	public void BeeAttack(){
		if (this.isBlocked())
		{
			sting(this.place.getAnt());
			//TurnCount(Turn() + 1); //This will increase the turn count after every turn
		}
		else if (this.armor > 0)
		{
			this.moveTo(this.place.getExit());
			//TurnCount(Turn() + 1);
		}
	}
	public void leavePlace()
	{
		this.place.removeInsect(this);
	}
	
	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 * @return if the bee can advance
	 */
	public boolean isBlocked()
	{
		return this.place.getAnt() != null;
	}

	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place.
	 */
	public void action(AntColony colony)
	{

		/**
		 * This statement will check if the bee is attacked by SlowThrowerAnt
		 * @author Anas Mudassar
		 */

			if (this.attack = false) {
				BeeAttack();
			} else if (this.attack = true) {
				if (Turn() % 2 == 1) {
					this.moveTo(this.place);
					TurnCount(Turn() + 1);
					attack = true; //This will enable the Slow Effect on Bee
				} else if (Turn() % 2 == 0) //This will enable effect and slow bee for 2 turns
				{
					BeeAttack();
					TurnCount(Turn() + 1);
					attack = true; //This will enable the Slow Effect on Bee
				}
			}
			if (this.getArmor() == 0){
				this.attack = false;
			}
	}
}
