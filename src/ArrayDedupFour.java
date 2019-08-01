import java.util.Arrays;

public class ArrayDedupFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = dedup(new int[] {1, 2, 3, 3, 3, 2, 2});
		for (int n : result) {
			System.out.print(n + ", ");
		}
	}
	/*
	 * Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. 
	 * For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
	 */
	private static int[] dedup(int[] array) {
	    // Write your solution here
		// 1, 1, 2, 2
		// 1, 2, 3, 4
		if (array.length <= 1) {
			return array;
		}
		int slow = 0;
		for (int fast = 1; fast < array.length; fast++) {
			if (slow != -1 && array[fast] == array[slow]) {
				while (fast < array.length && array[fast] == array[slow]) {
					fast++;
				}
				fast--;
				slow--;
			} else {
				array[++slow] = array[fast];
			}
		}
		if (slow == -1) {
			return new int[] {};
		}
		return Arrays.copyOf(array, slow + 1);
	}
}
