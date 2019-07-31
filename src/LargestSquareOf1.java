
public class LargestSquareOf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {
			{0, 0, 0, 0, 0},
			{1, 1, 1, 1, 0},
			{1, 1, 1, 1, 0},
			{1, 1, 1, 0, 0},
			{1, 1, 1, 0, 0}
		};
		System.out.println(largest(matrix));
	}
	public static int largest(int[][] matrix) {
	    // Write your solution here
		int N = matrix.length;
		if (N == 0) {
			return 0;
		}
		int[][] m = new int[N][N]; 
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || j == 0) {
					m[i][j] = matrix[i][j] == 1 ? 1 : 0;
				} else if (matrix[i][j] == 1) {
					m[i][j] = Math.min(m[i - 1][i - 1] + 1, Math.min(m[i - 1][j] + 1, m[i][j - 1] + 1));
				} 
				result = Math.max(result, m[i][j]);
			}
		}
		return result;
	}
}

















