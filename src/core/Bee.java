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
	public int stun; //This is used for StunThrowerAnt
	public int slow; //This is used for SlowThrowerAnt
	public boolean attack; //This is to access the bee attack from SlowThrowerAnt
	SlowThrowerAnt sl = new SlowThrowerAnt();
	
	/**
	 * Creates a new bee with the given armor
	 * @param armor The bee's armor
	 */
	public Bee(int armor)
	{
		super(armor);
		//turn=0; //initialising the turn
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
	 * This function is to set the value of Stun Effect
	 * @author Anas Mudassar
	 */
	public void StunCount(int c)
	{
		if (this.stun < c){
			this.stun = c;
		}

	}

	/**
	 * This function is to set the value of Slow Effect
	 * @author Anas Mudassar
	 */
	public void SlowEffect(int c)
	{
		if (this.slow < c){
			this.slow = c;
		}
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

	/**
	 * This is the Default Bee Attack
	 */
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
		 * This statement will check if the bee is attacked by SlowThrowerAnt or StunThrowerAnt
		 * @author Anas Mudassar
		 */
		if (attack == true) //This line recoganize that if BEE is attacked by a Slow or Stun Ant
		{
			if (this.slow == 1) {
				if (Turn() % 3 == 0) //This will enable effect and slow bee for 3 turns
				{
					BeeAttack();
					TurnCount(Turn() + 1); //This will increase the turn count after every turn
					attack = true; //This will enable the Slow Effect on Bee
				}
				else{
					this.moveTo(this.place.getExit()); //This will move bee to next box
					TurnCount(Turn() + 1); //This will increase the turn count after every turn
					attack = true; //This will enable the Slow Effect on Bee
				}
			}
			else if (this.stun == 1)
			{
				if (Turn()%2==1) //This line will Stun Bee for 1 Turn
				{
					TurnCount(Turn() + 1); //This will increase the turn count after every turn
					attack = false; //This will remove the Stun Effect on Bee if not attacked again by a stun ant
				}
				else {
					BeeAttack(); //Normal Bee Attack
				}
			}
		}
		else {
			BeeAttack();
		}
	}
}
