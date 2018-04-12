class Rectangle extends GeometricObject implements Colorable{
	double height = 1;
	double width = 1;
	Rectangle() {
	}
	Rectangle(double newHeight, double newWidth) {
		height = newHeight;
		width = newWidth;
	}
	@Override
	public double getArea() {
		return height * width;
	}
	@Override
	public double getPerimeter() {
		return (2 * height) + (2 * width);
	}
	@Override
	public String howToColor() {
		// TODO Auto-generated method stub
		return "Color all four sides";
	}
}