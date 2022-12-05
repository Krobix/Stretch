package stretch;

import java.util.ArrayList;

public class APiece extends Piece {
	
	public APiece(Board b) {
		super(b);
	}
	
	@Override
	public ArrayList<Square> getSquaresPlaceLeft(int n) {
		int x, y;
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(new Square(board.getSquareByID(n)));
		x = squares.get(0).getX();
		y = squares.get(0).getY();
		squares.add(board.getSquareByCoords(x+1, y));
		squares.add(board.getSquareByCoords(x+2, y));
		for (int i=0; i<squares.size(); i++) {
			if(squares.get(i)!=null) squares.set(i, new Square(squares.get(i)));
		}
		if(squares.get(0)!=null) squares.get(0).toggleHole();
		if(squares.get(2)!=null) squares.get(2).toggleHole();
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
		squares.add(board.getSquareByCoords(x-1, y));
		squares.add(board.getSquareByCoords(x-2, y));
		for (int i=0; i<squares.size(); i++) {
			if(squares.get(i)!=null) squares.set(i, new Square(squares.get(i)));
		}
		if(squares.get(0)!=null) squares.get(0).toggleHole();
		if(squares.get(2)!=null) squares.get(2).toggleHole();
		//System.out.println("[DEBUG] squares.get(0) = X:" + squares.get(0).getX() + " Y:" + squares.get(0).getY());
		s = squares;
		return squares;
	}

	@Override
	public String getLetter() {
		return "A";
	}

}
