
public class Problem12_5 {
	public static void main(String[] args) {
		try {
			Triangle triangle = new Triangle(3, 8, 9);
			Triangle triangle2 = new Triangle(5, 5 , 10);
			System.out.println("Triangle sides: " + triangle.getSide1() + 
					" " + triangle.getSide2() + " " + triangle.getSide3() + " " + 
					"have area: " + triangle.getArea() + " and perimeter: " 
					+ triangle.getPerimeter());
			System.out.println("Triangle sides: " + triangle2.getSide1() + 
					" " + triangle2.getSide2() + " " + triangle2.getSide3() + " " + 
					"have area: " + triangle2.getArea() + " and perimeter: " 
					+ triangle2.getPerimeter());
		} catch (IllegalTriangleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
