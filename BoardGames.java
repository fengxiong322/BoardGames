public class BoardGames{
  //Variables
  private String name;
  private int numOfPieces;//Number of pieces
  protected int pieces[][];//For each piece, x and y coords.
  private int heightOfBoard;//Number of positions on the y axis
  private int widthOfBoard;//Number of positions on the x axis
  protected int[][] board;//The full board. -1 means empty. any other number means the piece number(FOR DISPLAY)
  private int turns;

  public BoardGames(String name, int heightOfBoard, int widthOfBoard, int numOfPieces){
    this.name = name;
    this.heightOfBoard = heightOfBoard;
    this.widthOfBoard = widthOfBoard;
    board = new int[widthOfBoard][heightOfBoard];
    for(int i =0 ; i < widthOfBoard; i++)
      for(int j = 0; j < heightOfBoard;j++)
        board[i][j] = -1;
    this.numOfPieces = numOfPieces;
    pieces = new int[numOfPieces][2];
    turns = 0;
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

  public int getTurns(){
    return turns;
  }

  public int getWidth(){
  	return widthOfBoard;
  }

  public int getHeight(){
  	return heightOfBoard;
  }
  
  public void displayBoard(){
    for(int i = 0; i<10; i++){
      for(int j = 0; j<10; j++)
        System.out.print(sal.board[i][j] + " ");
      System.out.println();
    }
  }
}
