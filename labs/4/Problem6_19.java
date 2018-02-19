import java.util.*;
import java.math.*;

public class Problem6_19 {
	public static void main(String[] ags) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the length of threes of the triangle: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		if (isValid(side1, side2, side3)) {
			System.out.println("The area of the triangle is " + 
		area(side1, side2, side3));
		}
		else {
			System.out.println("The input length are not the sides of a triangle.");
		}
	}
	public static boolean isValid(double side1, double side2, double side3) {
		if ((side1 + side2) > side3) {
			if ((side3 + side1) > side2) {
				if ((side2 + side3) > side1) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public static double area(double side1, double side2, double side3) {
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt( (s) * (s - side1) * (s - side2) * (s - side3));
		return area;
	}
}