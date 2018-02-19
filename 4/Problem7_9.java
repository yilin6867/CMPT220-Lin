import java.util.*;

public class Problem7_9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers: ");
		double[] num = new double[10];
		for (int i = 0; i < 10; i++) {
			num[i] = input.nextDouble();
		}
		System.out.println("The minimum number is " + min(num));
	}
	public static void selectionSort(double[] array) {
		for (int i = 0; i < array.length -1; i++) {
			double currentMin = array[i];
			int currentMinIndex = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (currentMin > array[j]) {
					currentMin = array[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				array[currentMinIndex] = array[i];
				array[i] = currentMin;
			}
		}
	}
	public static double min(double[] array) {
		selectionSort(array);
		double minimum = array[0];
		return minimum;
	}
}