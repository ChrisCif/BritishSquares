import java.util.Random;

public class RandomAI extends BasicPlayer{
	/**
	 * Random number generator
	 */
	Random rando = new Random();
	
	/**
	 * ~Constructor~
	 * 
	 * @param team		this player's pawn ('X' or 'O')
	 * 
	 */
	public RandomAI(char team){
		super(team);
	}
	
	/**
	 * Keeps checking random spaces until an available space is found. Returns said space  
	 * 
	 * @param myBoard		board from which a space is chosen
	 * @return		first available space found
	 */
	public int choose(Board myBoard){
		int choice = rando.nextInt(myBoard.size()*myBoard.size());
		try{
		
			while(!myBoard.check(choice, getPawn())){
				choice = rando.nextInt(myBoard.size()*myBoard.size());
			}
			
		}
		catch(InvalidBoardException e){
			System.out.println(e.getMessage());
		}
		
		
		return choice;
	}

}
