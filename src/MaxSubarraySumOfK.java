import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySumOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArrayLen(new int[]{342,405,218,465,18,312,421,391,70,440,421,294,112,485,26,130,163,499,140,213}, 4));
	}
	public static int maxSubArrayLen(int[] nums, int k) {
	    int max = 0;
	    int preSum = 0;
	    Map<Integer, Integer> prefixSum = new HashMap<>();
	    prefixSum.put(0, 0);
	    for (int i = 0; i < nums.length; i++) {
	      preSum += nums[i];
	      System.out.println(preSum);
	      if (prefixSum.containsKey(preSum - k)) {
	        int curDifIndex = i - (prefixSum.get(preSum - k));
	        max = Math.max(max, curDifIndex);
	      } 
	      if (!prefixSum.containsKey(preSum)) {
	        prefixSum.put(preSum, i);
	      }
	    }
	    return max;
	  }

}
