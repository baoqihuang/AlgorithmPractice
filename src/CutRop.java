
public class CutRop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProduct(25));
	}
	public static int maxProduct(int length) {
		//dfs
		//if (length == 1) {
		//	return 0;
		//}
		//int product = 0;
		//for (int i = 1; i < length; i++) {
		//	int best = Math.max(maxProduct(length - i), length - i);
		//	product = Math.max(best * i, product);
		//}
		//return product;
		
		//dp
		if (length == 1) {
			return 0;
		}
		int[] max = new int[length + 1];
		max[1] = 0;
		max[2] = 1;
		for (int i = 3; i <= length; i++) {
			for (int j = 1; j <= i / 2; j++) {
				max[i] = Math.max(max[i], j * Math.max(i - j, max[i - j]));
			}
		}
		return max[length];
	}

}
