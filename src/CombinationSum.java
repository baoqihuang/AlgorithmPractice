import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = combinationSum(new int[]{2,4}, 8);
		for (int i = 0; i < res.size(); i++) {
			for (int num : res.get(i)) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	    // Write your solution here
	    //List<List<Integer>> helper = new ArrayList<>();
	    List<List<Integer>> res = new ArrayList<>();

	    List<Integer> cur = new ArrayList<>();
	    helper(res, cur, candidates, target, 0);
	    //res = translate(res, candidates);
	    return res;
	}
	public static List<List<Integer>> translate(List<List<Integer>> res, int[] candidates) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			List<Integer> cur = new ArrayList<>();

			int index = 0;
			for (int count : res.get(i)) {
				for (int j = 0; j < count; j++) {
					cur.add(candidates[index]);
					
				}
				index++;
			}
			result.add(new ArrayList<>(cur));
		}
		return result;
	}
	public static void helper2(List<List<Integer>> res, List<Integer> cur, int[] candi, int target, int index) {
	    if (index == candi.length - 1) {
	      if (target % candi[candi.length - 1] == 0) {
	        cur.add(target / candi[candi.length - 1]);
	        res.add(new ArrayList<>(cur));
	    	cur.remove(cur.size() - 1);
	      }
	      return;
	    }
	    //if (target >= candi[index]) {
	    for (int i = 0; i <= target / candi[index]; i++) {
	    	//System.out.println(i +" "+ candi[index]);
	    	cur.add(i);	
	    	helper2(res, cur, candi, target - i * candi[index], index + 1);

	    	cur.remove(cur.size() - 1);
	    }
	    //}
	  }
	public static void helper(List<List<Integer>> res, List<Integer> cur, int[] candi, int target, int index) {
		if (target == 0) {
	        res.add(new ArrayList<>(cur));
	    }
		if (index == candi.length) {
			return;
		}
	    //if (target >= candi[index]) {
	    for (int i = 0; i <= target / candi[index]; i++) {
	    	System.out.println("i: "+i +" candi :"+ candi[index]);
	    	if (i > 0)
	    		cur.add(candi[index]);	
	    	helper(res, cur, candi, target - i * candi[index], index + 1);
	    	if (i > 0)
	    		cur.remove(cur.size() - 1);
	    }
	    //}
	  }


}
