import java.util.Date;

public class CheckingAccount extends Account {
	private int overDraftLimit = -100;

	CheckingAccount() {
	}
	CheckingAccount(int newId, double newBalance) {
		this.setId(newId);
		this.setBalance(newBalance);
		
	}
	public int getOverDraftLimit() {
		return overDraftLimit;
	}
	@Override
	public void withdraw(double amount) {
		if (this.getBalance() > this.getOverDraftLimit()) {
			double newBalance = this.getBalance() - amount;
			this.setBalance(newBalance);
			System.out.println("You withdraw " + amount + "\n" + "You currently have " 
								+ this.getBalance());
			
		}
		else {
			System.out.println("You reach to overdraft limit");
		}
	}
	@Override
	public String toString() {
		return "Checking Account: " + this.getId() + "\n" + "Date Created " + 
				this.getDateCreated() + "\n" + "Balance: " + this.getBalance() + "\n" +
				"Annual Interest Rate: " + this.getAnnualInterestRate() + "\n"+ "OverDraft Limit: " +
				this.getOverDraftLimit();
	}
}
