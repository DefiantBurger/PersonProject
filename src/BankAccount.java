import java.util.*;

public class BankAccount {

	int accountNumber;
	double Balance;
	static int accounts = 0;
	String accountType;
	boolean autoUpgrade;
	public static ArrayList<String> accountTypes = new ArrayList<>();
	public static Map<String, Long> accountLimits = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	//Bronze: 1%, Silver: 2%, Gold: 3%, Platinum: 2%, Ultimate: 1%

	public BankAccount() {
		this.accountNumber = BankAccount.newAccountNumber();
		this.Balance = 0;
		this.accountType = "Bronze";
		accounts += 1;
		this.autoUpgrade = false;
	}
	
	public void withdraw(double amount) throws InvalidWithdrawAmount {
		if (this.Balance - amount < 0) throw new InvalidWithdrawAmount(String.valueOf(amount));
		if (amount <= 0) throw new InvalidWithdrawAmount(String.valueOf(amount));
		this.Balance -= amount;
	}
	
	public void withdrawAll() throws Exception {
		this.Balance = 0;
	}
	
	public void deposit(double amount) throws InvalidDepositAmount, BankAccountLimitSurpassed, ImpossibleUpgrade {
		if (this.Balance + amount > accountLimits.get(this.accountType)) {
			if (this.autoUpgrade) {
				this.upgradeAccount();
			} else {
				throw new BankAccountLimitSurpassed(this.Balance + amount, accountLimits.get(this.accountType));
			}
		}
		if (amount < 0) throw new InvalidDepositAmount(String.valueOf(amount));
		this.Balance += amount;
	}
	
	public static int newAccountNumber() {
	    return accounts;
	}
	
	public void upgradeAccount() throws ImpossibleUpgrade {
		switch (accountType) {
		case "Bronze":
			this.accountType = "Silver";
			break;
		case "Silver":
			this.accountType = "Gold";
			break;
		case "Gold":
			this.accountType = "Platinum";
			break;
		case "Platinum":
			this.accountType = "Ultimate";
			break;
		case "Ultimate":
			throw new ImpossibleUpgrade();
		}
	}
	
	public void upgradeAccount(String accountType) throws InvalidBankAccountType {
		if (!(accountTypes.contains(accountType))) throw new InvalidBankAccountType(accountType);
		this.accountType = accountType;
	}
	
	public void downgradeAccount() throws ImpossibleUpgrade {
		switch (accountType) {
		case "Bronze":
			throw new ImpossibleUpgrade();
		case "Silver":
			this.accountType = "Bronze";
			break;
		case "Gold":
			this.accountType = "Silver";
			break;
		case "Platinum":
			this.accountType = "Gold";
			break;
		case "Ultimate":
			this.accountType = "Platinum";
			break;
		}
	}
	
	public void downgradeAccount(String accountType) throws InvalidBankAccountType {
		if (!(accountTypes.contains(accountType))) throw new InvalidBankAccountType(accountType);
		this.accountType = accountType;
	}
	
	public void interest() throws ImpossibleUpgrade, BankAccountLimitSurpassed {
		double interest = 1;
		switch (accountType) {
		case "Bronze":
			interest = 1.01;
			break;
		case "Silver":
			interest = 1.02;
			break;
		case "Gold":
			interest = 1.03;
			break;
		case "Platinum":
			interest = 1.02;
			break;
		case "Ultimate":
			interest = 1.01;
		}
		
		if (this.Balance * interest > accountLimits.get(this.accountType)) {
			if (this.autoUpgrade) {
				this.upgradeAccount();
			} else {
				throw new BankAccountLimitSurpassed(this.Balance * interest, accountLimits.get(this.accountType));
			}
		}
		
		this.Balance *= interest;
		
		this.Balance = Math.floor(this.Balance * 100) / 100;
	}
	
	public void autoUpgrade(boolean toggle) {
		this.autoUpgrade = toggle;
	}
	
	public void autoUpgradeOn() {
		this.autoUpgrade = true;
	}
	
	public void autoUpgradeOff() {
		this.autoUpgrade = false;
	}

}
