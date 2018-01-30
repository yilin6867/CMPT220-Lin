
import java.util.Scanner;
public class Problem2_5 {
	//Problem 2.5
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print("Enter the Subtotal : ");
		double Subtotal = input.nextDouble(); // Variables should start with lowercase
		System.out.print("Enter the gratuity Rate: ");
		double Gratuity = input.nextDouble() / 100;
		
		double total = (Gratuity * Subtotal) + Subtotal;
		System.out.println("The gratuity is $" + (Gratuity * Subtotal) 
		+ " and total is $" + total + ".");
	}
}