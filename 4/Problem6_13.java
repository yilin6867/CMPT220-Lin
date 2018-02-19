
public class Problem6_13 {
	public static void main(String[] args) {
		System.out.println("i		m(i)");
		System.out.println("--------------------");
		double oldSum = 0;
		for (int i = 1; i <= 20; i++) {
			double newSum = oldSum + sumSeries(i);
			System.out.printf(i + "	  " + "%10.4f", newSum);
			System.out.println();
			oldSum = newSum;
		}
	}
	public static double sumSeries(int i) {
		double sum = i / (double)(i + 1);
		return sum;
		}
}