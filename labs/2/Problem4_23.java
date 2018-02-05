import java.util.*;

public class Problem4_23 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter employee's name: ");
		String name = input.next();
		System.out.print("Enter number of hours worked in a week: ");
		float hourWorked = input.nextFloat();
		System.out.print("Enter hourly pay rate: ");
		float hourPayed = input.nextFloat();
		System.out.print("Enter federal tax withholding rate: ");
		float fedTaxR = input.nextFloat();
		System.out.print("Enter state tax withholding rate: ");
		float staTaxR = input.nextFloat();
		
		System.out.println("Employee Name: " + name);
		System.out.println("Hours Worked: " + hourWorked);
		System.out.println("Pay Rate: " + hourPayed);
		float grossPay = hourPayed * hourWorked;
		System.out.printf("Gross Pay: %-10.2f\n" , grossPay);
		System.out.println("Deducation: ");
		float fedTax = grossPay * fedTaxR;
		System.out.printf("%-5s %-10.2f\n", "Federal Withholding", fedTax);
		float staTax = grossPay * staTaxR;
		System.out.printf("%-5s %-10.2f\n", "State Withholding", staTax);
		float totalTax = fedTax + staTax;
		System.out.printf("%-5s %-10.2f\n", "Total Withholding", totalTax);
		float netPay = grossPay - totalTax;
		System.out.printf("Net Pay: %-10.2f\n",  netPay);
	}
}