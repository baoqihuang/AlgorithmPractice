import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longest("ababcad"));

	}
	public static int longest(String input) {
	    // Write your solution here
	    int len = input.length();
	    if (len <= 1) {
	      return len;
	    }
	    Set<Character> chars = new HashSet<>();
	    int maxlen = 0;
	    int left = 0;
	    int right = 0;
	    while (right < len) {
	    	if (chars.contains(input.charAt(right))) {
	    		chars.remove(input.charAt(left++));
	    	} else {
	    		chars.add(input.charAt(right++));
	    		maxlen = Math.max(maxlen, right - left);
	    	}
	    }
	    return maxlen;
	  }

}
