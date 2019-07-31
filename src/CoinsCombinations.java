import java.util.ArrayList;
import java.util.List;

public class CoinsCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input: 169, new int[]{469,441,365,301,269,169,104,79,23}
		//expected:<[[0, 0, 0, 0, 0, 1, 0, 0, 0]]> but was:<[]>
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    result = combinations(169, new int[]{469,441,365,301,269,169,104,79,23});
	    for(List<Integer> com : result) {
	    	List<Integer> temp = new ArrayList<>(com);
	    	for(Integer num: temp) {
	    		System.out.print(num + " , ");
	    	}
	    }
	}
	public static List<List<Integer>> combinations(int target, int[] coins) {
	    // Write your solution here
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> com = new ArrayList<>();
	    combinations(target, coins, 0, result, com);
	    return result;
	  }

	public static void combinations(int moneyLeft, int[] coins, int index, List<List<Integer>> result, List<Integer> com) {
	    if (index == coins.length - 1) {
	      if(moneyLeft % coins[coins.length - 1] == 0) {
	        com.add(moneyLeft / coins[coins.length - 1]);
	        result.add(new ArrayList<Integer>(com));
	        com.remove(com.size() - 1);
	      }
	      return;
	    }
	    for (int i = 0; i <= moneyLeft / coins[index]; i++) {
	      com.add(i);
	      combinations(moneyLeft - i * coins[index], coins, index + 1, result, com);
	      com.remove(com.size() - 1);
	    }
	  }

}















