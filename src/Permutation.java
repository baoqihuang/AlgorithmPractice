
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input = {'A', 'B', 'C'};
		permutation(input, 0);
	}
	
	public static void permutation(char[] input, int index) {
		if(index == input.length) {
			System.out.println(input);
			return;
		}
		
		for(int i = index; i < input.length; i++) {
			swap(input, index, i);
			permutation(input, index + 1);
			swap(input, index, i);
		}
		
	}
	public static void swap (char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
