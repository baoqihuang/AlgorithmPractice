package mid2;

public class MinCutPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(minCutPalindrome("abaccbbccaba"));
	}
	/*
	 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
	 *  For example, “aba |b | bbabb |a| b| aba” is a palindrome partitioning of “ababbbabbababa”. 
	 *  Determine the fewest cuts needed for palindrome partitioning of a given string. 
	 *  For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”. 
	 *  If a string is palindrome, then minimum 0 cuts are needed. aba | b | bbabb | a | b | aba - 5 cuts
	 *  a | babbbab | b | ababa - 3 cuts
	 */
	public static int minCutPalindrome(String input) {
		if (input.length() <= 1) {
			return 0;
		}
		int minCut[] = new int[input.length()];
		minCut[0] = 0;
		for (int i = 1; i < input.length(); i++) {
			if (isPal(input, 0, i)) {
				minCut[i] = 0;
				continue;
			}
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (minCut[j] >= 0 && isPal(input, j + 1, i)) {
					min = Math.min(min, minCut[j] + 1);
				}
			}
			minCut[i] = min;
		}
		
		
		return minCut[input.length() - 1];
	}
	//determine if the substring of string is palindrome from start inclusive and end inclusive
	public static boolean isPal(String input, int start, int end) {
		boolean isPal = true;
		while (start <= end) {
			if (input.charAt(start) == input.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return isPal;
	}
}
