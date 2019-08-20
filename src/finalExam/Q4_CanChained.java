package finalExam;


public class Q4_CanChained {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[] {"aaa", "bbb", "baa", "aab"}; 
		System.out.println(canChained(input));
	}
	/*
	 * #4 

Given an array of strings, find if all the strings can be chained to form a circle.
 Two string s1 and s2 can be chained, iff the last letter of s1 is identical to the first letter of s2.

 For example, 

“abc” and “cd” can be chained, 

“abc” and “dz” can not be chained.

 Example Input: 

arr[] = {"aaa", "bbb", "baa", "aab"}; 

Output: True, 



The given input strings can be chained to form a circle. The strings can be chained as "aaa", "aab", "bbb" and "baa"
	 */
	public static boolean canChained (String [] input) {
		if (input == null || input.length == 0) {
			return true;
		}
		if (input.length == 1 && canConnected(input[0], input[0])) {
			return true;
		}
		return helper(input, 1);
	}
	public static boolean helper(String[] input, int index) {
		if (index == input.length) {
			return canConnected(input[input.length - 1], input[0]);
		}	
		for (int i = index;i < input.length; i++) {
			swap(input, i, index);
			if (canConnected(input[index - 1], input[index])) {
				if (helper(input, index + 1)) {
					return true;
				}
			}
			swap(input, i, index);
		}
		return false;
	}
	public static void  swap (String[] input, int a ,int b) {
		String temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	public static boolean canConnected (String s1, String s2) {
		return s1.charAt(s1.length() - 1) == s2.charAt(0);
	}

}
