import java.util.*;

public class Project1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int smallestSidesPaper = input.nextInt();
		if (smallestSidesPaper >= 2 && smallestSidesPaper <= 30) {
			double tapeLength = 0;
			double needPaperForEachSides = 2;
			boolean possible = false;
			int[] numOfPaper = new int [smallestSidesPaper + 1];
			for (int i = 0; i < numOfPaper.length - 2; i++) {
				numOfPaper[i] = input.nextInt();
				if (numOfPaper[i] > Math.pow((double) 10, (double) 9)) {
					System.exit(0);
				}
			}
			for (int j = 0; j < numOfPaper.length; j++) {
				tapeLength += (needPaperForEachSides / 2 ) * 
						Math.pow(2.0 ,(.25 * (-1 * (3 + (j * 2)))));
				if (numOfPaper[j] >= needPaperForEachSides ) {
					possible = true;
					break;
				}
				needPaperForEachSides = 2 * 
						(needPaperForEachSides - numOfPaper[j]);
			}
			if (possible) {
				System.out.print(tapeLength);
			}
			else {
				System.out.print("impossible");
			}

		}
		else {
			System.out.print("impossible");
		}
		
	}
}