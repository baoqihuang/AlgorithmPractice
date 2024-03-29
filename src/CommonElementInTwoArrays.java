import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CommonElementInTwoArrays {
	public List<Integer> common(int[] A, int[] B) {
	    // Write your solution here
	    List<Integer> result = new ArrayList<>();
	    if (A.length == 0|| B.length == 0) {
	      return result;
	    }
	    PriorityQueue<Integer> minHeapOne = new PriorityQueue<>();
	    PriorityQueue<Integer> minHeapTwo = new PriorityQueue<>();
	    for (int n : A) {
	      minHeapOne.offer(n);
	    }
	    for (int n : B) {
	      minHeapTwo.offer(n);
	    }
	    while (!minHeapOne.isEmpty() && !minHeapTwo.isEmpty()) {
	      int first = minHeapOne.peek();
	      int second = minHeapTwo.peek();
	      if (first == second) {
	        result.add(first);
	        minHeapOne.remove();
	        minHeapTwo.remove();
	      } else if (first < second) {
	        minHeapOne.remove();
	      } else {
	        minHeapTwo.remove();
	      }
	    }
	    return result;
	  }
}
