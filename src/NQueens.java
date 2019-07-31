import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = nqueens(8);
		for (List<Integer> sol : result ) {
			for (Integer col : sol) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> nqueens(int n) {
	    // Write your solution here
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> sol = new ArrayList<>();
	    nqueens(result, sol, n);
	    return result;
	  }
	public static void nqueens(List<List<Integer>> result, List<Integer> sol, int numQueens) {
	    if (sol.size() == numQueens) {
	      result.add(new ArrayList<>(sol));
	      return;
	    }
	    
	    for (int i = 0; i < numQueens; i++) {
	      if (!isConflict(sol, sol.size(), i)) {
	    	  //System.out.println("curRow: " + sol.size());
	        sol.add(i);
	        nqueens(result, sol, numQueens);
	        sol.remove(sol.size() - 1);
	      }
	    }
	  }
	  public static boolean isConflict(List<Integer> sol, int curRow, int curCol) {
	    for (int i = 0; i < curRow; i++) {
	      //check if one same column
	      if ((sol.get(i) == curCol) || (Math.abs(curCol - sol.get(i)) == Math.abs(curRow - i))) {
	        return true;
	      }
	    }
	    return false;
	  }

}
