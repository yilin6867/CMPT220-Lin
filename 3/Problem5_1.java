import java.util.*;
public class Problem5_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an inter, the input ends if it is 0: ");
		int numberOfNegatives = 0;
		int numberOfPositives = 0;
		int number = 1;
		double average = 0;
		double total = 0;
		int count = 0;
		while(number != 0) {
			number = input.nextInt();
			total = total + number;
			if (number < 0) {
				numberOfNegatives++;
			}
			else if(number > 0) {
				numberOfPositives++;
			}
			else {
				break;
			}
			count++;
		}
		if (total == 0 && count == 0) {
			System.out.println("No numbers are entered except 0");
		}
		else {
		average = total /(float) count;
		System.out.println("The number of positives is " + numberOfPositives);
		System.out.println("The number of negatives is " + numberOfNegatives);
		System.out.println("The total is " + total);
		System.out.println("The average is " + average);
		}
	}	
}