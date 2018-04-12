
public class Circle extends GeometricObject implements Comparable<Circle> {

	private double x = 0;
	private double y = 0;
	private double radius;
	
	public Circle() {
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getRadius() {
		return radius;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public String howToColor() {
		// TODO Auto-generated method stub
		return "Color the area";
	}
	@Override
	public boolean equals(Object obj) {
		if (this.compareTo((Circle)obj) == -1 || this.compareTo((Circle)obj) == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public int compareTo(Circle circle) {
		// TODO Auto-generated method stub
		if (getRadius() < circle.getRadius()) {
			return -1;
		}
		else if (getRadius() == circle.getRadius()) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
