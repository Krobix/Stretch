package stretch;

import java.util.ArrayList;

public interface Piece {
	
	public ArrayList<Square> getSquaresPlaceLeft(int n);
	
	public ArrayList<Square> getSquaresPlaceRight(int n);
	
	public boolean isValid();
	
	public String getLetter();
	
}
