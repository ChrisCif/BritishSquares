
public abstract class BasicPlayer implements Player{
	
	/**
	 * This player's pawn('X' or 'O')
	 */
	private char pawn;
	
	/**
	 * This player's score;
	 */
	private int score;
	
	/**
	 * ~Constructor~
	 * 
	 * @param team		this player's pawn ('X' or 'O')
	 * 
	 */
	public BasicPlayer(char team){
		pawn = team;
	}
	
	/**
	 * Checks to see if this player can move during its turn
	 * 
	 * @param myBoard		Board to check for moves
	 * 
	 * @return		true if there are available space(s); false otherwise
	 */
	public boolean canPlace(Board myBoard){
		for(int r = 0; r < myBoard.size(); r++){
			for(int c = 0; c < myBoard.size(); c++){
				
				try{
					if(myBoard.check(r, c, getPawn()))
						return true;	
				}
				catch(InvalidBoardException e){
					System.out.println(e.getMessage());
					return false;
				}
				
			}
		}
		return false;
	}
	
	/**
	 * Place's player's pawn on a space on the board
	 * 
	 * @param space		space to be played upon
	 * @param myBoard	board from which the space is native
	 * 
	 */
	public void place(int space, Board myBoard){
		myBoard.setSpace(space, pawn);
		score++;
	}
	
	/**
	 * Return's the player's pawn
	 * 
	 * @return		this player's pawn
	 */
	public char getPawn(){
		return pawn;
	}
	
	/**
	 * Return's player's score
	 * 
	 * @return	player's score
	 */
	public int getScore(){
		return score;
	}
	
}
