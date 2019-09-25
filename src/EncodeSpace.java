
public class EncodeSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encode(" "));
	}
	
	public static String encode(String input) {
	    if (input == null || input.length() == 0) {
	      return input;
	    }
	    int numOfSpaces = 0;
	    for (int i = 0; i < input.length(); i++) {
	      if (input.charAt(i) == ' ') {
	        numOfSpaces++;
	      }
	    }
	    char[] result = new char[input.length() + numOfSpaces * 3];
	    int j = 0;
	    for (int i = 0; i < input.length(); i++) {
	      if (input.charAt(i) == ' ') {
	        result[j] = '2';
	        result[j + 1] = '0';
	        result[j + 2] = '%';
	        j += 3;
	      } else {
	        result[j] = input.charAt(i);
	      }
	    }
	    return new String(result);
	  }
}
