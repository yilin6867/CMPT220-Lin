import java.util.Scanner;

public class Problem10_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a positive integer: ");
		int posiInt = input.nextInt();
		if (posiInt <= 0) {
			System.out.println(posiInt + " is not a positive number");
			System.exit(0);
		}
		StackOfIntegers stack = new StackOfIntegers();
		for (int i = 2; i <= posiInt; i++) {
			if (posiInt % i == 0) {
				posiInt = posiInt / i;
				stack.push(i);
				i = 1;
			}
		}
		while (stack.getSize() != 0) {
			System.out.print(stack.pop());
		}
	}
}