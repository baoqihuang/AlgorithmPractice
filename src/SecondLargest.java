
public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(secondLargest(new int[] {1,4,6,7,0,9,11,365,123}));
	}
	public static int secondLargest (int[] input) {
		if (input.length < 2) {
			return Integer.MIN_VALUE;
		}
		int largest = input[0] > input[1] ? input[0]: input[1];
		int second = largest == input[0] ? input[1]: input[0];
		for (int i = 2; i < input.length; i++) {
			if (input[i] > largest) {
				second = largest;
				largest = input[i];
				 
			} else if (input[i] > second) {
				second = input[i];
			}
		}
		return second;
	}

}
