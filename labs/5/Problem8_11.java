import java.util.*;

public class Problem8_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 511: ");
		Integer[] possibilityOfHeadAndTail = new Integer[9];
		Arrays.fill(possibilityOfHeadAndTail, 0);
		int num = input.nextInt();
		int k = 7;
		Integer[] counts = new Integer[9];
		Integer[] copyCounts = new Integer[counts.length];
		Arrays.fill(counts, 0);
		int copyNum = num;
		int p = 0;
		int o = 0;
		boolean yesReverseCounts = false;
		List<Integer> reverseCounts = new ArrayList<Integer>();
		if (num > 0) { 
			while (num > 0) {
				if (copyNum >= Math.pow(2, p)) {
					yesReverseCounts = true;
					Arrays.fill(counts, 0);
					counts[p] = 1;
					num = copyNum;
					num = (int) (num - Math.pow(2, p));
				}
				else if (num > 0 && !(copyNum >= Math.pow(2, p))){
					if (copyNum >= Math.pow(2, o)) {
						counts[o] = 1;
						num = (int) (num - Math.pow(2, o));
					}
					o++;
				}
				p++;
				System.arraycopy(counts, 0, copyCounts, 0, counts.length);
			}
			copyNum = copyNum % 2;
			counts[0] = copyNum;
			reverseCounts = Arrays.asList(counts);
		    Collections.reverse(reverseCounts);
			for (int j = possibilityOfHeadAndTail.length - 1; j >= 0 ; j--) {
				if (yesReverseCounts)
					possibilityOfHeadAndTail[j] = counts[j];
				else
					possibilityOfHeadAndTail[j] = reverseCounts.get(j);
			}
		}
		for (int i = 0; i < possibilityOfHeadAndTail.length; i++) {
			if (i == 3 || i == 6) {
				System.out.println();
			}
			if (possibilityOfHeadAndTail[i] == 0) {
				System.out.print("H ");
			}
			else {
				System.out.print("T ");
			}
		}
	}
}