
public class Problem13_9 {
	public static void main(String[] args) {
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(9);
		Circle circle3 = new Circle(9);
		System.out.println("Circle1 is equal to circle2? " + circle1.equals((circle2)));
		System.out.println("Circle2 is equal to circle3? " + circle2.equals((circle3)));
	}
}
