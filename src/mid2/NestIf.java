package mid2;

public class NestIf {
//	private class Cell{
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pintIf(2);
	}
	/*
	 * Given an integer n, print/output all possible if blocks for it. Say n=2 output should be

	 * if {

	 * }

	 * if {

	 * }

	 * <newline>

	 * if {

  	 *	 if {// here should exist two spaces before each inner block

     * 	  }

	 * }
	 */
	private static void pintIf(int num) {
		char[] comb = new char[2 * num];
		helper(comb, num, num, 0);
	}
	private static void helper(char[] comb, int left, int right, int pos) {
		if (left == 0 && right == 0) {
			printHelper(comb);
			return;
		}
		if (left > 0) {
			comb[pos] = '{';
			helper(comb, left - 1, right, pos + 1);
		}
		if (right > left) {
			comb[pos] = '}';
			helper(comb, left, right - 1, pos + 1);
		}
	}
	private static void printHelper(char[] comb) {
		int heading = 0;
		for (int i = 0; i < comb.length; i++) {
			if (comb[i] == '{') { 
				printSpace(heading);
				System.out.println("if {");
				heading += 2;
			} else {
				heading -= 2;
				printSpace(heading);
				System.out.println("}");
			}
		}
	}
	private static void printSpace(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print(" ");
		}
	}
	
}
