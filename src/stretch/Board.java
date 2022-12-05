package stretch;

import java.util.*;

public class Board {
	
	private ArrayList<Square> squares;
	private ArrayList<Piece> pieces;
	private int length, height;
	private boolean leftToRight;
	private String letters = "";
	private String currentLetter = "A";
	private boolean solved = false;
	
	public Board(int l, int h) {
		length = l;
		height = h;
		squares = new ArrayList<Square>();
		pieces = new ArrayList<Piece>();
	}
	
	public void createGrid(int[] blocked) {
		int id=1;
		for (int i=0; i<=height; i++) {
			for(int j=0; j<=length; j++) {
				Square s = new Square(id, j, i);
				squares.add(s);
				System.out.println("[DEBUG] Square ID:" + s.getID() + " X:" + s.getX() + " Y:" + s.getY());
				id++;
			}
		}
		for(int i:blocked) {
			getSquareByID(i).toggleBlocked();
		}
	}
	
	public Square getSquareByCoords(int x, int y) {
		for(Square s:squares) {
			if(s.getX()==x && s.getY()==y) {
				return s;
			}
		}
		return null;
	}
	
	public Square getSquareByID(int id) {
		return squares.get(id-1);
	}
	
	public String nextLetter() {
		if(currentLetter.equals("A")) currentLetter="B";
		else if(currentLetter.equals("B")) currentLetter="C";
		else if(currentLetter.equals("C")) currentLetter="A";
		return currentLetter;
	}
	
	public String getLetters() {
		return letters;
	}
	
	public void printBoard() {
		String topBorder = "";
		for(int i=0; i<length; i++) {
			topBorder += "-----";
		}
		System.out.println(topBorder);
		for(int i=0; i<height; i++) {
			for(int j=0; j<length; j++) {
				System.out.print("| " + getSquareByCoords(j, i).getLetter() + " ");
			}
			System.out.println("|");
		}
		System.out.println(topBorder);
	}
	
	public void stretch(int s) {
		Square start = getSquareByID(s);
		Square lastSquare;
		//System.out.println("[DEBUG] start.getX()=" + start.getX() + " length-1=" + (length-1));
		if(!(start.getX()==0 || start.getX()==length)) {
			System.out.println("Square needs to be either on the far left or far right side");
			System.exit(1);
		}
		if(start.getX()==0) leftToRight=true;
		else leftToRight = false;
		
		if(leftToRight) {
			lastSquare = new Square(-1, -1, 0);
		}
		else {
			lastSquare = new Square(-1, length+1, 0);
		}
		
		while(!solved) {
			Piece piece;
			//Change this code if currentLetter needs to be reset each use
			if(currentLetter=="A") piece = new APiece(this);
			else if(currentLetter=="B") piece = new BPiece(this);
			else piece = new CPiece(this);
			
			if(leftToRight) {
				Square tmp = getSquareByCoords(lastSquare.getX()+1, lastSquare.getY());
				piece.getSquaresPlaceLeft(tmp.getID());
			}
			else {
				Square tmp = getSquareByCoords(lastSquare.getX()-1, lastSquare.getY());
				piece.getSquaresPlaceRight(tmp.getID());
			}
			
			if(piece.isValid()) {
				for(Square i:piece.getSquares()) {
					squares.set(i.getID()-1, i);
					i.setLetter(piece.getLetter());
				}
				pieces.add(piece);
				letters += piece.getLetter();
				lastSquare = piece.getSquares().get(piece.getSquares().size()-1);
				if((lastSquare.getX()==0 || lastSquare.getX()==length-1) && lastSquare.getX()!=start.getX()) solved=true;
				nextLetter();
			}
			else {
				nextLetter();
				continue;
			}
			printBoard();
		}
	}

}
