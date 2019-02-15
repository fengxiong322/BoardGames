
public class BoardGames(){
  //Variables
  private String name;
  private int numOfPieces;//Number of pieces
  private String pieces[][];//For each piece, x and y coords.
  private int heightOfBoard;//Number of positions on the y axis
  private int widthOfBoard;//Number of positions on the x axis
  private int[][] board;//The full board
  public BoardGames(String name, int heightOfBoard, int widthOfBoard,){
    this.name = name;
    this.heightOfBoard = heightOfBoard;
    this.widthOfBoard = widthOfBoard;
    board = new int[widthOfBoard][heightOfBoard];
    
  }
  
  public void setPiece
}
