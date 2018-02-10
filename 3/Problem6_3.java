import java.util.*;

public class Problem6_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		if (reverse(number) != number){
			System.out.println(number + " is not a palindrome integer.");
		}
		else {
		System.out.print("The palindrome integer of integer, " + number + ", is " 
		+ reverse(number));
		}
	}
	public static int reverse(int number) {
		int reverse = 0;
		int originalNumber = number;
		while(number != 0) {
	          reverse = reverse * 10;
	          reverse = reverse + number %10;
	          number = number/10;
	      }
		if (isPalindrome(reverse, originalNumber)) {
			return reverse;
		}
		else {
			
			return reverse;
		}
	}
	public static boolean isPalindrome(int reverse, int originalNumber) {
		if (originalNumber == reverse) {
			return true;
		}
		else {
			return false;
		}
	}
}