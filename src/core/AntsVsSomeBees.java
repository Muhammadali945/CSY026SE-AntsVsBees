package core;

/**
 * @author Muhammad
 * This class has been modified to create different difficulty levels of the game. It is called by static method from class "level_menu"
 */
public class AntsVsSomeBees
{
	public static int level=0;
	public static void playGame()
	{System.out.println(level);
		if (level == 0) { // easy level ; no moats
			AntColony colony = new AntColony(3, 8, 0, 20); //specify the colony [tunnels, length, moats, food]
			//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
			Hive hive = Hive.makeFullHive();
			//Hive hive = Hive.makeInsaneHive();
			new AntGame(colony, hive); //launch the game
		}
		else if (level == 1){ // medium level , having moat frequency 2
			AntColony colony = new AntColony(3, 8, 2, 20); //specify the colony [tunnels, length, moats, food]
			//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
			Hive hive = Hive.makeFullHive();
			//Hive hive = Hive.makeInsaneHive();
			new AntGame(colony, hive); //launch the game
		}

		else if (level == 2){ // hard level having moats and strong bee hive
			AntColony colony = new AntColony(3, 8, 2, 20); //specify the colony [tunnels, length, moats, food]
			//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
			Hive hive = Hive.makeInsaneHive();
			//Hive hive = Hive.makeInsaneHive();
			new AntGame(colony, hive); //launch the game
		}
		else if (level == 3){
			AntColony colony = new AntColony(3, 8, 2, 2); //specify the colony [tunnels, length, moats, food]
			//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
			Hive hive = Hive.makeInsaneHive();
			//Hive hive = Hive.makeInsaneHive();
			new AntGame(colony, hive); //launch the game
		}
	}
}
