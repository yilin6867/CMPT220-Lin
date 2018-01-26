
import java.util.Scanner;
public class Problem2_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print("Enter the number of minutes: ");
		int minutes = input.nextInt();
		int day = (minutes / 60) / 24;
		int year = day / 365;
		int days = day % 365;
		System.out.println(minutes + " minutes is apporximately " + year + " years and " + day  +
				" days.");
	}
}