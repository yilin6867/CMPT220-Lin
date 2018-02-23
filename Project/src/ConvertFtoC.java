import java.util.Scanner;
public class ConvertFtoC {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter temperture in Farenhit degree: ");
		double farenheit = input.nextDouble();
		
		double celsius = 5.0 / 9 * (farenheit - 32);
		double a = 5;

		System.out.println("The temperture in Celsius is: " + celsius);
	}
}