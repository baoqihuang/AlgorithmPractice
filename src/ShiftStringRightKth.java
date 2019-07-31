
public class ShiftStringRightKth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rightShift("abcde", 8));
	}
	public static String rightShift(String input, int n) {
	    // Write your solution here
	    int len = input.length();
	    if (len <= 1 || n == 0) {
	      return input;
	    }
	    int k = n % len;
	    char[] str = input.toCharArray();
	    reverse (str, 0, len - 1 - k);
	    reverse (str, len - k, len - 1);
	    reverse (str, 0, len - 1);
	    return new String(str);
	  }
	  public static void reverse (char[] input, int left, int right) {
	    while (left < right) {
	      swap (input, left++, right--);
	    }
	  }
	  public static void swap (char[] input, int a, int b) {
	    char temp = input[a];
	    input[a] = input[b];
	    input[b] = temp;
	  }

}
