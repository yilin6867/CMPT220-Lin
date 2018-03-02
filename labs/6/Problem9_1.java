import java.util.*;

public class Problem9_1 {
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(40, 4);
		Rectangle rectangle2 = new Rectangle(35.9, 3.5);
		System.out.println("The area of rectangle with width, " + rectangle1.width + 
				", and height, " + rectangle1.height + ", is " + rectangle1.getArea());
		System.out.println("The area of rectangle with width, " + rectangle2.width + 
				", and height, " + rectangle2.height + ", is " + rectangle2.getArea());
		System.out.println("The perimeter of rectangle with width, " + rectangle1.width + 
				", and height, " + rectangle1.height + ", is " + rectangle1.getPerimeter());
		System.out.println("The perimeter of rectangle with width, " + rectangle2.width + 
				", and height, " + rectangle2.height + ", is " + rectangle2.getPerimeter());
		
	}
}
