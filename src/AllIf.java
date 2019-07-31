
public class AllIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		possibleIf(3);
	}
	public static void possibleIf (int num) {
		  if (num == 0) {
		    return;
		  }
		  possibleIf(0, 0, num, new StringBuilder());
		}
	public static void possibleIf(int l, int r, int n, StringBuilder sb) {
		  if (l == n && r == n) {
		    sb.append("new Line");
		    System.out.println(sb.toString());
		    return;
		  }
		  if (l < n) {
		    sb.append("if {");
		    possibleIf(l + 1, r, n, sb);
		    sb.delete(sb.length() - 4, sb.length());
		  }
		  if (r < l) {
			  sb.append("}");
		    possibleIf(l, r + 1, n, sb);
		    sb.delete(sb.length() - 2, sb.length());
		  }
		}

}
