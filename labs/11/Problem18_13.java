

import java.util.Scanner;

public class Problem18_13 {
	public static void main(String[] args) {
		System.out.print("Enter a list of 8 integers that will be searched for largest number: ");
		Scanner input = new Scanner(System.in);
		int[] list = new int[8];
		for (int i = 0; i < 8; i++) {
			list[i] = input.nextInt();
		}
		System.out.println("The Max number of the array is " + maxIntegerOfArray(list));
	}
	public static int maxIntegerOfArray(int[] list) {
		if (list == null || list.length == 0) {
			return (Integer) null;
		}
		else {
			return sort(list, 0)[list.length - 1];
		}
	}
	public static int[] sort(int[] list, int low) {
		// TODO Auto-generated method stub
		if (list.length -1 <= low) {
			return list;
		}
		else {
            int indexBeingMeasure = low;
            for (int j = indexBeingMeasure + 1; j < list.length; j++) {
                if (list[j] < list[indexBeingMeasure]) {
                	indexBeingMeasure = j;
                }
            }
            int smallerNumber = list[indexBeingMeasure];  
            list[indexBeingMeasure] = list[low];
            list[low] = smallerNumber;
            low = low + 1;
            return sort(list, low);
		}
	}
}
