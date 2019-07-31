import java.util.ArrayList;
import java.util.List;

public class Spiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix1 = new int[][] {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10,11,12},
				{13,14,15,16}
		};
		int[][] matrix2 = new int[][] {
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		};

		List<Integer> result = new ArrayList<>();
		result = spiralInteritive(matrix2);
		for (Integer num : result) {
			System.out.print(num + ", ");
		}
	}
	//this is iteritive method
	public static List<Integer> spiralInteritive(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
	    if (matrix.length == 0 || matrix[0].length == 0) {
	      return result;
	    }
	    int n = matrix.length;
	    int start = 0;
	    int end = n -1;
	    while (start < end) {
	    	//up
	    	for (int i = start; i < end; i++) {
	    		result.add(matrix[start][i]);
	    	}
	    	//right
	    	for (int i = start; i < end; i++) {
	    		result.add(matrix[i][end]);
	    	}
	    	//bottom
	    	for (int i = end; i > start; i--) {
	    		result.add(matrix[end][i]);
	    	}
	    	//left 
	    	for (int i = end; i > start; i--) {
	    		result.add(matrix[i][start]);
	    	}
	    	start++;
	    	end--;
	    }
	    //post-processing
	    if (start == end) {
	    	result.add(matrix[start][start]);
	    }
	    return result;
	}
	//this is recursion method
	public static List<Integer> spiral(int[][] matrix) {
	    // Write your solution here
	    List<Integer> result = new ArrayList<>();
	    if (matrix.length == 0 || matrix[0].length == 0) {
	      return result;
	    }
	    spiral(matrix, 0, result, matrix.length);
	    return result;
	  }
	public static void spiral (int[][] matrix, int offset, List<Integer> result, int len) {
		if (offset == len / 2) {
			if (len % 2 != 0) {
				result.add(matrix[offset][offset]);
			}
			return;
		}
		//upper length - 1 numbers
	    for (int i = offset ; i <= len - offset - 2; i++) {
	    	result.add(matrix[offset][i]);
	    }
	    //right length - 1 numbers
	    for (int i = offset; i <= len - offset - 2; i++) {
	    	result.add(matrix[i][len - offset - 1]);
	    }
	    //bottom length - 1 numbers
	    for (int i = len - offset - 1; i > offset; i--) {
	    	result.add(matrix[len - offset - 1][i]);
	    }
	    //left length - 1 numbers
	    for (int i = len - offset - 1; i > offset; i--) {
	    	result.add(matrix[i][offset]);
	    }
	    spiral(matrix, offset + 1, result, len);
	}

}
