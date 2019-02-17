public class SnakesAndLadders extends BoardGames{
  int[][] snakes;
  int[][] ladders;
  int numSnakes;
  int numLadders;
  int currentPlayer;
  
  public SnakesAndLadders(int numOfPlayers, int numSnakes, int numLadders){
    super("Snakes and Ladders", 10, 10, numOfPlayers);//Creates a ten by ten board
    this.numSnakes = numSnakes;
    this.numLadders = numLadders;
    snakes = new int[numSnakes][4];//0 is start x coord, 1 is  start y coord, 2 is end x coord, 3 is end y coord
    for(int i = 0; i < numSnakes; i++){
      for(int j =0; j<4;j++)
        snakes[i][j] = 0;
    }
    ladders = new int[numLadders][4];//0 is start x coord, 1 is  start y coord, 2 is end x coord, 3 is end y coord
    for(int i = 0; i < numLadders; i++){
      for(int j =0; j<4;j++)
        ladders[i][j] = 0;
    }
    currentPlayer = 0;
  }

  public static int rollDice(){//doesnt change any object variables, and is consistant through all instances of this class
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
              return true;
            }
    return false;
  }
  
  public boolean generateLadder(int ladderNum, int startX, int startY, int endX, int endY){//ladderNum is zero indexed
    if(ladderNum<numLadders && ladderNum>=0)
      if(startX<10 && startX>=0)
        if(startY<10 && startY>=0)
          if(endX<10 && endX>=0)
            if(endY<10 && endY>=0){
              ladders[ladderNum][0] = startX;
              ladders[ladderNum][1] = startY;
              ladders[ladderNum][2] = endX;
              ladders[ladderNum][3] = endY;
              return true;
            }
    return false;
  }
  
  public int getCurrentPlayer(){
    return currentPlayer;
  }

  private void moveOnce(){
    if(pieces[currentPlayer][1]%2==0){
      if(pieces[currentPlayer][0]==9)
        pieces[currentPlayer][1]++;//Move up the y
      else
        pieces[currentPlayer][0]++;//Move up the x
    }else{
      if(pieces[currentPlayer][0]==0 && pieces[currentPlayer][1]!=0)
        pieces[currentPlayer][1]++;//Move up the y
      else
        pieces[currentPlayer][0]--;//Move down the x
    }
  }
  
  public boolean move(int numOfMoves){//returns true if the moving player has won
    board[pieces[currentPlayer][0]][pieces[currentPlayer][1]] = -1;
    for(int i = 0; i < numOfMoves; i++){
      moveOnce();
      if(pieces[currentPlayer][1]==9 && pieces[currentPlayer][0]==0)//when at the top row and first column
        return true;//player has won
    }
    int currentSnake = checkSnake();
    if(currentSnake != -1){
      pieces[currentPlayer][0] = snakes[currentSnake][2];
      pieces[currentPlayer][1] = snakes[currentSnake][3];
    }
    int currentLadder = checkLadder();
    if(currentLadder != -1){
      pieces[currentPlayer][0] = ladders[currentLadder][2];
      pieces[currentPlayer][1] = ladders[currentLadder][3];
    }
    board[pieces[currentPlayer][0]][pieces[currentPlayer][1]] = currentPlayer;
    if(currentPlayer == getNumOfPieces()-1)
      currentPlayer=0;
    else
      currentPlayer++;
    return false;
  }

  public int checkSnake(){//returns the snake number, or -1 if there is no such snake
    for(int i = 0; i < numSnakes; i++)
      if(snakes[i][0] == pieces[currentPlayer][0] && snakes[i][1] == pieces[currentPlayer][1])
        return i;
    return -1;
  }

  public int checkLadder(){//returns the ladder number, or -1 if there is no such ladder
    for(int i = 0; i < numLadders; i++)
      if(ladders[i][0] == pieces[currentPlayer][0] && ladders[i][1] == pieces[currentPlayer][1])
        return i;
    return -1;
  }
