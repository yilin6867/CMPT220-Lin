import java.util.Scanner;
public class CircleArea {
	static final double PI = 3.14159;
	//final make the variable unchangeable
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a radisu value for the circle: ");
		double radius = input.nextDouble();
		
		double area = PI * radius * radius;
		
		System.out.println("The area of the circle is: " + (int)(area * 1000) / 1000.);
	}
}