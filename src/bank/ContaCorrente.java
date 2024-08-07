package bank;

public class ContaCorrente extends Account {

	public ContaCorrente(int numberBank, int accountNumber, String accountType, String holder, double initialDeposit) {
		super(numberBank, accountNumber, accountType, holder, initialDeposit);
	}

	public ContaCorrente(int numberBank, int accountNumber, String holder) {
		super(numberBank, accountNumber, holder);
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	@Override 
	public boolean withdraw(double amount) {
			if (amount + 0.2 <= balance ) {
			balance -= (amount + 0.2);
			return true;
			}
			else {
				System.out.println("Saldo Insuficiente!");
				return false;
			}
		}
	

	
	
}
