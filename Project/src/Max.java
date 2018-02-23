
public class Max {
	public static void main(String[] args) {
		int i = 34;
		int j = 55;
		int k = max(i, j);
		System.out.println("The maximum between " + i + " and " + j + " is " + k);
		
	}
	private static int max(int num1, int num2) {
		int result;
		
		if (num1 > num2) {
			result = num1;
		}
		else {
			result = num2;
		}
		return result;
	}
}