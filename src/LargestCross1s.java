
public class LargestCross1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {
			{0, 0, 1, 0, 0},
			{1, 1, 1, 1, 0},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 0, 0},
			{1, 1, 1, 0, 0}
		};
		int[][] matrix1 = new int[][] {};
		int[][] matrix2 = new int[][] {
			{0,1,1,0,1},
			{1,1,1,1,0},
			{0,0,1,0,1}
		};
		System.out.println(largest(matrix2));
	}
	public static int largest(int[][] matrix) {
	    // Write your solution here
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0) {
			return 0;
		}
		int max = 0;
		int[][] ltor = new int[row][col];
		int[][] rtol = new int[row][col];
		int[][] utod = new int[row][col];
		int[][] dtou = new int[row][col];
		//ltor
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (j == 0) {
						ltor[i][j] = 1;
					} else {
						ltor[i][j] = ltor[i][j - 1] + 1;
					}
				}
			}
		}
		//utod
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (matrix[j][i] == 1) {
					if (j == 0) {
						utod[j][i] = 1;
					} else {
						utod[j][i] = utod[j - 1][i] + 1;
					}
				}
			}
		}
		//rtol
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (j == col - 1) {
						rtol[i][j] = 1;
					} else {
						rtol[i][j] = rtol[i][j + 1] + 1;
					}
				}
			}
		}
		//dtou
		for (int i = col - 1; i >= 0; i--) {
			for (int j = row - 1; j >= 0; j--) {
				if (matrix[j][i] == 1) {
					if (j == row - 1) {
						dtou[j][i] = 1;
					} else {
						dtou[j][i] = dtou[j + 1][i] + 1;
					}
				}
			}
		}		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int cur = Math.min(ltor[i][j], Math.min(rtol[i][j], Math.min(utod[i][j], dtou[i][j])));
				max = Math.max(cur, max);
			}
		}
		return max;

	}
}
