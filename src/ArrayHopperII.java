
public class ArrayHopperII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minJump(new int[] {2, 3, 4, 0}));
	}
	public static int minJump(int[] array) {
		int len = array.length;
		int[] m = new int[len];
		m[0] = 0;
		for (int i = 1; i < len; i++) {
			m[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (j + array[j] >= i && m[j] != -1) {
					//System.out.println("test");
					if (m[i] == -1 || m[i] > m[j] + 1) {
						m[i] = m[j] + 1;
						//System.out.println("inner loop: j: " + j + " i: " + i + " minjump[i]: " + m[i]);

					}
				}
			}
		}
//		for (int num : m) {
//			System.out.println(num);
//		
//		}
		
		return m[len - 1];
	}

}
