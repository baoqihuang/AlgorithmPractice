
public class IfSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strstr("abcdefghijklmnopqrstuvwxyzzabcdefghijklmnopqrstu", "qrstuvwxyzzabcdefghijklmnopqrstu"));
	}
	
	public static int strstr(String large, String small) {
	    // Write your solution here
		if (large.length() < small.length()) {
			return - 1;
		}
		if (small.length() == 0) {
			return 0;
		}
		int largePrime = 101;
		int prime = 31;
		int seed = 1;
		int targetHash = small.charAt(0) % largePrime;
		for (int i = 1; i < small.length(); i++) {
			seed = moduleHash (seed, 0, prime, largePrime);
			targetHash = moduleHash (targetHash, small.charAt(i), prime, largePrime);
		}
		int hash = 0;
		for (int i = 0; i < small.length(); i++) {
			hash = moduleHash (hash, large.charAt(i), prime, largePrime);
		}
		if (hash == targetHash && equals (large, 0, small)) {
			return 0;
		}
		for (int i = 1; i <= large.length() - small.length(); i++) {
			hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
			hash = moduleHash(hash, large.charAt(i + small.length() -1), prime, largePrime);
		
			if (hash == targetHash && equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean equals(String large, int start, String small) {
		for(int i = 0; i < small.length(); i++) {
			if(large.charAt(i + start) != small.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public static int moduleHash(int hash, int addition, int prime, int largePrime) {
		return (hash * prime % largePrime + addition) % largePrime;
	}
	public static int nonNegative(int hash, int largePrime) {
		if(hash < 0) {
			hash += largePrime;
		}
		return hash;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
