import java.util.Scanner;


public class Problem9_7 {
	public static void main(String[] args) {
		Account bankAccount = new Account(1122, 20000.0);
		bankAccount.setAnnualInterestRate(4.5);
		bankAccount.withdraw(2500);
		bankAccount.deposit(3000);
		System.out.println("Balance is " + bankAccount.getBalance() + ", monthly interest is " + 
		bankAccount.getMonthlyInterest() + ", and this account is created in " 
		+ bankAccount.getDateCreated());
	}
}