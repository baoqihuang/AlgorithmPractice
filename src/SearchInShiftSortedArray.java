
public class SearchInShiftSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int search (int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) { 
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) return mid;
			if (nums[left] < nums[right]) {
				if (nums[left] <= target && target <= nums[mid]) right = mid;
				else left = mid;
			} else {
				if (nums[mid] <= target && target <= nums[right]) left = mid;
				else right = mid;
			}
		}
		return -1;
	}

}
