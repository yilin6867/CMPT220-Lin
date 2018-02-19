import java.util.*;
import java.text.DecimalFormat;

public class Problem7_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers: ");
		double[] num = new double[10];
		for (int i = 0; i < num.length; i++) {
			num[i] = input.nextDouble();
		}
		double average = mean(num);
		double deviation = deviation(num);
		System.out.printf("The mean is %.2f",  average);
		System.out.println();
		System.out.printf("The standard deviation is %.5f", deviation);
	}
	public static double mean(double[] x) {
		double sum = 0;
		for (int j = 0; j < x.length; j++) {
			sum = sum + x[j];
		}
		double average = sum/x.length;
		return average;
	}
	public static double deviation(double[] x) {
		double average = mean(x);
		double sum = 0;
		double subValue = 0;
		for (int k = 0; k < x.length; k++) {
			subValue = (x[k] - average) * (x[k] - average);
			sum = sum + subValue;
		}
		double variance = sum/(x.length -1);
		double roundVariance = (double)Math.round(variance * 100000d) / 100000d;
		double deviation = Math.sqrt(roundVariance);
		return deviation;
	}
}