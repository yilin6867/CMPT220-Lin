// JA: You had to print the 100 first pentagonal numbers
import java.util.*;

public class Problem6_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("What is the value n to calculate pentagonal number? ");
		int n = input.nextInt();
		System.out.println("The pentagonal number for value " + n + " is " 
		+ getPentagonalNumber(n));
	}
	public static int getPentagonalNumber(int n) {
		int firstStep = 3 * n;
		int secondStep = firstStep - 1;
		int thirdStep = secondStep * n;
		int finalStep = thirdStep / 2;
		return finalStep;
	}
}