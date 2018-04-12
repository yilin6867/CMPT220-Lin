import java.util.Date;
public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new java.util.Date();
	Account() {
	}
	Account(int newId, double newBalance) {
		id = newId;
		balance = newBalance;
	}
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = (annualInterestRate / 12.0);
		return monthlyInterestRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate / 100.0;
	}
	public String getDateCreated() {
		dateCreated.getTime();
		return dateCreated.toString();
	}
	public double getMonthlyInterest() {
		double monthlyInterest = getMonthlyInterestRate() * balance;
		return monthlyInterest;
	}
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	public void deposit(double amount) {
		balance = balance + amount;
	}
	public String toString() {
		return "Account: " + this.getId() + "\n" + "Date Created " + 
				this.getDateCreated() + "\n" + "Balance: " + this.getBalance() + "\n" +
				"Annual Interest Rate: " + this.getAnnualInterestRate();
	}
}