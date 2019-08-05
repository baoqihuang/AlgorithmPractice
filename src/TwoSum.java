
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean existSum(int[] array, int target) {
	    // Write your solution here
	    int n = array.length;
	    int left = 0; 
	    int right = n - 1;
	    boolean found = false;
	    while(!found && left < right) {
	      if (array[left] + array[right] < target) {
	        left++;
	      } else if (array[left] + array[right] > target) {
	        right--;
	      } else {
	        return true;
	      }
	    }
	    return found;
	}

}
