package bank;

public class ContaPoupanca extends Account {

	public ContaPoupanca(int numberBank, int number, String accountType, String holder, double initialDeposit) {
		super(numberBank, number, accountType, holder, initialDeposit);
	}

	public ContaPoupanca(int numberBank, int number, String holder) {
		super(numberBank, number, holder);
	}
	
	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}
	
}
