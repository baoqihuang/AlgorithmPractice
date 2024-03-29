import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LargestProductOfLength {

	public static void main(String[] args) {
		
	}
	public int largestProduct(String[] dict) {
		Map<String, Integer> marks = getMark(dict);
		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare (String st1, String st2) {
				if (st1.length() == st2.length()) {
					return 0;
				}
				return st1.length() < st2.length() ? 1 : -1;
			}
		});
		int largest = 0;
		for (int i = 1; i < dict.length; i++) {
			for (int j = 0; j < i; j++) {
				int prod = dict[i].length() * dict[j].length();
				if (prod <= largest) {
					break;
				}
				int iMark = marks.get(dict[i]);
				int jMark = marks.get(dict[j]);
				if ((iMark & jMark) == 0) {
					largest = prod;
				}
			}
		}
		return largest;
	}
	public Map<String, Integer> getMark (String[] dict) {
		Map<String, Integer> map = new HashMap<>();
		for (String str : dict) {
			int mark = 0; 
			for (int i = 0; i < str.length(); i++) {
				mark |= 1 << (str.charAt(i) - 'a');
			}
			map.put(str, mark);
		}
		return map;
	}

}





















