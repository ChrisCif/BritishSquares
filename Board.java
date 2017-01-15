
public class Board {
	/**
	 * The spaces of the board represented in a 2D array
	 */
	private char[][] spaces;
	
	/**
	 * The size of the board (size x size)
	 */
	private int size;
	
	/**
	 * ~Constructors~
	 * 
	 * Initializes the spaces array based on dimension provided
	 * 
	 * @param	int dimensions - height & width of board
	 * 
	 * @throws InvalidBoardException	Exception thrown if dimensions of the board are not between 3x3 an 7x7 
	 * 
	 */
	public Board(){
		size = 5;
		spaces = new char[size][size];
	}
	public Board(int dimensions) throws InvalidBoardException{
		if(dimensions < 3 || dimensions > 7)
			throw new InvalidBoardException("InvalidBoardException: board size must be between 3x3 and 7x7"+"\nUser entered: "+dimensions);
		
		size = dimensions;
		spaces = new char[size][size];
	}
	
	/**
	 * Checks if space on board is available to be placed onto
	 * 
	 * @param space		space to be checked
	 * @param pawn		the pawn to be placed on the checked space
	 * 
	 * @return		returns true if space is available
	 * 
	 * @throws InvalidBoardException	exception thrown if the space to be checked is out of bounds
	 */
	public boolean check(int space, char pawn) throws InvalidBoardException{
		
		if(space > (size*size)-1  ||  space < -1)
			throw new InvalidBoardException("InvalidBoardException: space "+space+" is out of bounds");

		int myY = space / size;
		int myX = space % size;
		
		char enemy = 'O';
		if(pawn == 'O')
			enemy = 'X';
		
		if(spaces[myY][myX] == enemy  ||  spaces[myY][myX] == pawn)
			return false;
		
		if(myY-1 >= 0){
			if(spaces[myY-1][myX] == enemy)
				return false;	
		}
		
		if(myY+1 < size){
			if(spaces[myY+1][myX] == enemy)
				return false;	
		}
		
		if(myX-1 >= 0){
			if(spaces[myY][myX-1] == enemy)
				return false;	
		}
		
		if(myX+1 < size){
			if(spaces[myY][myX+1] == enemy)
				return false;	
		}
		
		return true;
		
	}
	public boolean check(int row, int column, char pawn) throws InvalidBoardException{
		return check((size*row)+column, pawn);
	}
	
	/**
	 * Places a player's pawn on this space by resetting that space's value
	 * 
	 * @param space		space to receive pawn
	 * @param team		pawn to be placed
	 */
	public void setSpace(int space, char team){
		spaces[space / size][space % size] = team;
	}
	
	/**
	 * Returns the size of the board (size x size)
	 * 
	 * @return		size of the board
	 */
	public int size(){
		return size;
	}
	
	public void setSize(int newSize) throws InvalidBoardException{
		if(newSize < 3 || newSize > 7){
			throw new InvalidBoardException("InvalidBoardException: board size must be between 3x3 and 7x7"+"\nUser entered: "+newSize);	
		}
		else{
			size = newSize;
		}
		
	}
	
	/**
	 * Prints the board to the console
	 */
	public void print(){
		System.out.println();
		
		for(int r = 0; r < size; r++){
			
			for(int x = 0; x < size; x++){
				System.out.print("+---");
			}
			System.out.println("+");
			
			
			for(int x = 0; x < 2; x++){
				
				for(int c = 0; c < size; c++){
					System.out.print("|");
					if(spaces[r][c] == 'X'  ||  spaces[r][c] == 'O'){
						System.out.print(""+spaces[r][c] + spaces[r][c] + spaces[r][c]);
					}
					else{
						if(x > 0){
							int spaceNum = (size*r)+c;
							System.out.print(spaceNum);
							for(int space = 0; space < 3 - String.valueOf(spaceNum).length(); space++){
								System.out.print(" ");
							}
						}
						else{
							System.out.print("   ");
						}
					}
				}
				System.out.println("|");
				
			}
			
		}
		
		for(int x = 0; x < size; x++){
			System.out.print("+---");
		}
		System.out.println("+");
		
		
		System.out.println();
	}
	
	
}
