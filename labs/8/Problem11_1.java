import java.util.*;

public class Problem11_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the sides of the triangle: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		Triangle triangle = new Triangle(side1, side2, side3);
		System.out.print("Do you want to fill the triangle with color? ");
		String ans = input.next();
		if(ans.equals("yes")) {
			triangle.setFilled(true);
			System.out.print("Enter the color to be fill: ");
			triangle.setColor(input.next());
		}
		System.out.println("Triangle is filled: " + triangle.isFilled());
		System.out.println("Triangle Color: " + triangle.getColor());
		System.out.println(triangle.toString());
	}
}