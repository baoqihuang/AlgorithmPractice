import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MaxValKSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = maxWindows(new int[]{2,1,3,6,2,3,2,4,1,5,2,7,6,8,1,4}, 3);
		for (int n : res) {
			System.out.print(n + " ,");
		}
	}
	public static List<Integer> maxWindows(int[] array, int k) {
	    List<Integer> result = new ArrayList<>();
	    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(11, new Comparator<Pair> () {
	      @Override
	      public int compare (Pair p1, Pair p2) {
	        if (p1.val == p2.val) {
	          return 0;
	        }
	        return p1.val < p2.val ? 1 : -1;
	      }
	    });
	    for (int i = 0; i < array.length; i++) {
	        maxHeap.offer(new Pair (i, array[i]));
	        //  0 1 2 3 4 5   k = 3
	        //    mI    i
	        while (maxHeap.peek().index <= i - k) {
	          maxHeap.poll();
	        }
	        if (i >= k - 1) {
	          result.add(maxHeap.peek().val);
	        }
	    }
	    return result;
	  }
	  static class Pair {
	    int index;
	    int val;
	    Pair (int index, int val) {
	      this.index = index;
	      this.val = val;
	    }
	  }
}
