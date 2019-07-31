
public class DecompossString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decompress("j1h3l5j0n3j0h4"));
	}
	
	public static String decompress(String input) {
	    // Write your solution here
	    if (input.isEmpty()) {
	      return input;
	    }
	    char[] chars = input.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < chars.length; i++) {
	    	char c = chars[i++];
	    	int digit = chars[i] - '0';
	    	for (int count = 0; count < digit; count++) {
	    		sb.append(c);
	    	}
	    }
	    return sb.toString();

	 }
}
