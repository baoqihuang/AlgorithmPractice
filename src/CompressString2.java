
public class CompressString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aadsfaadggggggg"));
	}
	
	public static String compress(String input) {
	    // Write your solution here
	    if (input.length() <= 1) {
	      return input;
	    }
	    int contain = 0;
	    int newLen = 0;
	    int search = 0;
	    char[] chars = input.toCharArray();
	    while (search < chars.length) {
	    	System.out.println("new len in loop: " + newLen);
	      int begin = search;
	      while (search < chars.length && chars[search] == chars[begin]) {
	        search++;
	      }
	      chars[contain++] = chars[begin];
	      if (search -  begin == 1) {
	        newLen += 2;
	      } else {
	        int len = notSingleCount (chars, contain, search - begin);
	        newLen += len + 1;
	        contain += len;
	      }
	    }
	    System.out.println("new len: " + newLen);
	    char[] result = new char[newLen];
	    search = contain - 1;
	    contain = newLen - 1;
	    while (search >= 0) {
	    	System.out.println("post: search is : " + search + " contain: " + contain);
	      if (Character.isDigit(chars[search])) {
	    	  while (search >= 0 && Character.isDigit(chars[search])) {
	    		  result[contain --] = chars[search--];
	    	  }
	      } else {
	        result[contain --] = '1';
	      }
	      result[contain --] = chars[search--];
	    }
	    return new String(result);
	  }
	  public static int notSingleCount (char[] input, int index, int count) {
	    int len = 0;
	    for (int i = count; i > 0; i /= 10) {
	      index++;
	      len++;
	    }
	    for (int i = count; i > 0; i /= 10) {
	      int digit = i % 10;
	      input[--index] = (char) ('0' + digit);
	    }
	    return len;
	  }

}
