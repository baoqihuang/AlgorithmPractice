
public class CanJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canJump(new int[] {1,2,0}));
	}
	private static boolean canJump(int[] array) {
	    // Write your solution here
	    int len = array.length;
	    if (len == 1) {
	      return true;
	    }
	    boolean[] canJump = new boolean[len];
	    canJump[len - 1] = true;
	    for (int i = len - 2; i >= 0; i--) {
	      int j = i + 1;
	    	System.out.println("i: " + i + " j: " + j + " canjump[i]: " + canJump[i] + " canjump[i]: " + canJump[i]);

	      while (j <= i + array[i] && !canJump[i]) {
	        if (canJump[j++]) {
	          canJump[i] = true;
	        }
	      }
	    }
	    return canJump[0];
	  }

}
