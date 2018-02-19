import java.util.*;

public class Problem6_9 {
	public static void main(String[] args) {	
		System.out.println("Feet 	     Meter  	|  	Meters 	    Feets");
		System.out.println("------------------------------------------------------");
		double meters = 20;
		for (double feet = 1; feet <= 10; feet = feet + 1) {
			double meter= feetToMeters(feet);
			System.out.printf(feet + " 	%10.3f", meter);
			System.out.print("	|	");
		if (meters <= 65) {
			double foot = metersToFeet(meters);
			System.out.printf(meters + " 	%10.3f", foot);
			System.out.println();
			meters = meters + 5;
			}
		}
	}
	public static double feetToMeters(double feet) {
		double meter = 0.305 * feet;
		return meter;
			
		}
	public static double metersToFeet(double meters) {
		double feet = 3.279 * meters;
		return feet;
	}
	
}