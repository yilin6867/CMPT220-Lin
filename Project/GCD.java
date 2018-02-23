import java.util.*;

public class GCD {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//read two #
		System.out.print("Enter the first integer: ");
		int n1 = input.nextInt();
		System.out.print("Enter the second integer: ");
		int n2 = input.nextInt();
		
		
		System.out.print("The greatest common divisor for " + n1 + " and " + n2 + " is "
		+ gcd(n1,n2));
	}
	public static int gcd(int n1, int n2) {
		//calculate GCD
		int gcd = 1; //initial gcd
		int k = 1;// potential gcd
			
		while (k <= n1 && k <= n2) {
			if (n1 % k == 0 && n2 % k ==0) {
				gcd = k; //update gcd
				}
			k++;
		}
		return gcd;
	}
}