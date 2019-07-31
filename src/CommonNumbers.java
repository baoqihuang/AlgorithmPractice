import java.util.ArrayList;
import java.util.List;

public class CommonNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(1);
		A.add(1);
		A.add(1);
		A.add(1);
		
		List<Integer> B = new ArrayList<>();
		B.add(1);
		B.add(1);
		B.add(1);
		B.add(1);

		List<Integer> result = common(A, B);
		for(Integer num: result) {
			System.out.println(num);
		}
	}
	public static List<Integer> common(List<Integer> A, List<Integer> B) {
	    // Write your solution here
		//Input: java.util.Arrays.asList(1,2,3,4,5), java.util.Arrays.asList(2,3,5,9)
		//expected:<[2, 3, 5]> but was:<[1, 2, 3]>
		//Input: java.util.Arrays.asList(1,1,2,4,4,6,6,6), java.util.Arrays.asList(1,3,5,5,6,6)
		//java.lang.ArrayIndexOutOfBoundsException: 6
	    List<Integer> result = new ArrayList<>();
	    if(A.size() == 0 || B.size() == 0) {
	      return result;
	    }
	    int left = 0;
	    int target = -1;
	    for(Integer num : A) {
	    	System.out.println("left: " + left + " target: " + target);
	      target = binarySearch(B, num, left) ;
	      if(target != -1) {
	        result.add(B.get(target));
	        left = target + 1;
	      }
	    }
	    return result;
	  }
	  public static int binarySearch(List<Integer> list, int target, int left) {
	    if(list == null || list.size() == 0) {
	      return -1;
	    }
	    int right = list.size() - 1;
	    while(left < right - 1) {
	      int mid = left + (right - left) / 2;
	      if (list.get(mid) >= target) {
	        right = mid;
	      } else {
	        left = mid;
	      }
	    }
	    if(left < list.size() && list.get(left) == target) {
	      return left;
	    }
	    if(left < list.size() && list.get(right) == target) {
	      return right;
	    }
	    return -1;
	  }
}
