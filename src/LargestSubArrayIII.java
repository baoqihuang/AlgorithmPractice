
public class LargestSubArrayIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestSum(new int[] {1,-2, 3}));
	}
	public static int largestSum(int[] array) {
	    // Write your solution here
	    int maxSum = array[0];
	    int maxLeft = 0;
	    int maxRight = 0;
	    int curLeft = 0;
	    int preSum = array[0];
	    int cur = 0;
	    for (int i = 1; i < array.length; i++) {
	      cur = preSum + array[i];
	      if (cur < array[i]) {
	        preSum = array[i];
	        curLeft = i;
	      } else {
	        if (cur > maxSum) {
	          maxLeft = curLeft;
	          maxRight = i;
	        }
	        preSum = cur;
	      }
	      maxSum = Math.max(maxSum, preSum);
	    }
	    return maxSum;
	  }

}
