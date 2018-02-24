import java.util.*;

public class Problem7_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] num = new int[10];
		System.out.print("Enter 10 numbers: ");
		for (int i = 0; i < num.length; i++) {
			num[i] = input.nextInt();
		}
		int[] newNum = eliminateDuplicates(num);
		String numString = Arrays.toString(newNum).replace("[", "").replace("]", "");
		String newNumString = numString.replace(",", " ");
		System.out.println("The distinct numbers are: " + newNumString);
	}
	public static int[] eliminateDuplicates(int[] list) {
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < list.length; i++) {
		    numList.add(list[i]);
		}
		List<Integer> checkList = new ArrayList<Integer>(numList);
		Collections.sort(checkList);
		for (int j = 0; j < checkList.size(); j++) {
			while (j < checkList.size() && j != 0 
					&& checkList.get(j) == checkList.get(j - 1)) {
				checkList.remove(j);
				}
		}
		boolean[] arr = new boolean[checkList.size()];
		for (int n = 0; n < checkList.size(); n++) {
			for (int l = 0; l < numList.size(); l++) {
				if (numList.get(l) == checkList.get(n) && arr[n] == false) {
					arr[n] = true;
				}
				else if (numList.get(l) == checkList.get(n) && arr[n] == true) {
					numList.remove(l);
				}
			}
		}
		int[] newNum = numList.stream().mapToInt(Integer::intValue).toArray();
		return newNum;
	}
}