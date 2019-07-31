
public class StringAbbreviationMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(match("abcegdgasdg", "3e5d1"));
	}
	public static boolean match(String input, String pattern) {
	    // Write your solution here
	    return match(input, 0, pattern, 0);
	  }
	  public static boolean match(String input, int iStart, String pattern, int pStart) {
	    if (iStart == input.length() && pStart == pattern.length()) {
	      return true;
	    } else if (iStart == input.length() || pStart == pattern.length()) {
	      return false;
	    }
	    if (Character.isLetter(pattern.charAt(pStart))) {
	      return input.charAt(iStart) == pattern.charAt(pStart) ?
	      match(input, iStart + 1, pattern, pStart + 1) : false;
	    } 
	    int i = pStart;
	    int count = 0;
	    while (i < pattern.length() && Character.isDigit(pattern.charAt(i))) {
	      count = count * 10 + (pattern.charAt(i) - '0');
	      i++;
	    }
	    return iStart + count > input.length() ? false : match(input, iStart + count, pattern, i);
	  }
}
