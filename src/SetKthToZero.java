
public class SetKthToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = new int[32];
		int i = 1;
		i = ~ (i << 3);
		int j = 2; 
		j --;
		j = ~j;
		
		res = toBinary(1);
		for (Integer bit : res) {
			System.out.print(bit + " ");
		}
	}
	public static void setKthToZero (int num, int k) {
		
	}
	
	public static int[] toBinary (int num) {
		int[] result = new int[32];
		result[0] = num >= 0 ? 0 : 1;
		int k = 0;
		for (int i = 31; i >= 1; i--) {
			result[i] = 1 & (num >> k);
			k++;
		}
		return result;
	}
}
