import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSebsets2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DFS 1
		List<String>res = new ArrayList<>();
		res = subSets("aabb");
		for (String str : res) {
			
			System.out.println(str);
		}
	}
	public static List<String> subSets(String set) {
		
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helperII(arraySet, sb, 0, result);
		return result;
	}
	public static void helper (char[] set, StringBuilder sb, int index, List<String> result) {
		if (index == set.length) {
			result.add(sb.toString());
			return;
		}
		helper(set, sb.append(set[index]), index + 1, result);
		System.out.println("append: " + sb.toString());
		sb.deleteCharAt(sb.length() - 1);
		System.out.println("after delete: " + sb.toString() + " index: " + index);
		while(index < set.length - 1 && set[index] == set[index + 1]) {
			index++;
		}
		System.out.println("after skip the index: " + index);
		helper(set, sb, index + 1, result);
	}
	public static void helperII (char[] set, StringBuilder sb, int index, List<String> result) {
		result.add(sb.toString());
		for (int i = index; i < set.length; i++) {
			if (i == index || set[i] != set[i - 1]) {
				sb.append(set[i]);
				helperII(set, sb, i + 1, result);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
