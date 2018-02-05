import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem3_11 {
	public static void main(String[] args) {
		List<String> monthDay = Arrays.asList("","31","","31","30","31","30","31","31","30",
				"31","30","31");
		List<String> mon = Arrays.asList("","January","Feburary", "March", "April", "May", "June",
				"July", "August","September", "October", "November", "December");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Month: ");
		int numMonth = input.nextInt();
		System.out.print("Enter the Year: ");
		int numYear = input.nextInt();
		
		if (numMonth != 2 && numYear % 4 != 0) {
			System.out.println(mon.get(numMonth) +" "+ numYear + " had "+ monthDay.get(numMonth)
			+ " days.");
		}
		else if (numMonth == 2 && numYear % 4 != 0) {
			System.out.println(mon.get(numMonth) +" "+ numYear + " had 28 days.");
		}
		else 
			System.out.println(mon.get(numMonth) +" "+ numYear + " had 29 days.");
	}
}