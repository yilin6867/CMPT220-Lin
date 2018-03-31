import java.util.Date;

public class SavingsAccount extends Account{
	private int overDrawnLimit = 0;
	SavingsAccount() {
	}
	SavingsAccount(int newId, double newBalance) {
		this.setId(newId);
		this.setBalance(newBalance);
	}
	public int getOverDrawnLimit() {
		return overDrawnLimit;
	}
	@Override
	public void withdraw(double amount) {
		if (this.getBalance() > this.getOverDrawnLimit()) {
			double newBalance = this.getBalance() - amount;
			this.setBalance(newBalance);
			System.out.println("You withdraw " + amount + "\n" + "You currently have " 
					+ this.getBalance());
			
		}
		else {
			System.out.println("You have " + this.getBalance() + " in your account");
		}
	}
	@Override
	public String toString() {
		return "Savings Account: " + this.getId() + "\n" + "Date Created " + 
				this.getDateCreated() + "\n" + "Balance: " + this.getBalance() + "\n" +
				"Annual Interest Rate: " + this.getAnnualInterestRate() + "\n" + "Overdrawn Limit: " +
				this.getOverDrawnLimit();
	}
}