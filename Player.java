
public interface Player {
	
	public void place(int space, Board myBoard);
	public int choose(Board myBoard);
	public boolean canPlace(Board myBoard);
	public char getPawn();

}
