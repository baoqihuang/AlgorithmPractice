import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canBreak("abcdefabcdefbo", new String[] {"abc","def","bob"}));
	}
	public static boolean canBreak(String input, String[] dict) {
	    // Write your solution here
	    Set<String> words = new HashSet<>();
	    char[] chars = input.toCharArray();
	    boolean[] can = new boolean[input.length()];
	    for (String word : dict) {
	    	words.add(word);
	    }
	    for (int i = 0; i < input.length(); i++) {
	    	int count = i + 1;
	    	if (words.contains(new String(chars, 0, count))) {
	    		can[i] = true;
	    	} else {
	    		//abcdefg
	    		//  i  j
	    		for (int j = i - 1; j >= 0; j--) {
	    			if (can[j] && words.contains(new String(chars, j + 1, i - j))) {
	    				can[i] = true; 
	    			}
	    		}
	    	}
	    }
	    return can[input.length() - 1];
	}

}
