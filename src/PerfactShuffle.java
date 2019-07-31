import java.util.Random;

public class PerfactShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Random ran = new Random();
		//System.out.println(ran.nextInt(10));
		int[] arr = new int[] {1,4,6,7,3, 0,9};
		shuffle(arr);
		for (int n : arr) {
			System.out.print(n + ", ");
		}
	}
	public static void shuffle(int[] array) {
	    // Write your solution here.
		Random ran = new Random();
	    for (int i = 0; i < array.length; i++) {
	    	swap(array, i, ran.nextInt(array.length - 2) + 1);
	    }
	}
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
