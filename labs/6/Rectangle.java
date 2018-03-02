class Rectangle {
	double height = 1;
	double width = 1;
	Rectangle() {
	}
	Rectangle(double newHeight, double newWidth) {
		height = newHeight;
		width = newWidth;
	}
	double getArea() {
		return height * width;
	}
	double getPerimeter() {
		return (2 * height) + (2 * width);
	}
}