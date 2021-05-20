import java.util.*;

public class Game {
	
	public static Random rand = new Random();
	
	String game;
	
	public Game() {
		
	}
	
	public static void playRussianRoulette(ArrayList<Person> people) {
		
		people.get(rand.nextInt(people.size())).die();
		
	}
	
	public static int rollDice() {
		return rand.nextInt(5) + 1;
	}

}
