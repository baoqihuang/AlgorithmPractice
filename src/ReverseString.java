
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("ababab"));
	}
	public static String reverse(String input) {
	    // Write your solution here
	    if (input.length() == 0) {
	      return input;
	    }
	    char[] str = input.toCharArray();
	    int mid = str.length / 2 ;
	    for(int i = 0; i < mid; i++) {
	      if (str.length % 2 == 0) {
	        swap(str, i, 2 * mid  - 1 - i);
	      } else {
		     swap(str, i, 2 * mid - i);
	      }
	    }
	    return new String(str);
	  }
	  public static void swap (char[] input, int a, int b) {
		  System.out.println("a: " + a + " b: " + b);
	    char temp = input[a];
	    input[a] = input[b];
	    input[b] = temp;
	  }
}
