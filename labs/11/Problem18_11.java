

import java.util.Scanner;

public class Problem18_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter an integer: ");
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		System.out.println("The sum of " + n + " is " + sumDigits(n));
	}
	public static int sumDigits(long n) {
		
		if (n <= 9) {
			return (int) n;
		}
		else {
			int num = Integer.parseInt(String.valueOf(n).substring(0, 1));
			String newNumberString = String.valueOf(n).substring(1, String.valueOf(n).length());
			n = Integer.parseInt(newNumberString);
			return num + sumDigits(n);
		}
		
	}
}
