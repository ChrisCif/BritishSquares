
public class GoodAI extends BasicPlayer{
	
	/**
	 * ~Constructor~
	 * 
	 * @param team		this player's pawn
	 */
	public GoodAI(char team){
		super(team);
	}
	
	/**
	 * Chooses the first "best" space to place a piece upon. A "best" space is defined a space that has an optimal
	 * amount of available adjacent spaces
	 * 
	 *  @param myBoard		the board from which a space will be chosen
	 */
	public int choose(Board myBoard){
		
		for(int goal = 5; goal > 0; goal--){
			
			for(int r = 0; r < myBoard.size(); r++){
				for(int c = 0; c < myBoard.size(); c++){
					try{
						if(myBoard.check(r, c, getPawn())){
							int optimalCount = 0;
							
							try{
								if(myBoard.check(r, c, getPawn()))
									optimalCount++;	
							}
							catch(InvalidBoardException e){
								System.out.println(e.getMessage());
							}
							
							if(r-1 > 0){
								try{
									if(myBoard.check(r-1, c, getPawn()))
										optimalCount++;	
								}
								catch(InvalidBoardException e){
									System.out.println(e.getMessage());
								}	
							}
							
							if(r+1 < myBoard.size()){
								try{
									if(myBoard.check(r+1, c, getPawn()))
										optimalCount++;	
								}
								catch(InvalidBoardException e){
									System.out.println(e.getMessage());
								}	
							}
							
							if(c-1 > 0){
								try{
									if(myBoard.check(r, c-1, getPawn()))
										optimalCount++;	
								}
								catch(InvalidBoardException e){
									System.out.println(e.getMessage());
								}	
							}
							
							if(c+1 < myBoard.size()){
								try{
									if(myBoard.check(r, c+1, getPawn()))
										optimalCount++;	
								}
								catch(InvalidBoardException e){
									System.out.println(e.getMessage());
								}	
							}
							
							
							if(optimalCount == goal){
								if(myBoard.check((myBoard.size()*r)+c, getPawn()))
								return (myBoard.size()*r)+c;
							}
							
						}	
					}
					catch(InvalidBoardException e){
						System.out.println(e.getMessage());
					}
					
				}
			}
			
		}
		
		return -1;
	}
	
}
