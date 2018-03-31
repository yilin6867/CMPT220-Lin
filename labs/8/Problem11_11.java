import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem11_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter five number to store and sort: ");
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list.add(input.nextInt());
		}
		sort(list);
		System.out.println("This is the sorted list: ");
		System.out.println(list.toString());
	}
	public static void sort(ArrayList<Integer> list) {
		Collections.sort(list);
	}
}
