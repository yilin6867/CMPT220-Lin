
public class Problem13_7 {
	public static void main(String[] args) {
		GeometricObject[] squares = {new Square(), new Triangle(), new Rectangle(2, 4), new Square(3),
				new Square(4)};
		for (int i = 0; i < squares.length; i++) {
			System.out.println("Geometric Object " + (i + 1));
			System.out.println("Area: " + squares[i].getArea());
			System.out.println("Perimeter: " + squares[i].getPerimeter());
			System.out.println("Colorable: " + squares[i].howToColor());
		}
	}
}
