import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = combine(5, 2);
		for (int i = 0; i < res.size(); i++) {
			for (int num : res.get(i)) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> combine(int n, int k) {
	    // Write your solution here
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> cur = new ArrayList<>();
	    if (n <= 0 || k <= 0 || k > n) {
	      res.add(cur);
	      return res;
	    }
	    helper(res, cur, n, k, 1);
	    return res;
	  }
	public static void helper(List<List<Integer>> res, List<Integer> cur, int n, int k, int index) {
	    if (cur.size() == k) {
	      res.add(new ArrayList<>(cur));
	      //return;
	    }
	    for (int i = index; i <= n; i++) {
	        if (cur.isEmpty()|| i > cur.get(cur.size() - 1)) {
		    	  cur.add(i);
		    	  helper(res, cur, n, k, index + 1);
		    	  cur.remove(cur.size() - 1);
	        }
	    }
	  }

}
