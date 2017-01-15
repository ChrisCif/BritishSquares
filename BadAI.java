
public class BadAI extends BasicPlayer{
	
	/**
	 * ~Constructor~
	 * 
	 * @param team		this player's pawn ('X' or 'O')
	 */
	public BadAI(char team){
		super(team);
	}
	
	/**
	 * Checks every space on the board from top left to bottom right and returns the first available
	 * space encountered
	 * 
	 * @param myBoard		board from which a space is chosen
	 * 
	 * @return		first available space encountered
	 */
	public int choose(Board myBoard){
		int x = 0-1;
		
		try{
			
			for(int r = 0; r < myBoard.size(); r++){
				for(int c = 0; c < myBoard.size(); c++){
					x++;
					if(myBoard.check(r, c, getPawn())){
						return x;
					}
				}
			}
			
		}
		catch(InvalidBoardException e){
			System.out.println(e.getMessage());
		}
		
		return -1;
		
	}

}
