import java.util.*;

public class Problem9_3 {
	public static void main(String[] args) {
		Date date = new java.util.Date();
		long elapseTime = 10000;
		for (int i = 0; i < 8; i++) {
			date.setTime(elapseTime);
			System.out.println("The elapsed time since Jan 1, 1970 is " + date.getTime() +
					" milliseconds");
			System.out.println(date.toString());
			elapseTime = elapseTime * 10;
		}

	}
}