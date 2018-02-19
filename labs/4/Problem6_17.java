import java.util.*;

public class Problem6_17 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n: ");
		int num = input.nextInt();
		printMatrix(num);
	}
	public static void printMatrix(int n) {
		for (int i = 1; i <= n; i++) {
			Random randomNum = new Random();
			System.out.print(randomNum.nextInt(2));
			for (int j = 1; j <= 2; j++) {
				System.out.print(randomNum.nextInt(2));
			}
			System.out.println();
		}
	}
}