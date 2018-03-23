
public class Circle2D {
	private double x;
	private double y;
	private double radius;
	
	public Circle2D () {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public double getRaidus() {
		return radius;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getArea() {
		double area = Math.PI * Math.pow(this.radius, 2);
		return area;
	}
	public double getPerimeter() {
		double perimeter = 2 * Math.PI * this.radius;
		return perimeter;
	}
	public boolean contain(double x, double y) {
		double cSquare = Math.pow(x, 2) + Math.pow(y, 2);
		double c = Math.sqrt(cSquare);
		if (c <= this.radius) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean contain(Circle2D circle) {
		if (this.getArea() > circle.getArea() && this.radius - (this.x + circle.radius) >= 0
				&& this.radius - (this.y + circle.radius) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean overlaps(Circle2D circle) {
		if (this.radius > (circle.x - circle.radius) 
				&& this.radius > (circle.y - circle.radius)) {
			return true;
		}
		else {
			return false;
		}
	}
}
