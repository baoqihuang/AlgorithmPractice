import java.util.Arrays;

public class ArrayDedupTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = dedup(new int[] {1,2,2,3,3,5,6,7});
		for (int n : result) {
			System.out.print(n + ", ");
		}
	}
	/*
	 * Given a sorted integer array, remove duplicate elements. 
	 * For each group of elements with the same value keep at most two of them. Do this in-place, 
	 * using the left side of the original array and maintain the relative order of the elements of the array. 
	 * Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
	 */
	private static int[] dedup(int[] array) {
	    // Write your solution here
	    if (array.length <= 2) {
	      return array;
	    }
	    int slow = 2;
	    for (int fast = 2; fast < array.length; fast++) {
	      if (array[slow - 2] != array[fast]) {
	        array[slow++] = array[fast];
	      }
	    }
	    return Arrays.copyOf(array, slow);
	  }
}
