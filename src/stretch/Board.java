package stretch;

import java.util.*;

public class Board {
	
	private ArrayList<Square> squares;
	private ArrayList<Piece> pieces;
	private int length, height;
	private boolean leftToRight;
	private String letters = "";
	private String currentLetter = "A";
	
	public Board(int l, int h) {
		length = l;
		height = h;
		squares = new ArrayList<Square>();
		pieces = new ArrayList<Piece>();
	}
	
	public void createGrid(int[] blocked) {
		int id=1;
		for (int i=0; i<height; i++) {
			for(int j=0; j<length; j++) {
				Square s = new Square(id, j, i);
				squares.add(s);
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
		if(currentLetter=="A") currentLetter="B";
		else if(currentLetter=="B") currentLetter="C";
		else if(currentLetter=="C") return null;
		return currentLetter;
	}
	
	public void stretch(int s) {
		Square start = getSquareByID(s);
		if(!(start.getX()==0 || start.getX()==length-1)) {
			System.out.println("Square needs to be either on the far left or far right side");
			System.exit(1);
		}
		if(start.getX()==0) leftToRight=true;
		else leftToRight = false;
	}

}
