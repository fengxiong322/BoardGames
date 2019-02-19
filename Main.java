package lesson2;

/**
 * This class creates an object of SnakesAndLadders and uses its methods
 * @author Feng, Michael
 *
 */
public class Main {

	/**
	 * Main method 
	 * @param args
	 */
	public static void main(String[] args) {
		SnakesAndLadders sal = new SnakesAndLadders(2, 1, 1);
		sal.generateLadder(0, 2, 2, 4, 4);
		sal.generateLadder(1, 3, 3, 5, 5);
		sal.generateSnake(0, 3, 4, 7, 7);
		sal.generateSnake(1, 2, 4, 4, 6);
		System.out.println("\t\t\tYou are playing " + sal.getName() + "!");
		System.out.println("Number of pieces: " + sal.getNumOfPieces());
		System.out.println("Length of Board: " + sal.getLengthOfBoard());
		System.out.println("Width of Board: " + sal.getWidthOfBoard());
		System.out.println("Number of Snakes: " + sal.getNumSnakes());
		System.out.println("Number of Ladders: " + sal.getNumLadders());
		System.out.println("");

		int dice = BoardGames.rollDice();
		System.out.println("Turn number " + sal.getTurns());
		System.out.println("Player " + sal.getCurrentPlayer() + " has rolled a " + dice + "!");

		while (!sal.moveAndCheck(dice)) {
			sal.displayBoard();
			sal.iterateTurns();
			dice = BoardGames.rollDice();
			System.out.println("Turn number " + sal.getTurns());
			System.out.println("Player " + sal.getCurrentPlayer() + " has rolled a " + dice + "!");
		}
		System.out.println("Player number " + sal.getCurrentPlayer() + " has won!");

	}
}
