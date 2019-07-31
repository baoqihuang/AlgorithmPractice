
public class RemoveAjacentDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String result = deDup("abccdd");
//		//                     abcd    
//		char[] p = result.toCharArray();
//		for(char c : p) {
//			System.out.print(c + ",");
//		}
		
		String result1 = deDupRepeat("aabccdccccccccccccsd");
		//                     abcd    
		char[] p1 = result1.toCharArray();
		for(char c : p1) {
			System.out.print(c + ",");
		}
	}
	
	public static String deDup(String input) {
	    // Write your solution here
	    if (input == null || input.length() <= 1) {
	      return input;
	    }
	    StringBuilder chars = new StringBuilder(input);
	    //Set<Character> dup = new HashSet<>();
	    //abdceftg
	    int contain = 1;
	    for (int search = 1; search < input.length(); search++) {
	    	if(chars.charAt(search) != chars.charAt(contain - 1)) {
	    		chars.setCharAt(contain, chars.charAt(search));
	    		contain++;
	    	}
	    }
//	    if(contain <= input.length()) {
//	    	contain--;
//	    }
	    chars.delete(contain, input.length());
	    return chars.toString();
	 }
	
	public static String deDupRepeat(String input) {
	    // Write your solution here
	    if (input == null || input.length() <= 1) {
	      return input;
	    }
	    char[] str = input.toCharArray();
	    int contain = 0;
	    for (int search = 1; search < str.length; search++) {
	    	System.out.println("contain: " + contain + " search: " + search);
	      if (contain != -1 && str[contain] == str[search]) {
	        while (search < str.length && str[search] == str[contain]) {
	          search ++;
	        }
	        search --;
	        contain --;
	      } else {
	        str[++contain] = str[search];
	      }
	    }
	    if (contain == -1) {
	      return "";
	    }
	    return new String(str, 0, contain + 1);
	  }

}
