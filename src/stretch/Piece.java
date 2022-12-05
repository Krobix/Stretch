package stretch;

import java.util.*;

public abstract class Piece {
	
	protected Board board;
	protected ArrayList<Square> s;
	
	public Piece(Board b) {
		//System.out.println("[DEBUG] New piece");
		board = b;
	}
	
	public abstract ArrayList<Square> getSquaresPlaceLeft(int n);
	
	public abstract ArrayList<Square> getSquaresPlaceRight(int n);
	
	public String getLetter() {
		return " ";
	}
	
	public ArrayList<Square> getSquares(){
		return s;
	}
	
	public boolean isValid() {
		for(Square t:s) {
			if(t==null || t.isBlocked() || t.getLetter()!=null) return false;
		}
		return true;
	}
}
