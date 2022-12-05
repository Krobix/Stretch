package stretch;

public class Stretch {
	
	public static void main(String[] args) {
		int[] blocked = {23, 37};
		String s = runStretch(6, 10, 11, blocked);
		System.out.println(s);
	}
	
	public static String runStretch(int rows, int columns, int start, int[] blocked) {
		Board b = new Board(columns, rows);
		b.createGrid(blocked);
		b.stretch(start);
		return b.getLetters();
	}
}
