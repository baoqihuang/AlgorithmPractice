import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = combinationSum2(new int[]{1,1,2,2,4,5,5,6,7,8,9}, 17);
		//expected:<[[8, 9], [1, 7, 9], [2, 6, 9], [2, 7, 8], [4, 5, 8], [4, 6, 7], [5, 5, 7], 
		//[1, 1, 6, 9], [1, 1, 7, 8], [1, 2, 5, 9], [1, 2, 6, 8], [1, 4, 5, 7], [1, 5, 5, 6], 
		//[2, 2, 4, 9], [2, 2, 5, 8], [2, 2, 6, 7], [2, 4, 5, 6], [1, 1, 2, 4, 9], [1, 1, 2, 5, 8], 
		//[1, 1, 2, 6, 7], [1, 1, 4, 5, 6], [1, 2, 2, 4, 8], [1, 2, 2, 5, 7], [1, 2, 4, 5, 5], [1, 1, 2, 2, 4, 7], 
		//[1, 1, 2, 2, 5, 6]]>
		//but was:
		for (int i = 0; i < res.size(); i++) {
			for (int num : res.get(i)) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> combinationSum2222(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private static void backtrack(int[] candidates, int remain, int start, ArrayList<Integer> tempList, List<List<Integer>> res) {
        if (remain < 0)
            return;
        else if (remain == 0) {
            res.add(new ArrayList<Integer>(tempList));
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > remain)
                    break;
                if (i > start && candidates[i] == candidates[i -1])
                    continue;
                tempList.add(candidates[i]);
                backtrack(candidates, remain - candidates[i], i + 1, tempList, res);
                tempList.remove(tempList.size() - 1);
            }
        }
    } 
	//   10
	//  // / // / 
	//
	/*
	 * Given a collection of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums toT. 
	 * Each number in C may only be used once in the combination.

All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order.

The solution set must not contain duplicate combinations.

Example

          given candidate set 10,1,2,7,6,1,5 and target 8,

          A solution set is:

          [1, 7]

          [1, 2, 5]

          [2, 6]

          [1, 1, 6]


	 */
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
	    // Write your solution here
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(num);
		helper(result, cur, num, target, 0);
		return result;
	}
	public static void helper(List<List<Integer>> result, List<Integer> cur, int[] num, int target, int index) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<>(cur));
			return;
		} else {

			for (int i = index; i < num.length; i++) {
				if (target < num[i]) {
					break;
				}
				if (i > index && num[i] == num[i - 1]) {
					continue;
				}
				cur.add(num[i]);
				helper(result, cur, num, target - num[i], index + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}

}







