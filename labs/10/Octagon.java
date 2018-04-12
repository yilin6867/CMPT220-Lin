
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
	private double side;
	private int numberOfSides = 8;
	
	Octagon() {
		this.side = 0;
	}
	Octagon(double side) {
		this.side = side;
	}
	@Override
	public String howToColor() {
		return "Color all eight sides";
	}

	@Override
	public double getArea() {
		return ((2 + (4 / Math.sqrt(2))) * this.side * this.side);
	}

	@Override
	public double getPerimeter() {
		return side * 8;
	}
	@Override
	public String toString() {
		return "The area is " + getArea() + "\n" +"The perimeter is " + getPerimeter() + "\n" + howToColor();
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	public int getNumberOfSides() {
		return numberOfSides;
	}
	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	@Override
	public int compareTo(Octagon octagon) {
		if (getArea() > octagon.getArea() && getPerimeter() > octagon.getPerimeter() &&
				getSide() > octagon.getSide() && getNumberOfSides() > octagon.getNumberOfSides()) {
			return 1;
		}
		else if (getArea() == octagon.getArea() && getPerimeter() == octagon.getPerimeter() &&
				getSide() == octagon.getSide() && getNumberOfSides() == octagon.getNumberOfSides()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	@Override
	public Object clone() {
		try {
			Octagon octagonClone = (Octagon) super.clone();
			return octagonClone;
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}
