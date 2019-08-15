import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = allPairs(new int[] {3,5,3,2,4,4}, 8);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).get(0) + " , " + res.get(i).get(1));
		}
	}
	/*
	 * Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

Assumptions

The given array is not null and has length of at least 2.

Examples

A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
	 */
	public static List<List<Integer>> allPairs(int[] array, int target) {
	    // Write your solution here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			List<Integer> indices = map.get(target - array[i]);
			if (indices != null) {
				for (int j : indices) {
					result.add(Arrays.asList(j, i));
				}
			}
			if (!map.containsKey(array[i])) {
				map.put(array[i], new ArrayList<Integer>());
			}
			map.get(array[i]).add(i);
		}
		return result;
	}
	
}










