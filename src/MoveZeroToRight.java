import java.util.Arrays;

public class MoveZeroToRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = moveZero(new int[] {0, 0, 0, 1, 1, 0, 2, 3, 0, 1, 0});
		for (int n : result) {
			System.out.print(n + ", ");
		}
	}
	public static int[] moveZero(int[] array) {
	    // Write your solution here
	    if (array.length <= 1) {
	      return array;
	    }
	    int slow = 0;
	    for (int fast = 0; fast < array.length; fast++) {
	    	if (array[fast] != 0) {
	    		swap(array, slow, fast);
	    		slow++;
	    	}
//	    	System.out.print(" : " + fast + " ");
//	    	print(array);
//	    	System.out.println();
	    }
	    //move same direction
	    
	    return array;
	}
	public static void swap (int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	public static void print(int[] array) {
		for (int n : array) {
			System.out.print(n + ", ");
		}
	}
}
