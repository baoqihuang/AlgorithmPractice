import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KthClosestPointTo000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = closest(new int[]{1,3}, new int[]{2,3}, new int[]{2,4}, 8);
		//1,2,1    2,2,1  2,2,2  3,2,1 3,2,2
		for (int i : result) {
			System.out.println(i);
		}
	}
	  public static List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		    // Write your solution here
		    List<Integer> result = new ArrayList<>();
		    PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>(){
		      @Override
		      public int compare (Point p1, Point p2) {
		        if (p1.value == p2.value) {
		          return 0;
		        }
		        return p1.value < p2.value ? -1 : 1;
		      }
		    });
		    Set<Integer> visited = new HashSet<>();
		    visited.add(indexProduct(a[0], b[0], c[0]));
		    minHeap.offer(new Point(0, 0, 0, product(a[0], b[0], c[0])));
		    for (int i = 1; i < k; i++) {
		    	//a.length 3 b.length 2 c.length 2
		      Point cur = minHeap.poll();
		      int x = cur.x;
		      int y = cur.y;
		      int z = cur.z;
		      System.out.println("x: " + x + " y: " + y + " z: " + z + " value: " + cur.value);
		      if (x < a.length - 1 && visited.add(indexProduct(a[x + 1], b[y], c[z]))) {
		    	  	minHeap.offer(new Point(x + 1, y, z, product(a[x + 1], b[y], c[z])));
		      }
		      if (y < b.length - 1 && visited.add(indexProduct(a[x], b[y + 1], c[z]))) {
			        minHeap.offer(new Point(x, y + 1, z, product(a[x], b[y + 1], c[z])));
		      }
		      if (z < c.length - 1 && visited.add(indexProduct(a[x], b[y], c[z + 1]))) {
			        minHeap.offer(new Point(x, y, z + 1, product(a[x], b[y], c[z + 1])));
		      }
		    }
		     System.out.println("result" + " x: " + minHeap.peek().x + " y: " + minHeap.peek().y + " z: " + minHeap.peek().z + " value: " + minHeap.peek().value);

		    result.add(a[minHeap.peek().x]);
		    result.add(b[minHeap.peek().y]);
		    result.add(c[minHeap.peek().z]);
		    return result;
	  }
	  public static int indexProduct (int x, int y, int z) {
		  return x * 100 + y * 10 + z;
	  }
	  public static int product (int x, int y, int z) {
		  return x * x + y * y + z * z;
	  }
	  
		  public static class Point{
		    int x;
		    int y;
		    int z;
		    int value;
		    public Point(int x, int y, int z, int value) {
		      this.x = x;
		      this.y = y;
		      this.z = z;
		      this.value = value;
		    }
		  }

}
