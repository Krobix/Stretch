package stretch;

public class Square {
	
	private int id, x, y;
	private String letter;
	private boolean blocked, hole;
	
	public Square(int a, int b, int c) {
		id = a;
		x = b;
		y = c;
		letter = " ";
		blocked = false;
		hole = false;
	}
	
	public Square(Square other) {
		id = other.getID();
		x = other.getX();
		y = other.getY();
		letter = other.getLetter();
		blocked = other.isBlocked();
		hole = other.isHole();
	}
	
	public void setLetter(String l) {
		letter = l;
	}
	
	public void toggleBlocked() {
		blocked = !blocked;
		if(blocked) letter = "#";
		else letter = " ";
	}
	
	public boolean isBlocked() {
		return blocked;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public void toggleHole() {
		hole = !hole;
	}
	
	public boolean isHole() {
		return hole;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getID() {
		return id;
	}
	
}
