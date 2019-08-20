import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class placeToPutCharI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] input = new char[][]{{'C','C','E','O','C'},{'E','E','O','C','E'},{'C','C','E','C','C'},{'C','O','C','E','E'},{'E','C','O','C','C'}};
		List<Integer> res = putChair(input);
		for (int i : res) {
			System.out.print(i + " , ");
		}
		
		

	}
	/*
	 * Given a gym with k pieces of equipment and some obstacles.  
	 * We bought a chair and wanted to put this chair into the gym such that  
	 * the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. 
	 * The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ‘O’ denotes a cell with an obstacle, 
	 * 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) 
	 * if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. 
	 * You can not put the chair on a cell with equipment or obstacle.

Assumptions

There is at least one equipment in the gym
The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
It is guaranteed that each 'C' cell is reachable from all 'E' cells.
If there does not exist such place to put the chair, just return {-1, -1}
Examples

{ { 'E', 'O', 'C' },

  {  'C', 'E',  'C' },

  {  'C',  'C',  'C' } }

we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
	 */
	  public static final char EQ = 'E';
	  public static final char OB = 'O';
	  public static List<Integer> putChair(char[][] gym) {
	    // Write your solution here
	    //List<Integer> result = new ArrayList<>();
	    //int[] min = int[] {Integer.MAX_VALUE};
	    //Set<Cell> visited = new HashSet<>();
	    int m = gym.length;
	    int n = gym[0].length;
	    int[][] cost = new int[m][n];
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        if (gym[i][j] == EQ) {
	          if (!addCost(cost, gym, i, j)) {
	            return Arrays.asList(-1, -1);
	          }
	        }
	      }
	    }
	    List<Integer> result = null;
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        if (EQ != gym[i][j] && OB != gym[i][j]) {
	        	//System.out.print("i: " + i + " j: " + j +  " , " + cost[i][j] + "  ");
	          if (result == null) {
	            result = Arrays.asList(i, j);
	          } else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
	            result.set(0, i);
	            result.set(1, j);
	          }
	        }
	      }
	    }
	    return result != null ? result : Arrays.asList(-1, -1);
	  }
	  public static boolean addCost (int[][] cost, char[][] gym, int i, int j) {
	    boolean[][] visited = new boolean[gym.length][gym[0].length];
	    int pathCost = 1;
	    Queue<Cell> queue = new ArrayDeque<>();
	    visited[i][j] = true;
	    queue.offer(new Cell(i, j));
	    while (!queue.isEmpty()) {
	      int size = queue.size();
	      for (int s = 0; s < size; s++) {
	        Cell cur = queue.poll();
	        List<Cell> neis = getNeis(cur, gym);
	        for (Cell nei : neis) {
	          if (!visited[nei.i][nei.j]) {
	            visited[nei.i][nei.j] = true;
	            cost[nei.i][nei.j] += pathCost;
	            queue.offer(nei);
	          }
	        }
	      }
	      pathCost++;
	    }
	    for (int l = 0; l < gym.length; l++) {
	      for (int m = 0; m < gym[0].length; m++) {
	        if (!visited[l][m] && EQ == gym[l][m]) {
	          return false;
	        }
	      }
	    }
	    return true;
	  }
	  public static List<Cell> getNeis (Cell cur, char[][] gym) {
	    int x = cur.i;
	    int y = cur.j;
	    int m = gym.length;
	    int n = gym[0].length;
	    List<Cell> neis = new ArrayList<>();
	    if (x + 1 < m && OB != gym[x + 1][y]) {
	      neis.add(new Cell(x + 1, y));
	    }
	    if (y + 1 < n && OB != gym[x][y + 1]) {
	      neis.add(new Cell(x, y + 1));
	    }
	    if (x - 1 >= 0 && OB != gym[x - 1][y]) {
	      neis.add(new Cell(x - 1, y));
	    }
	    if (y - 1 >= 0 && OB != gym[x][y - 1]) {
	      neis.add(new Cell(x, y - 1));
	    }
	    return neis;
	  }
	  static class Cell {
	    int i;
	    int j;
	    public Cell (int i, int j) {
	      this.i = i;
	      this.j = j;
	    }
	  }

}
