package mid2;

import java.util.ArrayList;
import java.util.List;

public class Q1_NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<>();
		res = nQueen(8);
		int count = 0;
		for (List<Integer> cur : res) {
			for (int col : cur) {
				System.out.print(col + " ,");
			}
			System.out.println();
			count++;
		}
		System.out.println(count);
	}
	public static List<List<Integer>> nQueen(int numQueen) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numQueen <= 0) {
			return res;
		}
		List<Integer> cur = new ArrayList<>();
		nQueen(res, cur, numQueen);
		return res;
	}
	public static void nQueen(List<List<Integer>> res, List<Integer> cur, int n) {
		if (cur.size() == n) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!ifConflict(cur, i)) {
				cur.add(i);
				nQueen(res, cur, n);
				cur.remove(cur.size() - 1);
			}
		}
	}
	public static boolean ifConflict(List<Integer> cur, int curColumn) {
		boolean ifC = false;
		int curRow = cur.size();
		for (int i = 0; i < curRow; i++) {
			if (curColumn == cur.get(i) || (curRow - i == Math.abs(curColumn - cur.get(i)))) {
				return true;
			}
		}
		return ifC;
	}

}
