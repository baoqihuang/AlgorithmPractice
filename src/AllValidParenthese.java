import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidParenthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		result = validParentheses(3, 2, 2);
		for (String str : result) {
			System.out.println(str);
		}
	}
	//Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

	//Assumptions

	//l, m, n >= 0
	//l + m + n > 0
	//Examples

	//l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
	private static final char[] PS = new char[] {'(', ')', '[', ']', '{', '}'};


	public static List<String> validParentheses(int l, int m, int n) {
		int[] remain = new int[] {l, l, m, m, n, n};
		int targetLen = 2 * (l + m + n);
	    StringBuilder cur = new StringBuilder();
	    Deque<Character> stack = new ArrayDeque<>();
		List<String> result = new ArrayList<>();
	    helper(cur, stack, remain, targetLen, result);
	    return result;
	}
	public static void helper(StringBuilder cur, Deque<Character> stack, int[] remain, int targetLen, List<String> result) {
		if (cur.length() == targetLen) {
			result.add(cur.toString());
			return;
		}
		for (int i = 0; i < remain.length; i++) {
			if (i % 2 == 0) {
				if (remain[i] > 0) {
					cur.append(PS[i]);
					stack.offerFirst(PS[i]);
					remain[i]--;
					helper(cur, stack, remain, targetLen, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.pollFirst();
					remain[i]++;
				}
			} else {
				if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
					cur.append(PS[i]);
					stack.pollFirst();
					remain[i]--;
					helper(cur, stack, remain, targetLen, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.offerFirst(PS[i - 1]);
					remain[i]++;
				}
			}
		}
	}
}


















