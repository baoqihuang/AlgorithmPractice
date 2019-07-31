
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(missing(new int[] {1,2,3,4,5,7,8,9}));
	}
	public static int missing(int[] array) {
	    // Write your solution here
	    int len = array.length;
	    if (len == 0) {
	      return 1;
	    }
	  int totalSum = 0;
	  for (int num : array) {
		  totalSum += num;
	  }
	  int actualSum = (1 + len + 1) * (len + 1) / 2;
	  return actualSum - totalSum;
	}
}
