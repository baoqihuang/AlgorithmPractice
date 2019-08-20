import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canBreak2("abcdefabcdefbob", new String[] {"abc","def","bob"}));
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
	  public static boolean canBreak2(String input, String[] dict) {
		    // Write your solution here
		    Set<String> dictionary = new HashSet<>();
		    for (String str : dict) {
		      dictionary.add(str);
		    }
		    boolean[] canSplit = new boolean[input.length() + 1];
		    canSplit[0] = true;
		    for (int i = 1; i < canSplit.length; i++) {
		      for (int j = i - 1 ; j >= 0; j--) {
		    	  System.out.println("contains: " + dictionary.contains(input.substring(j, i)) + " substring: " + 
		      input.substring(j, i) + " cansplit[j]: " + canSplit[j]);
		        if (dictionary.contains(input.substring(j, i)) && canSplit[j]) {
		          canSplit[i] = true;
		          break;
		        }
		      }
		    }
		    return canSplit[input.length()];
		  }
}
