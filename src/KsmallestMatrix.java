import java.util.Comparator;
import java.util.PriorityQueue;

public class KsmallestMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1,2}
		};
		System.out.println(kthSmallest(matrix, 2));
	}
	public static int kthSmallest(int[][] matrix, int k) {
	    // Write your solution here
	    int r = matrix.length;
	    int c = matrix[0].length;
	    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell> () {
	      @Override
	      public int compare(Cell c1, Cell c2) {
	        if(c1.value == c2.value) {
	          return 0;
	        }
	        return c1.value < c2.value ? -1 : 1;
	      }
	    });
	    boolean[][] visited = new boolean[r][c];
	    minHeap.offer(new Cell(0, 0, matrix[0][0]));
	    visited[0][0] = true;
	    for(int i = 0; i < k - 1; i++){
	      Cell cur = minHeap.poll();
	      System.out.println("row: " + cur.row + " column: " + cur.column);
	      if(cur.row + 1 < r && !visited[cur.row + 1][cur.column]) {
	        minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
	        visited[cur.row + 1][cur.column] = true;
	      }
	      if(cur.column + 1 < c && !visited[cur.row][cur.column + 1]) {
	        minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
	        visited[cur.row][cur.column + 1] = true;
	      }
	    }
	    return minHeap.peek().value;
	  }
	  public static class Cell {
	    int row;
	    int column;
	    int value;
	    public Cell(int row, int column, int value) {
	      this.row = row;
	      this.column = column;
	      this.value = value;
	    }
	  }

}
