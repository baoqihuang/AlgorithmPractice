
public class LargestSubArrayProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(largestProduct(new double[]{2,-0.5,-3,0.4,4,-2,-2,1} ));
		System.out.println(largestProduct(new double[]{0,2,-2,0.2,-1.5,0.1}));
		// max 2 2 3 3 4 4 16
		// min 2 -1 -3 -3 -8 -6
		// ans 2 2 
	}
	public static double largestProduct(double[] array) {
	    // Write your solution here
	    double max = array[0];
	    double min = array[0];
	    //double answer = array[0];
	    double ans = array[0];
	    for (int i = 1; i < array.length; i++) {
	    	System.out.println("Before multiple........ "+array[i]+" max: "+max+" min: "+min+" ans: "+ans+"\n");
	    	if (array[i] < 0) {
	    		double temp = max;
	    		max = min;
	    		min = temp;
	    	} 
	    	max = Math.max(array[i], max * array[i]);
	    	min = Math.min(array[i], min * array[i]);
	    	ans = Math.max(ans, max);
	    }
	    return ans;
	}

}
