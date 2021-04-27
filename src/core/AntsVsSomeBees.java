package core;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees
{
	public static int level=0;
	public static void playGame()
	{System.out.println(level);
		if (level == 0) {
			AntColony colony = new AntColony(3, 8, 0, 20); //specify the colony [tunnels, length, moats, food]
			//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
			Hive hive = Hive.makeFullHive();
			//Hive hive = Hive.makeInsaneHive();
			new AntGame(colony, hive); //launch the game
		}
		else if (level == 1){
			AntColony colony = new AntColony(3, 8, 2, 20); //specify the colony [tunnels, length, moats, food]
			//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
			Hive hive = Hive.makeFullHive();
			//Hive hive = Hive.makeInsaneHive();
			new AntGame(colony, hive); //launch the game
		}
	}
}
