  
 package lesson2;

/**
 * @author xiaoming
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SnakesAndLadders sal = new SnakesAndLadders(2, 1, 1);
		System.out.println("\t\t\tYou are playing " + sal.getName() + "!");
		int dice;
		do {
			dice = SnakesAndLadders.rollDice();
			System.out.println("Turn number " + sal.getTurns());
			sal.displayBoard();
			sal.iterateTurns();
			System.out.println("Player " + sal.getCurrentPlayer() + " has rolled a " + dice + "!");
		} while (!sal.move(dice));// While no one has won yet
		System.out.println("Player number " + sal.getCurrentPlayer() + " has won!");
	}
}
