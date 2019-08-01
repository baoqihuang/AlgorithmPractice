
public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] { 
			{1,  2,  3},
			{8,  9,  4},
		    {7,  6,  5}};
		int[][] matrix1 = new int[][] { 
				{1,  2},
				{3,  4}};
				
		int[][] matrix3	= new int[][]{
			{1,  2,  3,  4},
			{5,  6,  7,  8},
			{9, 10, 11, 12},
			{13,14, 15, 16}};
		 rotate(matrix3);
		 for (int i = 0; i < matrix3.length; i++) {
			 for (int j = 0; j < matrix3.length; j++) {
				 System.out.print(matrix3[i][j] + ", ");
			 }
			 System.out.println();
		 }
	}
	/*
	 * Rotate an N * N matrix clockwise 90 degrees.

Assumptions

The matrix is not null and N >= 0
Examples

{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }
  
{ {7,  8,  1, 5}

  {6,  9,  2, 6},

  {5,  4,  3, 7},
  
  {2,  4,  6, 0}}

	 */
	public static void rotate(int[][] matrix) {
	    // Write your solution here
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				swap(matrix, i, j, n);
			}
		}
	}
	public static void swap(int[][] matrix, int i, int j, int n) {
		//  temp = i, j (0, 1) : n - j - 1, i (2, 0) : n - i - 1, n - j - 1 (3, 2) : j, n - i - 1(1, 3)
		int temp = matrix[i][j];
		matrix[i][j] = matrix[n - j - 1][i];
		matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
		matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
		matrix[j][n - i - 1] = temp;
	}
}
