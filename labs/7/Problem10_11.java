
public class Problem10_11 {
	public static void main(String[] args) {
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		Circle2D c2 = new Circle2D(4, 5, 10.5);
		Circle2D c3 = new Circle2D(3, 5, 2.3);
		System.out.println("The area of circle, c1, is " + c1.getArea());
		System.out.println("The perimeter of circle, c1, is " + c1.getPerimeter());
		System.out.println("Does c1 contain (3, 3): " + c1.contain(3, 3));
		System.out.println("Does circle, c1, contain circle with coordinate (4, 5) and "
				+ "radius 4.5 " + c1.contain(new Circle2D(4, 5, 10.5)));
		System.out.println("Does circle, c1, overlaps circle with coordinate (3, 5) and "
				+ "radius 2.3 " + c1.overlaps(new Circle2D(3, 5, 2.3)));
	}
}