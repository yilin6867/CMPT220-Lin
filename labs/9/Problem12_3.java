import java.util.Scanner;

public class Problem12_3 {
	public static void main(String[] args) {
		try {
			int[] integers = new int[100];
			for (int i = 0; i < integers.length; i++) {
				integers[i] = (int) (Math.random()*100);
			}
			System.out.print("Enter an index of the array: ");
			Scanner input = new Scanner(System.in);
			int index = input.nextInt();
			System.out.println("In index " + index + " is " + integers[index]);
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds");
		}
	}
}