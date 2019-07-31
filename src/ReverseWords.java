
public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("an apple"));
	}
	
	public static String reverseWords(String input) {
	    // Write your solution here
	    if (input == null || input.length() <= 1) {
	      return input;
	    }
	    char[] str = input.toCharArray();
	    int prev = 0;
	    for (int i = 0; i < str.length; i++) {
//	    	System.out.println("prev: " + prev + " i: " + i);
//		      System.out.println(new String(str));

	      if (str[i] == ' ') {
	        reverse (str, prev, i - 1);
	        prev = i + 1;
	      } else if (i == str.length - 1) {
	    	  reverse (str, prev, i);
	      }
	    }
	    reverse (str, 0, str.length - 1);
	    return new String(str);
	  }
	  public static void reverse (char[] input, int left, int right) {
	    int mid = left + (right - left) / 2; 
	    for (int i = left ; i <= mid; i++) {
	      if ((right - left + 1) % 2 == 0) {
	        swap (input, i, 2 * mid + 1 - i);
	      } else {
	        swap (input, i, 2 * mid - i);
	      }
	    }
	  }
	  public static void swap (char[] input, int a, int b) {
	    char temp = input[a];
	    input[a] = input[b];
	    input[b] = temp;
	  }
}
