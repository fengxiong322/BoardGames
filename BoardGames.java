
public class BoardGames(){
  //Variables
  private String name;
  private int numOfPieces;//Number of pieces
  private String pieces[][];//For each piece, x and y coords.
  private int heightOfBoard;//Number of positions on the y axis
  private int widthOfBoard;//Number of positions on the x axis
  private int[][] board;//The full board. -1 means empty. any other number means the piece number
  private int turns;

  public BoardGames(String name, int heightOfBoard, int widthOfBoard, int numOfPieces){
    this.name = name;
    this.heightOfBoard = heightOfBoard;
    this.widthOfBoard = widthOfBoard;
    board = new int[widthOfBoard][heightOfBoard];
    this.numOfPieces = numOfPieces;
    pieces = new int[numOfPieces][2];
  }
  
  public boolean setPiece(int pieceNumber, int x, int y){
  	if(board[x][y]==-1 && x>=0 && x<widthOfBoard && y>=0 && y<heightOfBoard){
  		pieces[pieceNumber][0] = x;
  		pieces[pieceNumber][1] = y;
  		return true;
  	}
  	return false;
  }

  public String getName(){
  	return name;
  }

  public int getNumOfPieces(){
  	return numOfPieces;
  }

  public void iterateTurns(){
  	turns++;
  }

  public int getWidth(){
  	return widthOfBoard;
  }

  public int getHeight(){
  	return heightOfBoard;
  }
}
