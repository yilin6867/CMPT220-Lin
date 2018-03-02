import java.util.Scanner;

public class Program9_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns in the array: ");
		double[][] array = new double[input.nextInt()][input.nextInt()];
		System.out.println("Enter the array: ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = input.nextDouble();
			}
		}
		Location location = locateLargest(array);
		System.out.println("The location of the largest elemetn is " + location.maxValue + 
				" at (" + location.row + ", " + location.column + ").");
	}
	public static Location locateLargest(double[][] a) {
		Location location = new Location();
		location.maxValue = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int k = 0; k < a[i].length; k++) {
				if (location.maxValue < a[i][k]) {
					location.maxValue = a[i][k];
					location.setRow(i);
					location.setColumn(k);
				}
			}
		}
		return location;
	}
}