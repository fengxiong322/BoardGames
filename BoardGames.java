
package lesson2;

/**
 * This class represents a generic board game
 * @author Feng, Michael
 *
 */
public class BoardGames {
	// instance Variables
	private String gameName;
	private int numOfPieces;// Number of pieces
	private int pieces[][];// For each piece, x and y coords.
	private int lengthOfBoard;// Number of positions on the y axis
	private int widthOfBoard;// Number of positions on the x axis
	private int[][] board;// The full board. -1 means empty. any other number means the piece number
	private int turns; // number of turns
	private int currentPlayer;

	/**
	 * Constructor - sets passed values for gameName, lengthOfBoard, widthOfBoard,
	 * and numOfPieces, sets default values for the other instance variables
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
		currentPlayer = 0;
	}

	/**
	 * Constructor - sets passed values for gameName, lengthOfBoard, widthOfBoard,
	 * sets default values for the other instance variables
	 * @param name - gameName of the board game
	 * @param length - length of the board
	 * @param width - width of the board
	 */
	public BoardGames(String name, int length, int width) {
		gameName = name;
		lengthOfBoard = length;
		widthOfBoard = width;
		board = new int[widthOfBoard][lengthOfBoard];
		for (int i = 0; i < widthOfBoard; i++)
			for (int j = 0; j < lengthOfBoard; j++)
				board[i][j] = -1;
		numOfPieces = 0;
		pieces = new int[numOfPieces][2];
		turns = 0;
		currentPlayer = 0;
	}

	/**
	 * Places a piece in a certain location on the board
	 * @param pieceNumber - the number value of the piece
	 * @param x - x location
	 * @param y - y location
	 * @return if it was placed successfully
	 */
	public boolean setPiece(int pieceNumber, int x, int y) {
		if (x >= 0 && x < widthOfBoard && y >= 0 && y < lengthOfBoard) {
			pieces[pieceNumber][0] = x;
			pieces[pieceNumber][1] = y;
			return true;
		}
		return false;
	}

	/**
	 * Returns the value of the current player
	 * @return the current player
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Gets the xPos of the piece
	 * @param pieceNumber - the number value of the piece
	 * @return The x value
	 */
	public int getPieceX(int pieceNumber) {
		return pieces[pieceNumber][0];
	}

	/**
	 * Gets the yPos of the piece
	 * @param pieceNumber - the number value of the piece
	 * @return The y value
	 */
	public int getPieceY(int pieceNumber) {
		return pieces[pieceNumber][1];
	}

	/**
	 * Returns the value of the specified position
	 * @param x - x location
	 * @param y - y location
	 */
	public void setBoard(int x, int y, int val) {
		board[x][y] = val;
	}

	/**
	 * Returns the value of the specified position
	 * @param x - x location
	 * @param y - y location
	 * @return the value of the specified position
	 */
	public int getBoard(int x, int y) {
		return board[x][y];
	}

	/**
	 * Returns the name of the game
	 * @return the name of the game
	 */
	public String getName() {
		return gameName;
	}

	/**
	 * Returns the number of pieces
	 * @return the number of pieces
	 */
	public int getNumOfPieces() {
		return numOfPieces;
	}

	/**
	 * Increases the number of turns by 1
	 */
	public void iterateTurns() {
		turns++;
	}

	/**
	 * Returns the number of turns
	 * @return the number of turns
	 */
	public int getTurns() {
		return turns;
	}

	/**
	 * Returns the width of the board
	 * @return the width of the board
	 */
	public int getWidthOfBoard() {
		return widthOfBoard;
	}

	/**
	 * Returns the height of the board
	 * @return the height of the board
	 */
	public int getLengthOfBoard() {
		return lengthOfBoard;
	}

	/**
	 * Prints an array to display the board Since the board is positioned
	 */
	public void displayBoard() {
                for (int j = 9; j >=0; j--){
                        for (int i = 0; i <10; i++)
                                System.out.print(board[i][j] + " ");
                        System.out.println();
                }
	}

	/**
	 * Sets the number of pieces
	 * @param number of pieces to be set
	 */
	public void setNumOfPieces(int pieces) {
		numOfPieces = pieces;
	}

	/**
	 * @param newPlayer the new current player
	 */
	public void setCurrentPlayer(int newPlayer) {
		currentPlayer = newPlayer;
	}

	
	/**
	 * 
	 */
	public void nextPlayer() {
		currentPlayer++;
	}

	/**
	 * Returns a random value between 1 to 6
	 * @return a a random value between 1 to 6
	 */
	public static int rollDice() {
		return (int) (Math.random() * 6 + 1);
	}
}
