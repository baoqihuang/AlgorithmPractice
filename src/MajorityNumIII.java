import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MajorityNumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = majority(new int[]{1,2,2}, 3);
		for (int n : res) {
			System.out.print(n + ", ");
		}
	}
	
	public static List<Integer> majority(int[] array, int k) {
	    List<Integer> result = new ArrayList<>();
	    Set<Integer> helper = new HashSet<>();
	    firstRound(helper, array, k);
	    finalRound(helper, result, k, array);
	    return result;
	  }
	  public static void finalRound (Set<Integer> helper, List<Integer> result, int k, int[] array) {
	    Map<Integer, Integer> count = new HashMap<>();
	    for (int num : array) {
	      if (helper.contains(num)) {
	        if (count.containsKey(num)) {
	          count.put(num, count.get(num) + 1);
	        } else {
	          count.put(num, 1);
	        }
	      }
	    }
	    for (Map.Entry<Integer, Integer> entry : count.entrySet()) { 
	      if (entry.getValue() > (double)(array.length / k)) {
	        result.add(entry.getKey());
	      }
	    }
	  }
	  public static void firstRound (Set<Integer> helper, int[] array, int k) {
	    Map<Integer, Integer> stage = new HashMap<>();
	    for (int i = 0; i < array.length; i++) {
	      int cur = array[i];
	      if (stage.size() < k - 1 || stage.containsKey(cur)) {
	        if (stage.containsKey(cur)) {
	          stage.put(cur, stage.get(cur) + 1);
	        } else {
	          stage.put(cur, 1);
	        }
	      } else {
	        Set<Integer> toBeRemove = new HashSet<>();
	        for (Map.Entry<Integer, Integer> entry : stage.entrySet()) {
	          int val = entry.getValue();
	          entry.setValue(val - 1);
	          if (val == 1) {
	            toBeRemove.add(entry.getKey());
	          }
	        }
	        for (int num : toBeRemove) {
	        	System.out.println("remove?");
	          stage.remove(num);
	        }
	      }
	    }
	    for (Map.Entry<Integer, Integer> entry : stage.entrySet()) { 
	      helper.add(entry.getKey());
	      System.out.println("sur: " +entry.getKey());
	    }
	}

}
