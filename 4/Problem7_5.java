import java.util.*;

public class Problem7_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers: ");
		List<Integer> tenNum = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tenNum.add(input.nextInt());
		}
		List<Integer> newList = new ArrayList<Integer>(tenNum);
		Collections.sort(newList);
		for (int j = 0; j < newList.size(); j++) {
			while (j != 0 && newList.get(j) == newList.get(j - 1)) {
				newList.remove(j);
			}
		}
		boolean[] arr = new boolean[newList.size()];
		List<Integer> distinctList = new ArrayList<>();
		for (int l = 0; l < tenNum.size(); l++) {
			for (int n = 0; n < newList.size(); n++) {
				if (tenNum.get(l) == newList.get(n) && arr[n] == false) {
					distinctList.add(tenNum.get(l));
					arr[n] = true;
				}
			}
		}
		StringBuilder distinctNum  = new StringBuilder();
		Iterator<Integer> iter = distinctList.iterator();
		while (iter.hasNext()) {
			distinctNum.append(iter.next());
			if (iter.hasNext()) {
				distinctNum.append(" ");
			}
		}
		System.out.println("The number of distinct numbers is " + distinctList.size());
		System.out.println("The distinct numbers are: " + distinctNum);
	}
}