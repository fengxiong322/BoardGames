public class SnakesAndLadders extends BoardGames{
  int[][] snakes;
  int[][] ladders;
  int currentPlayer;
  
  public SnakesAndLadders(int numOfPlayers, int numSnakes, int numLadders){
    super("Snakes and Ladders", 10, 10, numOfPlayers);
    snakes = new int[numSnakes][2];//0 is x coord, 1 is y coord
    ladders = new int[numLadders][2];//0 is x coord, 1 is y coord
  }

  private int rollDice(){
    return (int)(Math.random()*5+1);
  }
  
  public void moveOnce(){
    
  }
}
