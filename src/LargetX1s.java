
public class LargetX1s {

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
		int[][] ultord = new int[row][col];
		int[][] urtold = new int[row][col];
		int[][] rdtoul = new int[row][col];
		int[][] ldtour = new int[row][col];
		//up left to right down
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (j == 0 || i == 0) {
						ultord[i][j] = 1;
					} else {
						ultord[i][j] = ultord[i - 1][j - 1] + 1;
					}
				}
			}
		}
		//up right to left down
		for (int i = 0; i < row; i++) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == col - 1) {
						urtold[i][j] = 1;
					} else {
						urtold[i][j] = urtold[i - 1][j + 1] + 1;
					}
				}
			}
		}
		//right down to up left
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (j == col - 1 || i == row - 1) {
						rdtoul[i][j] = 1;
					} else {
						rdtoul[i][j] = rdtoul[i + 1][j + 1] + 1;
					}
				}
			}
		}
		//left down to up right
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (i == row - 1 || j == 0) {
						ldtour[i][j] = 1;
					} else {
						ldtour[i][j] = ldtour[i + 1][j - 1] + 1;
					}
				}
			}
		}		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int cur = Math.min(ultord[i][j], Math.min(urtold[i][j], Math.min(rdtoul[i][j], ldtour[i][j])));
				max = Math.max(cur, max);
			}
		}
		return max;

	}

}
