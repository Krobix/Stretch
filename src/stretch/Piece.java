package stretch;

import java.util.*;

public abstract class Piece {
	
	protected Board board;
	protected ArrayList<Square> s;
	
	public Piece(Board b) {
		board = b;
	}
	
	public abstract ArrayList<Square> getSquaresPlaceLeft(int n);
	
	public abstract ArrayList<Square> getSquaresPlaceRight(int n);
	
	public abstract String getLetter();
	
	public boolean isValid() {
		for(Square t:s) {
			if(t.isBlocked() || t.getLetter()!=null) return false;
		}
		return true;
	}
}
