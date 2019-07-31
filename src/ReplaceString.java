import java.util.ArrayList;
import java.util.List;

public class ReplaceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replace("applecatapp", "app", "un"));
		
	}
	public static String replace(String input, String source, String target) {
	    // Write your solution here
	    if (input.length() < source.length()) {
	      return input;
	    }
	    int prime = 31;
	    int largePrime = 101;
	    int seed = 1;
	    int targetHash = source.charAt(0) % largePrime;
	    for (int i = 1; i < source.length(); i++) {
	      seed = moduleHash(seed, 0, prime, largePrime);
	      targetHash = moduleHash(targetHash, source.charAt(i), prime, largePrime);
	    }
	    int curHash = 0;
	    for (int i = 0; i < source.length(); i++) {
	      curHash = moduleHash(curHash, input.charAt(i), prime, largePrime);
	    }
	    List<Integer> appearIndex = new ArrayList<>();
	    if (targetHash == curHash && equals(source, input, 0)) {
	      appearIndex.add(0);
	    }
	    int i = 1;
	    if (!appearIndex.isEmpty()) {
	      i = source.length();
	    }
	      System.out.println("iiiicurHash: " + curHash + " iiiitargetHash: " + targetHash + " size " + appearIndex.size());
	    while (i <= input.length() - source.length()) {
	    	
	      curHash = nonNegative(curHash - seed * input.charAt(i - 1) % largePrime, largePrime);
	      curHash = moduleHash(curHash, input.charAt(i + source.length() - 1), prime, largePrime);
	      System.out.println("curHash: " + curHash + " targetHash: " + targetHash + " size " + appearIndex.size() + " i " + i);
			//System.out.println(replace("applecatapp", "app", "un"));

	      if (targetHash == curHash && equals(source, input, i)) {
	        appearIndex.add(i);
	      }
	      i++;
	    }
	    for (Integer j : appearIndex) {
	    	System.out.println(j);
	    }
	    if (target.length() <= source.length()) {
	      char[] inputArray = input.toCharArray();
	      int contain = shorter(appearIndex, inputArray, target, source);
	      return new String(inputArray, 0, contain);
	    }
	    char[] result = new char[input.length() + (target.length() - source.length()) * appearIndex.size()];
	    //System.out.println("len: " + result.length);
	    longer(appearIndex, result, input, source, target);
	    return new String(result);
	  }
	  public static int shorter(List<Integer> list, char[] input, String target, String source) {
	    int contain = 0;
	    int j = 0;
	    int i = 0;
	    int index = 0;
	    while (i < input.length) {
	    	//System.out.println("i: " + i);
	    	if (j < list.size()) {
	    		index = list.get(j);
	    	}
	      if(index != i) {
	    	  //System.out.println("budengyu");
	        input[contain++] = input[i++];
	      } else {
	    	  //System.out.println("degnyu");
	        copyString(contain, input, target);
	        contain += target.length();
	        i += source.length();
	        System.out.println(new String(input) + " i " +  i + " contain " + contain);
	        j++;
			//System.out.println(replace("aaa", "aa", "b"));

	      }
	    }
	    return contain;
	  }
	  public static void longer(List<Integer> list, char[] result, String input, String source, String target) {
		  int j = 0;
		  int contain = 0;
		  int i = 0;
		  int index = 0;
		  while (i < result.length) {
			  if (j < list.size()) {
				  index = list.get(j);
			  }
			  if(index != contain) {
				  System.out.println("fdsfasdf");
			        result[i++] = input.charAt(contain++);
			   } else {
			       copyString(i, result, target);
			       i += target.length();
			       contain += source.length();
			        System.out.println(new String(result) + " i " +  i + " contain " + contain + " j " + j);
			        //		System.out.println(replace("ababab", "b", "ss"));

			       j++;
			        //abbbabbbabbb source = bbb target = g 
			        //agagag 
			   }
		  }
	  }
	  public static void copyString(int start, char[] input, String target) {
	    for (int i = 0; i < target.length(); i++) {
	      input[start + i] = target.charAt(i);
	    }
	  }
	  public static int moduleHash (int hash, int addition, int prime, int largePrime) {
	    return (hash * prime % largePrime + addition) % largePrime;
	  }
	  public static boolean equals (String small, String large, int start) {
	    for (int i = 0; i < small.length(); i++) {
	      if (small.charAt(i) != large.charAt(i + start)) {
	        return false;
	      }
	    }
	    return true;
	  }
	  public static int nonNegative (int hash, int largePrime) {
	    if (hash < 0) {
	      hash += largePrime;
	    }
	    return hash;
	  }

}
