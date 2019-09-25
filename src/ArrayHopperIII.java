
public class ArrayHopperIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minJump(new int[]{4,2,1,3,0,0}));
	}
	public static int minJump(int[] array) {
	    // Write your solution here
	    int[] min = new int[array.length + 1];
	    //min[0] = array[0] > 0 ? 1 : -1;
	    for (int i = 1; i < min.length; i++) {
	      min[i] = -1;
	      for (int j = 0; j < i; j++) {
	        if (min[j] != -1 && array[j] + j >= i) {
	          if (min[i] == -1 || min[j] + 1 < min[i]) {
	            min[i] = min[j] + 1;
	          }
	        }
	      }
	      //System.out.println("i: " + i + " min[i]: "+min[i]);
	    }
	    return min[array.length];
	}
}
