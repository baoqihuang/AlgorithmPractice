
public class ToHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hex(4096));
		
	}
	
	public static String hex(int number) {
	    // Write your solution here
	    StringBuilder result = new StringBuilder("0x");
	    if (number == 0) {
	      result.append("0");
	      return result.toString();
	    }
	    char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
//	    boolean leadZero = false;
	    for (int i = 28; i >= 0; i-= 4) {
	      char cur = base[(number >> i) & 0xF];
	      if(cur != '0' || (cur == '0' && result.length() != 2)) {
	        result.append(cur);
	      } 
	    }
	    return result.toString();
	  }

}
