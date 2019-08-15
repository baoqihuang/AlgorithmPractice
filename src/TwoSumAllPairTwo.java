import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSumAllPairTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = allPairs2(new int[]{3,5,4,1,2}, 6);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).get(0) + " , " + res.get(i).get(1));
		}
	}
	/*
	 * Find all pairs of elements in a given array that sum to the pair the given target number. 
	 * Return all the distinct pairs of values.

Assumptions

The given array is not null and has length of at least 2
The order of the values in the pair does not matter
Examples

A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]


	 */
	public static List<List<Integer>> allPairs(int[] array, int target) {
	    // Write your solution here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		int left = 0; 
		int right = array.length - 1;
		while (left < right) {
			if (left > 0 && array[left] == array[left - 1]) {
				left++;
				continue;
			}
			int cur = array[left] + array[right];
			if (cur == target) {
				result.add(Arrays.asList(array[left], array[right]));
				left++;
				right--;
			} else if (cur < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
	
	//Using hashmap
	public static List<List<Integer>> allPairs2(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : array) {
			Integer count = map.get(num);
			if (num * 2 == target && count != null && count == 1) {
				result.add(Arrays.asList(num, num));
			} else if (map.containsKey(target - num) && count == null) {
				result.add(Arrays.asList(num, target - num));
			}
			if (count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}
		return result;
	}

}















