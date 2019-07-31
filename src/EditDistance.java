
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(editDistance("bfgege", "afgggg"));
	}
	public static int editDistance(String one, String two) {
		    // Write your solution here
		//recursion
		//return editDistance(one, 0, two, 0);
		int[][] distance = new int[one.length() + 1][two.length() + 1];
		for (int i = 0; i <= one.length(); i++) {
			for (int j = 0; j <= two.length(); j++) {
				if (i == 0) {
					distance[i][j] = j;
				} else if (j == 0) {
					distance[i][j] = i;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)) {
					distance[i][j] = distance[i - 1][j - 1];
				} else {
					distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1));
				}
			}
			
		}
		return distance[one.length()][two.length()];
		
	}
	//this is recursiion method
	public static int editDistance (String one, int iOne, String two, int iTwo) {
		//abc     abcdef
		if (iOne == one.length()) {
			return two.length() - iTwo;
		} else if (iTwo == two.length()) {
			return one.length() - iOne;
		}
		if (one.charAt(iOne) == two.charAt(iTwo)) {
			return editDistance(one, iOne + 1, two, iTwo + 1);
		} 
		int replace = editDistance(one, iOne + 1, two, iTwo + 1) + 1;
		int delete = editDistance(one, iOne + 1, two, iTwo) + 1;
		int insert = editDistance(one, iOne, two, iTwo + 1) + 1;
		return Math.min(replace, Math.min(delete, insert));
	}
	
}
