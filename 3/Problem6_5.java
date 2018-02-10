import java.util.*;

public class Problem6_5 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three number to be sort from smalles to largest: ");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
		displaySortedNumber(num1, num2, num3);
	}
	public static void displaySortedNumber(double num1, double num2, double num3) {
		if (num1 > num2 && num1 > num3) {
			if(num2 > num3) {
				System.out.println("The number are sort in following order: " +
						num3 + ", " + num2 + ", " + num1 + ".");
			}
			else {
				System.out.println("The number are sort in following order: " +
						num2 + ", " + num3 + ", " + num1 + ".");
			}
		}
		else if (num2 > num1 && num2 > num3) {
			if (num1 > num3) {
				System.out.println("The number are sort in following order: " +
						num3 + ", " + num1 + ", " + num2 + ".");
			}
			else {
				System.out.println("The number are sort in following order: " +
						num1 + ", " + num3 + ", " + num2 + ".");
			}
		}
		else {
			if (num1 > num2) {
				System.out.println("The number are sort in following order: " +
						num2 + ", " + num1 + ", " + num3 + ".");
			}
			else {
				System.out.println("The number are sort in following order: " +
						num1 + ", " + num2 + ", " + num3 + ".");
			}
		}
	}
}