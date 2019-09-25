
public class LongestPalSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abcdefedcba"));

	}
	public static String longestPalindrome(String input) {
	    if (input.length() == 0) {
	      return input;
	    }
	    int start = 0;
	    int end = 0;
	    int max = 0;
	    for (int i = 0; i < input.length(); i++) {
	      for (int j = 0; j <= i; j++) {
	        if (isPal(input, j, i)) {
	          if ((i - j + 1) > max) {
	            start = j;
	            end = i;
	            max = i - j + 1;
	          }
	        }
	      }
	    }
	    return input.substring(start, end + 1);
	  }
	  public static boolean isPal (String input, int start, int end) {
	    while (start <= end) {
	      if (input.charAt(start) != input.charAt(end)) {
	        return false;
	      }
	      start++;
	      end--;
	    }
	    return true;
	  }

}
