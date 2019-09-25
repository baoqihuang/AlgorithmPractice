import java.util.ArrayList;
import java.util.List;

public class FactorCombination {

	public static void main(String[] args) {
		List<List<Integer>> res = combinations(10);
		for (int i = 0; i < res.size(); i++) {
			for (int num : res.get(i)) {
				System.out.print(num +",  ");
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> combinations(int target) {
	    List<List<Integer>> result = new ArrayList<>();
	    List<Integer> cur = new ArrayList<>();
	    List<Integer> factors = findFactors(target);
	    helper (result, cur, factors, target, 0);
	    return result;
	  }
	  public static List<Integer> findFactors (int target) {
	    List<Integer>factors = new ArrayList<>();
	    for (int i = target - 1; i > 1; i--) {
	      if (target % i == 0) {
	        factors.add(i);
	      }
	    }
	    return factors;
	  }
	  public static void helper (List<List<Integer>> result, List<Integer> cur, List<Integer> factors,
	  int target, int index) {
		  if (index == factors.size()) {
			  if (target == 1) {
				  result.add(new ArrayList<>(cur));
			  }
			  return;
		  }
		  helper (result, cur, factors, target, index + 1);
	    int num = factors.get(index);
	    int count = 0;
	    while (target % num == 0) {
	    	cur.add(num);
	    	count++;
	    	target /= num;
	    	helper (result, cur, factors, target, index + 1);
	    }
	    for (int i = 0; i < count; i++) {
	    	cur.remove(cur.size() - 1);
			//helper (result, cur, factors, target, index + 1);
	    }
	  }

}
