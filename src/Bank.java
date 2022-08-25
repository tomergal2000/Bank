public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	// END OF Given code -----------------------------------
	
	// Complete the methods from here on

	public boolean add(BankAccount newAccount) {
		//see if those accounts actually exists
		if (lookUp(newAccount.getName()) == null || lookUp(newAccount.getAccountNumber()) == null){
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			return true;
		}
		return false;
	}

	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		//see if this account actually exists
		if (toRemove == null)
			return false;
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		return true;
	}
	
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		//see if this account actually exists
		if (toRemove == null)
			return false;
		accountNumbersTree.remove(toRemove);
		namesTree.remove(toRemove);
		return true;
	}

	public boolean depositMoney(int amount, int accountNumber){
		BankAccount toDeposit = lookUp(accountNumber);
		//see if this account actually exists
		if (toDeposit == null)
			return false;
		return toDeposit.depositMoney(amount);
	}

	public boolean withdrawMoney(int amount, int accountNumber){
		BankAccount toWithdraw = lookUp(accountNumber);
		//see if this account actually exists
		if (toWithdraw == null)
			return false;
		return toWithdraw.withdrawMoney(amount); //if there is not enough money to take, do nothing & return false
	}	
	
	public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
		BankAccount acc1 = lookUp(accountNumber1);
		BankAccount acc2 = lookUp(accountNumber2);
		//see if those accounts actually exist
		if (acc1 == null || acc2 == null)
			return false;
		return acc1.withdrawMoney(amount) && acc2.depositMoney(amount); //if there is not enough money to take, do nothing & return false
	}	
	public boolean transferMoney(int amount, int accountNumber, String name) {
		BankAccount acc1 = lookUp(accountNumber);
		BankAccount acc2 = lookUp(name);
		//see if those accounts actually exist
		if (acc1 == null || acc2 == null)
			return false;
		return acc1.withdrawMoney(amount) && acc2.depositMoney(amount); //if there is not enough money to take, do nothing & return false
	}	
}
