import java.util.*;
public class Problem5_16 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the integer to be factor: ");
		double integer = input.nextInt();
		double divisor = 2;
		double remainder = 0;
		String factor = "";
		while(integer != 1.0) {
			remainder = integer / divisor;
			while (remainder - (int)remainder == 0) {
				integer = remainder;
				factor = factor + " " +(Integer.toString((int)divisor));
				remainder = integer / divisor;
			}
			while ((integer / divisor) != (int)(integer  / divisor) && integer != 1.0) {
				divisor = divisor + 1;
			}
		}
		System.out.println("The factor is: " + factor);
	}
}