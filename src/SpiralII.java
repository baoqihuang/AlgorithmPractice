import java.util.ArrayList;
import java.util.List;

public class SpiralII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<>();
		int[][] matrix = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
			{10,11,12},
			{13,14,15}
		};
		int[][] matrix3 = new int[][] {
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25},
			{26,27,28,29,30},
			{31,32,33,34,35}
		};
		result = spiral(matrix3);
		for (Integer num : result) {
			System.out.print(num + ", ");
		}
	}
	public static List<Integer> spiral(int[][] matrix) {
	    // Write your solution here
	    List<Integer> result = new ArrayList<>();
	    int m = matrix.length;
	    int n = matrix[0].length;
	    if (m == 0 || n == 0) {
	      return result;
	    }
	    int left = 0;
	    int right = n - 1;
	    int up = 0;
	    int down = m -1;
	    while (left < right && up < down) {
	    	for (int i = left; i <= right; i++) {
	    		result.add(matrix[up][i]);
	    	}
	    	for (int i = up + 1; i <= down - 1; i++) {
	    		result.add(matrix[i][right]);
	    	}
	    	for (int i = right; i>= left; i--) {
	    		result.add(matrix[down][i]);
	    	}
	    	for (int i = down - 1; i >= up + 1; i--) {
	    		result.add(matrix[i][left]);
	    	}
	    	left++;
	    	right--;
	    	up++;
	    	down--;
	    }
	    //if there is nothing left
	    if (left > right || up > down) {
	    	return result;
	    }
	    //if there is one column left
	    if (left == right) {
	    	for (int i = up; i<= down; i++) {
	    		result.add(matrix[i][left]);
	    	}
	    } else {
	    	//if there is one row left
	    	for (int i = left; i <= right; i++) {
	    		result.add(matrix[up][i]);
	    	}
	    }
	    return result;
	}
}












