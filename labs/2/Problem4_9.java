import java.util.*;

public class Problem4_9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a character: ");
		char character = input.next().charAt(0);
		System.out.println("The Unicode for character " + character + " is " + (int)character);
	}
}