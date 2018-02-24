import java.util.*;

public class Problem7_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the list: ");
		int[] num = new int[input.nextInt()];
		System.out.print("Enter the contents of the list: ");
		for (int i = 0; i < num.length; i++) {
			num[i] = input.nextInt();
		}
		String numString = 
			Arrays.toString(num).replace("[", "").replace("]", "").replace(",", " ");
		System.out.println("The list has "+ num.length + " integers " + numString);
		if (isSorted(num)) {
			System.out.print("The list is already sorted");
		}
		else {
			System.out.print("The list is not sorted");
		}
	}
	public static boolean isSorted(int[] array) {
		int[] copyNum = new int[array.length];
		for (int i = 0; i < copyNum.length; i++) {
			copyNum[i] = array[i];
		}
		selectionSort(copyNum);
		boolean value = false;
		for (int j = 0; j < array.length; j++) {
			if (array[j] == copyNum[j]) {
				value = true;
			}
			else {
				return false;
			}
		}
		return value;
	}
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length -1; i++) {
			int currentMin = array[i];
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
}