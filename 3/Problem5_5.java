
public class Problem5_5 {
	public static void main(String[] args) {
		int p = 20;
		System.out.println("Kilograms       Pounds  |   Pounds       Kilograms");
		for (int i = 1; i <= 199; i = i + 2) {
			System.out.print(i + "         ");
			for (int j = 1; j<=1; j++) {
				System.out.printf("%10.2f   |    ", i *2.2);
			}
			if (p<= 515){
				System.out.printf(p + "       ");
				System.out.printf("%10.2f", p/2.2);
				p = p +5;
			}
			System.out.println();
			
		}
		
	}
}