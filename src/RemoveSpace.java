
public class RemoveSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeSpaces(" I Love  Yahoo "));
	}
	public static String removeSpaces(String input) {
	    // Write your solution here
	    //_ _ a b _ _ c d _ _
	    //a b a b _ _ c d _ _
	    //c1  c   s
	    StringBuilder inputChars = new StringBuilder(input);
	    int contain = 0;
	    for (int search = 0; search < inputChars.length(); search++) {
	      if (inputChars.charAt(search) != ' ') {
	        inputChars.setCharAt(contain, inputChars.charAt(search));
	        contain++;
	      } else if (contain != 0 && inputChars.charAt(contain - 1) != ' '){
	        inputChars.setCharAt(contain, inputChars.charAt(search));
	        contain++;
	      }
	    }
      if(contain > 0 && inputChars.charAt(contain - 1) == ' ') {
        contain --;
      }
	    inputChars.delete(contain, inputChars.length());
	    return inputChars.toString();
	  }

}
