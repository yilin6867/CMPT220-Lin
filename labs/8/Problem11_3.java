// JA: This class does not compile

public class Problem11_3 {
	public static void main(String[] args) {
		Account acc = new Account(123456789, 1000);
		CheckingAccount chAcc = new CheckingAccount(987654321, 10000);
		SavingsAccount savAcc = new SavingsAccount(147258369, 100000);
		System.out.println(acc.toString() + "\n\n" + chAcc.toString() + "\n\n" + savAcc.toString());
	}
}
