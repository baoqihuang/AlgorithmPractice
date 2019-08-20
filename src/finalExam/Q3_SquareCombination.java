package finalExam;

import java.util.ArrayList;
import java.util.List;

public class Q3_SquareCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(squareCombination(20));
	}
	/*
	 * #3

How to cut/split the number into a minimum number of items such that each item is equal to an integer's square value.

For example 

4 can be split to 1+1+1+1 (4 items) or 2^2 (1 item, which is the solution)
Return 1
10 can be split to two items 3^2 + 1^2 (solution) or four items 2^2 + 2^2 + 1^2 +1^2
Return 2
	 */
	public static int minSplit (int num) {
		if (num <= 1) {
			return 1;
		}
		int[] min = new int[num + 1];
		for (int i = 1; i < min.length; i++) {
			min[i] = i;
			for (int j = 1; j * j < i; j++) {
				min[i] = Math.min(min[i], min[i - j * j] + 1);
			}
		}
		return min[num];
	}
	public static int squareCombination (int num) {
		List<Integer> squares = new ArrayList<>();
		for (int i = 1; i * i <= num; i++) {
			squares.add(i * i);
		}
		int[] counts = new int[squares.size()];
		helper(squares, counts, squares.size() - 1, num);
		int min = 0;
		for (int n : counts) {
			if (n != 0) {
				min++;
			}
		}
		return min;
	}
	public static void helper (List<Integer> squares, int[] counts, int index, int leftNum) {
		if (index == 0) {
			if (leftNum % squares.get(index) == 0) {
				counts[index] = leftNum / squares.get(index);
			}
			return;
		}
		for (int i = 0; i <= leftNum / squares.get(index); i++) {
			counts[index] = i;
			helper(squares, counts, index - 1, leftNum - i * squares.get(index));
		} 
	}
//	public static int minSplit(int num) {
//		if (num <= 1) {
//			return num;
//		}
//		int[] min = new int[num + 1];
//		for (int i = 1; i < min.length; i++) {
//			min[i] = i;
//			for (int j = 1; j * j < i; j++) {
//				min[i] = Math.min(min[i], min[i - j * j] + 1);
//			}
//		}
//		return min[num];
//	}

}
