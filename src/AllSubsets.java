import java.util.ArrayList;
import java.util.List;

public class AllSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		result = subSets("ABC");
		for(String str: result) {
			System.out.println(str);
		}
	}
	public static List<String> subSets(String set) {
	    // Write your solution here.
	    List<String> sub = new ArrayList<>();
	    if(set.equals("")){
	      return sub;
	    }
	    char[] input = set.toCharArray();
	    subSets(input, 0, new StringBuilder(), sub);
	    return sub;
	  }
	  public static void subSets(char[] input, int index, StringBuilder prefix, List<String> sub) {
	    if(index == input.length) {
	      sub.add(prefix.toString());
	      return;
	    }
	    prefix.append(input[index]);

	    subSets(input, index + 1, prefix, sub);
	    prefix.deleteCharAt(prefix.length() - 1);

	    subSets(input, index + 1, prefix, sub);

	  }
}
