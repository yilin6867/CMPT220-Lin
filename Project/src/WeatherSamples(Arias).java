import java.util.Scanner;

public class WeatherSamples {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter day, hour, temperature, humidity: ");
		double[][][] weatherData = new double[10][24][2];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 24; j++) {
				int day = input.nextInt();
				int hour = input.nextInt();
				double temp = input.nextDouble();
				double humidity = input.nextDouble();
				weatherData[day - 1][hour - 1][0] = temp;
				weatherData[day - 1][hour - 1][1] = humidity;
			}
		}
		
		// Calculate and print the daily averages
		for (int i = 0; i < 10; i++) {
			double tempSum = 0;
			double humSum = 0;
			for (int j = 0; j < 24; j++) {
				tempSum += weatherData[i][j][0];
				humSum += weatherData[i][j][1];
			}
			double tempAvg = tempSum / 24;
			double humAvg = humSum / 24;
			System.out.printf("Day %d's average temperature is %.2f\n", i + 1, tempAvg);
			System.out.printf("Day %d's average humidity is %.2f\n", i + 1, humAvg);
		}
	}

}
