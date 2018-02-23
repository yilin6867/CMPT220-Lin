import java.util.Scanner;

public class EvenOrOdd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer value: ");
		int number = input.nextInt();
		
		if (number % 2 == 0) {
			System.out.println("The number is an even number.");
		}
		else {
			System.out.println("The number is an odd number.");
		}
	}
	
}