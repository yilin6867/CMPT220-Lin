import java.util.*;
public class Problem5_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		while(true) {
			System.out.print("What is the largest integer,n, such that n cubic is less than 12,000: ");
			n = input.nextInt();
			if (12000 - (n * n * n) > 0) {
				int oldN = n;
				n = n + 1;
				if (12000 - (n * n * n) < 0) {
					System.out.println(oldN + " is the largest integer such that cubic is less "
							+ "than 12000");
					break;
				}
				else {
					System.out.println(oldN + " is not the largest integer such that cubic is less "
							+ "than 12000");
				}
			}
			else {
				System.out.println("Cubic of " + n + " is larger than 12,000");
			}
		}
	}
}