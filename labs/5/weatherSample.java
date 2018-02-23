import java.util.*;

public class weatherSample {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the day, the hour temperature, humidity: ");
		double[][][] weatherData = new double [10][24][2];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 24; j ++) {
				int day = input.nextInt();
				int hour = input.nextInt();
				double temp = input.nextDouble();
				double humidity = input.nextDouble();
				weatherData[day - 1][hour - 1] = temp;
				weatherData[day - 1][hour - 1] = humidity;
			}
		}
		for (int l = 0; l < 10; l++) {
			double tempSum = 0;
			double humSum = 0;
			for (int j = 0; j < 24; j++) {
				tempSum += weatherData[i][j][0];
				humSum += weatherData[i][j][1];
			}
			double temperAverage = 
		}
	}
}