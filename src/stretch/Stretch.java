package stretch;

import java.util.Scanner;

public class Stretch {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter input for Stretch program.");
			stretchFromInput(scn.nextLine());
		}
	}
	
	public static String stretchFromInput(String in) {
		String out;
		int  r, c, s, n;
		int[] b;
		in = in.strip();
		String[] arr = in.split(" ");
		r = Integer.parseInt(arr[0]);
		c = Integer.parseInt(arr[1]);
		s = Integer.parseInt(arr[2]);
		n = Integer.parseInt(arr[3]);
		b = new int[n];
		for(int i=4; i<4+n; i++) {
			b[i-4] = Integer.parseInt(arr[i]);
		}
		out = runStretch(r, c, s, b);
		System.out.println(out);
		return out;
	}
	
	public static String runStretch(int rows, int columns, int start, int[] blocked) {
		Board b = new Board(columns, rows);
		b.createGrid(blocked);
		b.stretch(start);
		return b.getLetters();
	}
}
