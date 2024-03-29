import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CommonElementInKSortedArray {
	public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
	    // Write your solution here
	    List<Integer> result = input.get(0);
	    for (int i = 1; i < input.size(); i++) {
	      result = helper(result, input.get(i));
	    }
	    return result;
	  }
	  public List<Integer> helper (List<Integer> l1, List<Integer> l2) {
	    List<Integer> result = new ArrayList<>();
	    int i1 = 0; 
	    int i2 = 0;
	    while (i1 < l1.size() && i2 < l2.size()) {
	      int n1 = l1.get(i1);
	      int n2 = l2.get(i2);
	      if (n1 == n2) {
	        result.add(n1);
	        i1++;
	        i2++;
	      } else if (n1 < n2) {
	        i1++;
	      } else {
	        i2++;
	      }
	    }
	    return result;
	  } 
}
