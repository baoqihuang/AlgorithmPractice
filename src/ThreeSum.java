import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = allTriples(new int[]{1,1,1,1,1,1,1,1,1,1,1}, 3);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).get(0) + " , " + res.get(i).get(1) + " , " + res.get(i).get(2));
		}
	}
	public static List<List<Integer>> allTriples(int[] array, int target) {
	    // Write your solution here
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			if (i > 0 && array[i] == array[i - 1]) {
				System.out.println("continue..." + i);
				continue;
			}
			System.out.println("why I am here" + i);
			int left = i + 1;
			int right = array.length - 1;
			while (left < right) {
				int temp = array[left] + array[right];
				if (array[i] + temp == target) {
					result.add(Arrays.asList(array[i], array[left], array[right]));
					left++;
					right--;
					while (left < right && array[left] == array[left - 1]) {
						left++;
					}
				} else if (temp < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}

}
