import java.util.Scanner;

public class Program9_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a, b, c, d, e, f: ");
		LinearEquation equation = new LinearEquation(input.nextDouble(), input.nextDouble(),
				input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble());
		if (equation.isSolvable()) {
			System.out.println("X is " + equation.getX() + " and Y is " + equation.getY());
		}
		else {
			System.out.println("The equation has no solution");
		}
	}
}