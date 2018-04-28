

import java.util.Scanner;

public class Problem18_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string to be search: ");
		String str = input.next();
		System.out.print("Enter a letter to search for: ");
		char a = input.next().charAt(0);
		System.out.println("In string, " + str + ", there is " + count(str, a) + " occured");
	}
	public static int count(String str, char a) {
		if (str.isEmpty()) {
			System.out.println("This is an empty string");
			return 0;
		}
		else {
			int high = 0;
			return count(str, a, high);
		}
	}
	public static int count(String str, char a, int high) {
		if (str.indexOf(a) == -1) {
			return high;
		}
		else {
			str = str.substring(str.indexOf(a) + 1);
			return count(str, a, high +1);
		}
	}
}
