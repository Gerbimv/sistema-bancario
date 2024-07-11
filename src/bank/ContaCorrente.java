package bank;

public class ContaCorrente extends Account {

	public ContaCorrente(int numberBank, int number, String accountType, String holder, double initialDeposit) {
		super(numberBank, number, accountType, holder, initialDeposit);
	}

	public ContaCorrente(int numberBank, int number, String holder) {
		super(numberBank, number, holder);
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	
	
}
