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
		squares.add(super.board.getSquareByCoords(x, y+1));
		squares.add(super.board.getSquareByCoords(x+1, y+1));
		for (int i=0; i<squares.size(); i++) {
			if(squares.get(i)!=null) squares.set(i, new Square(squares.get(i)));
		}
		if(squares.get(0)!=null) squares.get(0).toggleHole();
		if(squares.get(2)!=null) squares.get(2).toggleHole();
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
		squares.add(super.board.getSquareByCoords(x-1, y));
		squares.add(super.board.getSquareByCoords(x-1, y-1));
		for (int i=0; i<squares.size(); i++) {
			if(squares.get(i)!=null) squares.set(i, new Square(squares.get(i)));
		}
		if(squares.get(0)!=null) squares.get(0).toggleHole();
		if(squares.get(2)!=null) squares.get(2).toggleHole();
		super.s = squares;
		return squares;
	}
	
	@Override
	public String getLetter() {
		return "B";
	}

}
