import java.util.HashMap;
import java.util.Map;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

The given array is not null and has length of at least 4
Examples

A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

A = {1, 2, 2, 3, 4}, target = 12, return false
	 */
	static class Pair{
		int left;
		int right;
		Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	public boolean exist(int[] array, int target) {
		//Assumptions: array is not null, array.length >= 4
		Map<Integer, Pair> map = new HashMap<>();
		//The order of travering i, j is not arbitrary, we should guarantee
		// we can always look at the pair witht he smallest right index.
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				int pairSum = array[j] + array[i];
				//we need to guarantee there exists another pair with right index
				//smaller than the current pair's left index
				if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
					return true;
				}
				if (!map.containsKey(pairSum)) {
					map.put(pairSum, new Pair(j, i));
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
