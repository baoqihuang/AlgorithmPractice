
public class KeepDistanceForIdenticalElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = new int[10];
		res = keepDistance(3);
		System.out.println("result:  ");
		
		for (int i : res) {
			System.out.print(i + ", ");
		}
	}
	public static int[] naiveMethod (int k) {
		int[] result = new int[k * 2];
		boolean exist = false;
		boolean isFirst = true;
		for (int i = 1; i <= k; i++) { //the cur num
			for (int j = 0; j < k; j++) { //the cur index
				if (isFirst && result[j] == 0) {
					result[j] = i;
				}
			}
		}
		return exist ? result : null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[] keepDistance(int k) {
	    int[] array = new int[2 * k];
	    for (int i = 0; i < k; i++) {
	      array[i * 2] = i + 1;
	      array[i * 2 + 1] = i + 1;
	    }
	    boolean[] used = new boolean[k + 1];
	    return helper(array, 0, used) ? array : null;
	  }
	  private static boolean helper(int[] array, int index, boolean[] used) {
	    if (index == array.length) {
	      return true;
	    }
	    for (int i = index; i < array.length; i++) {
	      int cur = array[i];
	    	System.out.println("cur: " + cur + " i: " + i + " index: " + index + " used[cur]: " + used[cur]);
	      if (!used[cur] || (index > cur && array[index - cur - 1] == cur)) {
	        swap(array, index, i);
	        used[cur] = !used[cur];
	        if (helper(array, index + 1, used)) {
	          return true;
	        }
	        swap(array, index, i);
	        used[cur] = !used[cur];
	      }
	    }
	    return false;
	  }
	  private static void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }

}
