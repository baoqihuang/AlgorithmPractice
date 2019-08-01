import java.util.Arrays;

public class ArrayDedupThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = dedup(new int[] {1,2,2,3,3,5,6,7});
		for (int n : result) {
			System.out.print(n + ", ");
		}
	}
	/**
	 * Given a sorted integer array, remove duplicate elements. 
	 * For each group of elements with the same value do not keep any of them. Do this in-place, 
	 * using the left side of the original array and and maintain the relative order of the elements of the array. 
	 * Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1}
	 */
	private static int[] dedup(int[] array) {
	    // Write your solution here
	    if (array.length <= 1) {
	      return array;
	    }
	    int slow = 0;
	    int start = 0;
	    int fast = 0;
	    while (fast < array.length) {
	      start = fast;
	      while (fast < array.length && array[fast] == array[start]) {
	        fast++;
	      }
	      if (fast - start == 1) {
	        array[slow++] = array[start];
	      }
	    }
	    //post processing
	    if  (fast == array.length && array[fast - 1] != array[start]) {
	      array[slow++] = array[fast - 1];
	    }
	    return Arrays.copyOf(array, slow);
	  }
}
