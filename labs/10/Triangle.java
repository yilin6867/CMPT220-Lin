
public class Triangle extends GeometricObject implements Colorable{
	private double side1 = 3.0;
	private double side2 = 4.0;
	private double side3 = 5.0;
	
	public Triangle() {
	}
	public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
		if (side1 + side2 <= side3 || side2 + side3 <= side1 || side3 + side1 <= side2) {
			throw new IllegalTriangleException(side1, side2, side3);
		}
		else {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		}
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	public double getArea() {
		double s = (this.side1 + this.side2 + this.side3) / 2;
		double area = Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
		return area;
	}
	public double getPerimeter() {
		double perimeter = this.side1 + this.side2 + this.side3;
		return perimeter;
	}
	@Override
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
	@Override
	public String howToColor() {
		// TODO Auto-generated method stub
		return "Color all three sides";
	}
}
