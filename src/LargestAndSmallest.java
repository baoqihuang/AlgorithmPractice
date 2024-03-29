
public class LargestAndSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] res = largestAndSmallest(new int[]{2,3,1});
		System.out.println(res[0] + " " + res[1]);
	}
	public static int[] largestAndSmallest(int[] array) {
		int n = array.length;
		if (n == 1) {
			return new int[]{array[0], array[0]};
		}
		//10 10/2 = 5   11   11/2 = 5
		//1  2  3  4  5         1  2  3  4  5
		//10 9  8  7  6         11 10 9  8  7 6
		// (n -1)/2 = 4         (n - 1)/2 = 5  => 1 2 3 4 5 6
		//n/ 2 = 5				n / 2 = 5
		for (int i = 0; i < n/2; i++) {
			if (array[i] < array[n - i - 1]) {
				swap(array, i, n - i - 1);
			}
		}
		return new int[] {smallest(array, n/2, n - 1), largest(array, 0, (n - 1) / 2)};
	}
	public static void swap (int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp; 
	}
	public static int largest (int[] array, int left, int right) {
		int largest = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
		}
		return largest;
	}
	public static int smallest (int[] array, int left, int right) {
		int smallest = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (array[i] < smallest) {
				smallest = array[i];
			}
		}
		return smallest;
	}
}
