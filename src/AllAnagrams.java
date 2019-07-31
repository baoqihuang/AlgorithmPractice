import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<Integer> allAnagrams(String sh, String lo) {
		List<Integer> res = new ArrayList<>();
	    if (lo.isEmpty() || lo.length() < sh.length()) {
	      return res;
	    }
	    Map<Character, Integer> charCounts = new HashMap<>();
	    for (int i = 0; i < sh.length(); i++) {
	    	char c = sh.charAt(i);
	    	if (charCounts.containsKey(c)) {
	    		charCounts.put(c, charCounts.get(c) + 1);
	    	} else {
	    		charCounts.put(c, 1);
	    	}
	    }
	    int match = 0;
	    for (int i = 0; i < lo.length(); i++) {
	    	char c = lo.charAt(i);
	    	Integer count = charCounts.get(c);
	    	if (count != null) {
	    		charCounts.put(c, count - 1);
	    		match = count == 0 ? match + 1 : match;
	    	}
	    	
	    	if (i >= sh.length()) {
	    		c = lo.charAt(i - sh.length());
	    		count = charCounts.get(c);
	    		charCounts.put(c, count);
	    		match = count == 0 ? match - 1 : match;
	    	}
	    	if (match == charCounts.size()) {
	    		res.add(i - sh.length() + 1);
	    	}
	    }
	    return res;
	}

}
