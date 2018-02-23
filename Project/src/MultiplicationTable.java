
public class MultiplicationTable {
	public static void main(String [] args) {
		System.out.println("	Multiplication Table \n\n");
		
		System.out.printf("%5s", " ");
		for (int i = 1 ; i <= 9; i++)
			System.out.printf("%3d", i);
		System.out.println("\n----------------------------------");
		
		for (int i = 1 ; i <=9; i++) {
			System.out.printf("%3d |", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i * j);
			}
			System.out.println();
		}
	}
}