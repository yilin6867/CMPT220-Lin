
public class CircleAreaPerimeter {
	public static void main(String[] args) {
		double r = 3.5;
		double PI = 3.14159;
		
		double area = PI * r * r;
		double perimeter = 2 * PI * r;
		
		System.out.println("The radius of the circle is " + r);
		System.out.println("The area of the circle is " + area);
		System.out.println("The perimeter of the circle is " + perimeter);
	}
}