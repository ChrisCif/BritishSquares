
public class BritishSquare {
	
	public static void main(String[] args){
		
		Board myBoard = new Board();
		
		//  If not running on command line
		//  BasicPlayer x = new Human('X');
		//  BasicPlayer o = new GoodAI('O');
		BasicPlayer x;
		BasicPlayer o;
		
		if(args == null){
			errorOutput();
			return;
		}
		else if(args[0].equalsIgnoreCase("human")){
			x = new Human('X');
		}
		else if(args[0].equalsIgnoreCase("random")){
			x = new RandomAI('X');
		}
		else if(args[0].equalsIgnoreCase("good")){
			x = new GoodAI('X');
		}
		else if(args[0].equalsIgnoreCase("bad")){
			x = new BadAI('X');
		}
		else{
			errorOutput();
			return;
		}
		
		if(args.length < 2){
			errorOutput();
			return;
		}
		else if(args[1].equalsIgnoreCase("human")){
			o = new Human('O');
		}
		else if(args[1].equalsIgnoreCase("random")){
			o = new RandomAI('O');
		}
		else if(args[1].equalsIgnoreCase("good")){
			o = new GoodAI('O');
		}
		else if(args[1].equalsIgnoreCase("bad")){
			o = new BadAI('O');
		}
		else{
			errorOutput();
			return;
		}
		
		
		if(args.length > 2){
			if(Integer.parseInt(args[2]) <= 7  &&  Integer.parseInt(args[2]) >= 3){
				try{
					myBoard = new Board(Integer.parseInt(args[2]));	
				}
				catch(InvalidBoardException e){
					System.out.println(e.getMessage());
					return;
				}	
			}
			else{
				errorOutput();
				return;
			}
			
		}
		else{
			myBoard = new Board();
		}
		
		play(x, o, myBoard);
		
	}
	
	public static void play(BasicPlayer x, BasicPlayer o, Board myBoard){
		int playerChoice = 0;
		boolean gameOver = false;
		int playerIndex = 0;
		BasicPlayer currentPlayer = x;
		
		myBoard.print();
		while(!gameOver){
			
			if(playerIndex % 2 == 0){
				currentPlayer = x;
			}
			else{
				currentPlayer = o;
			}
			
			if(currentPlayer.canPlace(myBoard)){

				System.out.println(playerIndex);
				playerChoice = currentPlayer.choose(myBoard);
				
				if(playerChoice < 0){
					break;	
				}
				
				while(playerChoice == ( (myBoard.size()*(myBoard.size()/2)) + myBoard.size()/2 ) &&  playerIndex == 0  &&  myBoard.size()%2 != 0){
					System.out.println("Cannot place on the middle space at the start of a game.");
					playerChoice = currentPlayer.choose(myBoard);
				}
				
				currentPlayer.place(playerChoice, myBoard);
				System.out.println("Player places an "+currentPlayer.getPawn()+" piece at location: "+playerChoice);				
				myBoard.print();
			}
			else{
				if(!(x.canPlace(myBoard)  ||  o.canPlace(myBoard))){
					gameOver = true;
				}
				else{
					System.out.println(currentPlayer.getPawn()+" had no more moves and must skip a turn.");
				}
			}
			
			playerIndex++;
		}
		
		if(playerChoice < 0){
			System.out.println(currentPlayer.getPawn()+" quits the game");
		}
		else if(gameOver){
			System.out.println("No more legal moves available, the game is over");
			System.out.println("Final Score: X = "+x.getScore()+" : O = "+o.getScore());
			
			if(x.getScore() > o.getScore()){
				System.out.println("Player X won");
			}
			else if(x.getScore() < o.getScore()){
				System.out.println("Player O won");
			}
			else{
				System.out.println("Its a tie, no one wins.");
			}
			
		}
		
	}
	
	public static void errorOutput(){
		System.err.println("Usage: java BritishSquare player-X player-O [brdSize]"+"\n"+
							"where player-X and player-O are one of: human, bad, good, random"+"\n"+
							"[brdSize] is optional, if provided it must be in the range from: 3 to 7");
	}

}
