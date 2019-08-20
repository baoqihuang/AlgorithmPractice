package finalExam;

import java.util.ArrayList;
import java.util.List;

public class Q1_InsertSpaceInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllInsertedSpace("ABCD");
	}
	public static void printAllInsertedSpace (String input) {
		  if (input == null || input.length() == 0) {
		    return;
		  }
		  List<String> res = new ArrayList<>();
		  helper(input, 1, new StringBuilder().append(input.charAt(0)), res);
		  for (String s : res) {
			  System.out.println(s);
		  }
	}

	public static void helper(String input, int index, StringBuilder sb, List<String> res) {
		  if (index == input.length()) {
		    res.add(sb.toString());
		    return;
		  }
		  sb.append('_').append(input.charAt(index));
		  helper(input, index + 1, sb, res);
		  sb.delete(sb.length() - 2, sb.length());
		  sb.append(input.charAt(index));
		  helper(input, index + 1, sb, res);
		  sb.deleteCharAt(sb.length() - 1);
	}

}
