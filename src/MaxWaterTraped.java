
public class MaxWaterTraped {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Given a non-negative integer array representing the heights of a list of adjacent bars. 
	 * Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions

The given array is not null
Examples

{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)


	 */
	public int maxTrapped(int[] array) {
		    // Write your solution here
		if (array.length <= 1) {
			return 0;
		} 
		int left = 0;
		int right = array.length - 1;
		int lMax = array[left];
		int rMax = array[right];
		int max = 0;
		while (left < right) {
			if (array[left] <= array[right]) {
				max += Math.max(0, lMax - array[left]);
				lMax = Math.max(lMax, array[left]);
				left++;
			} else {
				max += Math.max(0, rMax - array[right]);
				rMax = Math.max(rMax, array[right]);
				right--;
			}
		}
		return max;
	}

}
