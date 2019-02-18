package lesson2;

/**
 * @author Feng, Michael
 *
 */ 
public class SnakesAndLadders extends BoardGames {
	private int[][] snakes;
	private int[][] ladders;
	private int numSnakes;
	private int numLadders;
	private int currentPlayer;

	/** Constructor - sets values for number of players, number of snakes, and number of ladders
	 * @param players - number of players
	 * @param numOfSnakes - number of snakes
	 * @param numOfLadders - number of ladders
	 */
	public SnakesAndLadders(int players, int numOfSnakes, int numOfLadders) {
		super("Snakes and Ladders", 10, 10, players);// Creates a ten by ten board
		numSnakes = numOfSnakes;
		numLadders = numOfLadders;
		snakes = new int[numSnakes][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
		for (int i = 0; i < numSnakes; i++) {
			for (int j = 0; j < 4; j++)
				snakes[i][j] = 0;
		}
		ladders = new int[numLadders][4];// 0 is start x coord, 1 is start y coord, 2 is end x coord, 3 is end y coord
		for (int i = 0; i < numLadders; i++) {
			for (int j = 0; j < 4; j++)
				ladders[i][j] = 0;
		}
		currentPlayer = 0;
	}

	/** Returns a random value between 1 to 6
	 * @return a  a random value between 1 to 6
	 */
	public static int rollDice() {
		return (int) (Math.random() * 6 + 1);
	}

	/** Creates a certain snake starting at a certain x and y position and ending at a certain x and y position
	 * @param snakeNum - which snake
	 * @param startX - start x cord
	 * @param startY - start y cord
	 * @param endX - end x cord
	 * @param endY - end y cord
	 * @return if the snake was generated successfully
	 */
	public boolean generateSnake(int snakeNum, int startX, int startY, int endX, int endY) {// snakeNum is zero indexed
		if (snakeNum < numSnakes && snakeNum >= 0)
			if (startX < 10 && startX >= 0)
				if (startY < 10 && startY >= 0)
					if (endX < 10 && endX >= 0)
						if (endY < 10 && endY >= 0) {
							snakes[snakeNum][0] = startX;
							snakes[snakeNum][1] = startY;
							snakes[snakeNum][2] = endX;
							snakes[snakeNum][3] = endY;
							return true;
						}
		return false;
	}

	/** Creates a certain ladder starting at a certain x and y position and ending at a certain x and y position
	 * @param ladderNum - which ladder
	 * @param startX - start x cord
	 * @param startY - start y cord
	 * @param endX - end x cord
	 * @param endY - end y cord
	 * @return if the ladder was generated successfully
	 */
	public boolean generateLadder(int ladderNum, int startX, int startY, int endX, int endY) {// ladderNum is zero
																								// indexed
		if (ladderNum < numLadders && ladderNum >= 0)
			if (startX < 10 && startX >= 0)
				if (startY < 10 && startY >= 0)
					if (endX < 10 && endX >= 0)
						if (endY < 10 && endY >= 0) {
							ladders[ladderNum][0] = startX;
							ladders[ladderNum][1] = startY;
							ladders[ladderNum][2] = endX;
							ladders[ladderNum][3] = endY;
							return true;
						}
		return false;
	}

	/** Returns the value of the current player
	 * @return the current player
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/** 
	 *A helper method to move the pieces around the board 
	 */
	private void moveOnce() {
		if (pieces[currentPlayer][1] % 2 == 0) {
			if (pieces[currentPlayer][0] == 9)
				pieces[currentPlayer][1]++;// Move up the y
			else
				pieces[currentPlayer][0]++;// Move up the x
		} else {
			if (pieces[currentPlayer][0] == 0 && pieces[currentPlayer][1] != 0)
				pieces[currentPlayer][1]++;// Move up the y
			else
				pieces[currentPlayer][0]--;// Move down the x
		}
	}

	/** moves the current player, checks if the player won
	 * @param numOfMoves
	 * @return
	 */
	public boolean move(int numOfMoves) {// returns true if the moving player has won
		board[pieces[currentPlayer][0]][pieces[currentPlayer][1]] = -1;
		for (int i = 0; i < numOfMoves; i++) {
			moveOnce();
			if (pieces[currentPlayer][1] == 9 && pieces[currentPlayer][0] == 0)// when at the top row and first column
				return true;// player has won
		}
		int currentSnake = checkSnake();
		if (currentSnake != -1) {
			pieces[currentPlayer][0] = snakes[currentSnake][2];
			pieces[currentPlayer][1] = snakes[currentSnake][3];
		}
		int currentLadder = checkLadder();
		if (currentLadder != -1) {
			pieces[currentPlayer][0] = ladders[currentLadder][2];
			pieces[currentPlayer][1] = ladders[currentLadder][3];
		}
		board[pieces[currentPlayer][0]][pieces[currentPlayer][1]] = currentPlayer;
		if (currentPlayer == getNumOfPieces() - 1)
			currentPlayer = 0;
		else
			currentPlayer++;
		return false;
	}

	/** Returns the snake number, or -1 if there is no such snake
	 * @return the snake number, or -1 if there is no such snake
	 */
	public int checkSnake() {// returns the snake number, or -1 if there is no such snake
		for (int i = 0; i < numSnakes; i++)
			if (snakes[i][0] == pieces[currentPlayer][0] && snakes[i][1] == pieces[currentPlayer][1])
				return i;
		return -1;
	}

	/** Returns the ladder number, or -1 if there is no such ladder
	 * @return the ladder number, or -1 if there is no such laddeR
	 */
	public int checkLadder() {// returns the ladder number, or -1 if there is no such ladder
		for (int i = 0; i < numLadders; i++)
			if (ladders[i][0] == pieces[currentPlayer][0] && ladders[i][1] == pieces[currentPlayer][1])
				return i;
		return -1;
	}
}
