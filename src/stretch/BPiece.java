package stretch;

import java.util.ArrayList;

public class BPiece extends Piece {
	
	public BPiece(Board b) {
		super(b);
	}
	
	@Override
	public ArrayList<Square> getSquaresPlaceLeft(int n) {
		int x, y;
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(new Square(super.board.getSquareByID(n)));
		x = squares.get(0).getX();
		y = squares.get(0).getY();
		squares.add(new Square(super.board.getSquareByCoords(x, y+1)));
		squares.add(new Square(super.board.getSquareByCoords(x+1, y+1)));
		squares.get(0).toggleHole();
		squares.get(2).toggleHole();
		super.s = squares;
		return squares;
	}

	@Override
	public ArrayList<Square> getSquaresPlaceRight(int n) {
		int x, y;
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(new Square(super.board.getSquareByID(n)));
		x = squares.get(0).getX();
		y = squares.get(0).getY();
		squares.add(new Square(super.board.getSquareByCoords(x-1, y)));
		squares.add(new Square(super.board.getSquareByCoords(x-1, y-1)));
		squares.get(0).toggleHole();
		squares.get(2).toggleHole();
		super.s = squares;
		return squares;
	}
	
	@Override
	public String getLetter() {
		return "B";
	}

}
