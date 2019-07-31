
public class largestSquareSurroundedByOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {
			{1,1,1,1,1,1,0,1},
			{1,0,1,1,0,0,1,1},
			{1,1,1,1,0,1,1,1},
			{1,1,1,0,0,1,1,1},
			{1,0,0,0,0,0,1,1},
			{1,1,1,1,1,0,1,1},
			{1,1,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1}
		};
		//System.out.println(largestSquareSurroundedByOne(matrix));
		System.out.println(solution(matrix));
	}
	public static int solution(int [][]matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int result = 0;
		int M = matrix.length;
		int N = matrix[0].length;
		int[][] left = new int[M + 1][N + 1];
		int[][] up = new int[M + 1][N + 1];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1) {
					left[i + 1][j + 1] = left[i + 1][j] + 1;
					up[i + 1][j + 1] = up[i][j + 1] + 1;
					for (int maxLength = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLength >= 1; maxLength--) {
						if (left[i + 2 - maxLength][j + 1] >= maxLength && up[i + 1][j + 2 - maxLength] >= maxLength) {
							result = Math.max(result, maxLength);
							break;
						}
					}
				}
			}
		}
		return result;
	}
	public static int largestSquareSurroundedByOne(int[][] matrix) {
	    // Write your solution here
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0) {
			return 0;
		}
		int[][] rtol = new int[row][col];
		int[][] dtou = new int[row][col];
		int largest = 0;
		//pre-processing
		//calculate the consecutive one from right to left
		for (int i = 0; i < row; i++) {
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
		//calculate the consecutive one from bottom to up
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					if (i == row - 1) {
						dtou[i][j] = 1;
					} else {
						dtou[i][j] = dtou[i + 1][j] + 1;
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int len = Math.min(rtol[i][j], dtou[i][j]);
				for (int k = len; k >= 1; k--) {
					if (matrix[i][j] == 1 && rtol[i + k - 1][j] >= len && dtou[i][j + k - 1] >= len) {
						if (len > largest) {
							largest = len;
						}
					}
				}
			}
		}
		
		return largest;
	}
}
