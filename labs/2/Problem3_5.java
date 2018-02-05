import java.util.*;

public class Problem3_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<String> week = Arrays.asList("Sunday","Monday", "Tuesday", "Wednesday", "Thursday"
				,"Friday", "Saturday");
		System.out.print("Enter today's day : ");
		int today = input.nextInt();
		String day = week.get(today);
		System.out.print("Enter the number of days elapsed since today: ");
		int elapseDay = input.nextInt();
		int dayPast = elapseDay % 7;
		int futureDay = today + dayPast;
		if (futureDay > 6 )
			futureDay = futureDay - 7;
		String nextDay = week.get(futureDay);
		System.out.print("Today is " + day + " and the future day is " + nextDay + ".");
		
		
	}
}