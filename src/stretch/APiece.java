package stretch;

import java.util.ArrayList;

public class APiece implements Piece {

	private Board board;
	private ArrayList<Square> s;
	
	public APiece(Board b) {
		board = b;
	}
	
	@Override
	public ArrayList<Square> getSquaresPlaceLeft(int n) {
		int x, y;
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(new Square(board.getSquareByID(n)));
		x = squares.get(0).getX();
		y = squares.get(0).getY();
		squares.add(new Square(board.getSquareByCoords(x+1, y)));
		squares.add(new Square(board.getSquareByCoords(x+2, y)));
		squares.get(0).toggleHole();
		squares.get(2).toggleHole();
		s = squares;
		return squares;
	}

	@Override
	public ArrayList<Square> getSquaresPlaceRight(int n) {
		int x, y;
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(new Square(board.getSquareByID(n)));
		x = squares.get(0).getX();
		y = squares.get(0).getY();
		squares.add(new Square(board.getSquareByCoords(x-1, y)));
		squares.add(new Square(board.getSquareByCoords(x-2, y)));
		squares.get(0).toggleHole();
		squares.get(2).toggleHole();
		s = squares;
		return squares;
	}

	@Override
	public boolean isValid() {
		for(Square t:s) {
			if(t.isBlocked() || t.getLetter()!=null) return false;
		}
		return true;
	}

	@Override
	public String getLetter() {
		return "A";
	}

}
