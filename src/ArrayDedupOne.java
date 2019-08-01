import java.util.Arrays;

public class ArrayDedupOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = dedup(new int[] {1,2,2,3,3,5,6,7});
		for (int n : result) {
			System.out.print(n + ", ");
		}
	}
	/*
	 * Given a sorted integer array, remove duplicate elements. 
	 * For each group of elements with the same value keep only one of them. Do this in-place, 
	 * using the left side of the original array and maintain the relative order of the elements of the array. 
	 * Return the array after deduplication.

Assumptions

The array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 3}
	 */
	private static int[] dedup(int[] array) {
	    // Write your solution here
	    if (array.length <= 1) {
	      return array;
	    }
	    int slow = 1;
	    for (int fast = 1; fast < array.length; fast++) {
	      if (array[slow - 1] != array[fast]) {
	        array[slow++] = array[fast];
	      }
	    }
	    return Arrays.copyOf(array, slow);
	 }

}
