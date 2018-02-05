import java.util.*;

public class Problem4_21 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a SSN: ");
		String ssn = input.next();

		for (int i = 0; i <= 10 ; i++) {
			if (ssn.length() == 11) {
				if (Character.isDigit(ssn.charAt(i))) {
					}
				else if ((ssn.charAt(i) == '-') && (ssn.charAt(i) == '-')){
				}
				else {
					System.out.print(ssn + " is not a valid social security number.");
					System.exit(1);
				}
				}
			else {
				System.out.print(ssn + " is not a valid social security number.");
				System.exit(1);
				}
			}
		System.out.print(ssn + " is a valid social security number.");
	}
}