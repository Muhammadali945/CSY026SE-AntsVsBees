package core;

/**
 * A class representing a basic Ant
 * 
 * @author YOUR NAME HERE
 */
public abstract class Ant extends Insect
{
	protected int foodCost; //the amount of food needed to make this ant
	public boolean blockingAnt;
	private boolean isInAContaining;
	protected int damage;


	/**
	 * Creates a new Ant, with a food cost of 0.
	 * @param armor The armor of the ant.
	 */
	public Ant(int armor, int damage)
	{
		super(armor, null);
		blockingAnt = false; //default is false, only true for ninja ant
		isInAContaining = false; //default is false
		this.setWaterSafe(false); //default is false, meaning not water safe
		this.damage = damage;
		//this.foodCost = 0;
	}

	@Override
	public String toString() {
		return "Ant{" +
				"foodCost=" + foodCost +
				", blockingAnt=" + blockingAnt +
				", isInAContaining=" + isInAContaining +
				'}';
	}

	/**
	 * Returns the ant's food cost
	 * @return the ant's good cost
	 */
	public int getFoodCost()
	{
		return foodCost;
	}
	public void setFoodCost(int foodCost)
	{
		 this.foodCost = foodCost;
	}
	/**
	 * Removes the ant from its current place
	 */
	public void leavePlace()
	{
		this.place.removeInsect(this);
	}

	public boolean getBlockingAnt() {  //Ajout getters setters de BlockingAnt
		return blockingAnt;
	}

	public void setBlockingAnt(boolean blockingAnt) {
		this.blockingAnt = blockingAnt;
	}

	public boolean isInAContaining() {
		return isInAContaining;
	}

	public void setInAContaining(boolean isInAContaining) {
		this.isInAContaining = isInAContaining;
	}
}
