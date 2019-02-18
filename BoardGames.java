package lesson2;

/** This class represents a generic board game
 * @author Feng, Michael
 *
 */
public class BoardGames {
	// instance Variables
	private String gameName;
	private int numOfPieces;// Number of pieces
	protected int pieces[][];// For each piece, x and y coords.
	private int lengthOfBoard;// Number of positions on the y axis
	private int widthOfBoard;// Number of positions on the x axis
	protected int[][] board;// The full board. -1 means empty. any other number means the piece number(FOR							// DISPLAY)
	private int turns; //number of turns

	/** Constructor - sets passed values for gameName, lengthOfBoard, widthOfBoard, and numOfPieces, sets default values for the other instance variables
	 * @param name - gameName of the board game
	 * @param length - length of the board
	 * @param width - width of the board
	 * @param numPieces - number of pieces in the board game
	 */
	public BoardGames(String name, int length, int width, int numPieces) {
		gameName = name;
		lengthOfBoard = length;
		widthOfBoard = width;
		board = new int[widthOfBoard][lengthOfBoard];
		for (int i = 0; i < widthOfBoard; i++)
			for (int j = 0; j < lengthOfBoard; j++)
				board[i][j] = -1;
		numOfPieces = numPieces;
		pieces = new int[numOfPieces][2];
		turns = 0;
	}

	/** Places a piece in a certain location on the board
	 * @param pieceNumber - the number value of the piece
	 * @param x - x location
	 * @param y - y location
	 * @return if it was placed successfully
	 */
	public boolean setPiece(int pieceNumber, int x, int y) {
		if (board[x][y] == -1 && x >= 0 && x < widthOfBoard && y >= 0 && y < lengthOfBoard) {
			pieces[pieceNumber][0] = x;
			pieces[pieceNumber][1] = y;
			return true;
		}
		return false;
	}

	/** Returns the name of the game
	 * @return the name of the game
	 */
	public String getName() {
		return gameName;
	}

	/** Returns the number of pieces
	 * @return the number of pieces
	 */
	public int getNumOfPieces() {
		return numOfPieces;
	}

	/** Increases the number of turns by 1
	 * 
	 */
	public void iterateTurns() {
		turns++;
	}

	/** Returns the number of turns
	 * @return the number of turns
	 */
	public int getTurns() {
		return turns;
	}

	/** Returns the width of the board
	 * @return the width of the board
	 */
	public int getWidthOfBoard() {
		return widthOfBoard;
	}

	/** Returns the height of the board
	 * @return the height of the board
	 */
	public int getHeightOfBoard() {
		return lengthOfBoard;
	}

	/** Prints an array to display the board
	 * 
	 */
	public void displayBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
}
