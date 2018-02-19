import java.util.*;

public class Problem7_3 {
	public static void main(String[] args) {
		List<Integer> listNumber = new ArrayList<>();
		for (int i = 1; i < 101 ; i++) {
			listNumber.add(i);
		}
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the integers between 1 and 100: ");
		int n = 1;
		List<Integer> integers = new ArrayList<>();
		while ( n != 0) {
			n = input.nextInt();
			integers.add(n);
		}
		integers.remove(integers.size() - 1);
		Collections.sort(integers);
		List<Integer> counts = linearSearch(integers, listNumber);
		for (int k = 0; k < counts.size(); k++) {
			while(k != 0 && integers.get(k) == integers.get(k - 1)) {
				integers.remove(k);
			}
			System.out.println(integers.get(k) + " occurs " + counts.get(k) + " times.");
		}
	}
	public static List<Integer> linearSearch(List<Integer> integers, List<Integer> listNumber) {
		List<Integer> counts = new ArrayList<>();
		for (int n = 0; n <integers.size(); n++) {
			for (int l= 0; l < listNumber.size(); l++ ) {
				if (integers.get(n) == listNumber.get(l)) {
					int occurs = 0;
					if (n != 0 && integers.get(n) == integers.get(n - 1) ) {
						occurs = counts.get(counts.size() - 1) + 1;
						counts.set(counts.size() - 1, occurs);
					}
					else {
						occurs++;
						counts.add(occurs);
					}
				}
			}
		}
		return counts;
	}
}