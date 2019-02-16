public class SnakesAndLadders extends BoardGames{
  int[][] snakes;
  int[][] ladders;
  int numSnakes;
  int numLadders;
  int currentPlayer;
  
  public SnakesAndLadders(int numOfPlayers, int numSnakes, int numLadders){
    super("Snakes and Ladders", 10, 10, numOfPlayers);
    this.numSnakes = numSnakes;
    this.numLadders = numLadders;
    snakes = new int[numSnakes][4];//0 is start x coord, 1 is  start y coord, 2 is end x coord, 3 is end y coord
    ladders = new int[numLadders][4];//0 is start x coord, 1 is  start y coord, 2 is end x coord, 3 is end y coord
  }

  public int rollDice(){
    return (int)(Math.random()*5+1);
  }
  
  public boolean generateSnake(int snakeNum, int startX, int startY, int endX, int endY){//snakeNum is zero indexed
    if(snakeNum<numSnakes && snakeNum>=0)
      if(startX<10 && startX>=0)
        if(startY<10 && startY>=0)
          if(endX<10 && endX>=0)
            if(endY<10 && endY>=0){
              snakes[snakeNum][0] = startX;
              snakes[snakeNum][1] = startY;
              snakes[snakeNum][2] = endX;
              snakes[snakeNum][3] = endY;
            }
  }
  
    public boolean generateLadder(int ladderNum, int startX, int startY, int endX, int endY){//ladderNum is zero indexed
    if(ladderNum<numLadders && ladderNum>=0)
      if(startX<10 && startX>=0)
        if(startY<10 && startY>=0)
          if(endX<10 && endX>=0)
            if(endY<10 && endY>=0){
              ladder[ladderNum][0] = startX;
              ladder[ladderNum][1] = startY;
              ladder[ladderNum][2] = endX;
              ladder[ladderNum][3] = endY;
            }
  }
  
  private void moveOnce(){
    if((piece[currentPlayer][0]==0||piece[currentPlayer][0]==9)&& piece[currentPlayer][1]!=0)//If at the edge of the board and not the first piece
      piece[currentPlayer][1]++;//Move up the y
    else if(piece[currentPlayer][1]%2==0)//If the y is even, move x to the right
      piece[currentPlayer][0]++;//Move up the x
    else
      piece[currentPlayer][0]--;//Move down the y
  }
  
  public boolean move(int numOfMoves){//returns true if the moving player has won
    for(int i = 0; i < numOfMoves; i++){
      moveOnce();
      if(piece[currentPlayer][1]==9 && piece[currentPlayer][0]==0)//when at the top row and first column
        return true;//player has won
    }
  }
}
