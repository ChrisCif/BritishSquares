import java.util.Scanner;

public class Human extends BasicPlayer {
	
	/**
	 * Scanner to check user input
	 */
	private Scanner reader = new Scanner(System.in);
	
	/**
	 * ~Constructor~
	 * 
	 * @param team		this player's pawn ('X' or 'O')
	 * 
	 */
	public Human(char team){
		super(team);
	}

	/**
	 * Asks the user for a space to play onto. Keeps asking until user gives an available space to play on
	 * 
	 * @param myBoard		board from which a space is chosen 
	 * 
	 * @return		user's available choice
	 */
	public int choose(Board myBoard){
		System.out.println("Player "+getPawn()+": Enter the location to place your piece (-1 to quit): ");
		
		int choice = reader.nextInt();
		if(choice == -1)
			return -1;
		
		boolean isLegal = true;
		try{
			isLegal = myBoard.check(choice, getPawn());
		}
		catch(InvalidBoardException e){
			System.out.println(e.getMessage());
		}
		
		
		while(!isLegal){
			System.out.println("Invalid space. Please choose again (-1 to quit): ");
			choice = reader.nextInt();
			
			try{
				isLegal = myBoard.check(choice, getPawn());
			}
			catch(InvalidBoardException e){
				System.out.println(e.getMessage());
			}	
			
		}
		
		
		return choice;
	}
	
}
