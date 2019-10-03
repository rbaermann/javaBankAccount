import java.util.Random;
public class BankAccount {
	private double savingsBalance;
	private double checkingBalance;
	private String accountNumber;
	private static int numOfAccounts = 0;
	private static double totalMoney = 0.00;
	
	public BankAccount() {
		accountNumber = accountGenerator();
		savingsBalance = 0.00;
		checkingBalance = 0.00;
		numOfAccounts++;
	}
	
	private String accountGenerator() {
		Random r = new Random();
		String newAccount = "";
		for(int i = 0; i < 10; i++) {
			newAccount += r.nextInt(10);
		}
		return newAccount;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	public void checkBalance() {
		System.out.println("Checking: " + checkingBalance + " Savings: " + savingsBalance);
	}
	
	public void depositChecking(double amount) {
		checkingBalance += amount;
		deposit(amount);
	}
	
	public void depositSavings(double amount) {
		savingsBalance += amount;
		deposit(amount);
	}
	
	public void deposit(double amount) {
		totalMoney += amount;
		System.out.println(amount + " deposited");
	}
	
	public void withdrawChecking(double amount) {
		if(checkingBalance - amount >= 0) {
			System.out.println(amount + " withdrawn");
			checkingBalance -= amount;
		}
		else {
			System.out.println("Insufficient funds");
		}
	}
	
	public void withdrawSavings(double amount) {
		if(savingsBalance - amount >= 0) {
			System.out.println(amount + " withdrawn");
			savingsBalance -= amount;
		}
		else {
			System.out.println("Insufficient funds");
		}
	}
}
