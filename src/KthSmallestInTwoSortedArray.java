
public class KthSmallestInTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kthRecursive(new int[]{1,2,3,4}, new int[]{5}, 5));
	}
	public static int kth(int[] a, int[] b, int k) {
	    if (a.length == 0) {
	      return b[k - 1];
	    }
	    if (b.length == 0) {
	      return a[k - 1];
	    }
	    int ai = 0;
	    int bi = 0;
	    while (ai < a.length && bi < b.length && k >= 1) {
	      if (k == 1) {
	        return Math.min(a[ai], b[bi]);
	      }
	      int avl = (ai + k/2 - 1) >= a.length ? Integer.MAX_VALUE : a[ai + k/2 - 1];
	      int bvl = (bi + k/2 - 1) >= b.length ? Integer.MAX_VALUE : b[bi + k/2 - 1];
	      if (avl <= bvl) {
	        ai = ai + k / 2;
	      } else {
	        bi = bi + k / 2;
	      }
	      k -= (k / 2);
	    }
	    return ai >= a.length ? b[bi + k - 1] : a[ai + k - 1];
	}
	
	//recursive method
	public static int kthRecursive (int[] a, int[] b, int k) {
		return helper(a, 0, b, 0, k);
	}
	public static int helper(int[] a, int ai, int[] b, int bi, int k) {
		//base case
		if (ai >= a.length) {
			return b[bi + k - 1];
		}
		if (bi >= b.length) {
			return a[ai + k - 1];
		}
		if (k == 1) {
			return Math.min(a[ai], b[bi]);
		}
		int aMid = ai + k / 2 - 1;
		int bMid = bi + k / 2 - 1;
		int aval = aMid >= a.length ? Integer.MAX_VALUE : a[ai + k / 2 - 1];
		int bval = bMid >= b.length ? Integer.MAX_VALUE : b[bi + k / 2 - 1];
		if (aval <= bval) {
			return helper(a, aMid + 1, b, bi, k - k / 2);
		} else {
			return helper(a, ai, b, bMid + 1, k - k / 2);
		}
	}
}
