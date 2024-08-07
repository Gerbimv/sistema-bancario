package bank;

public abstract class Account {
		public static int numeroContas;
		private int numberBank;
		protected int accountNumber;
		private String holder;
		protected double balance;
		private String accountType;
		
		
		public Account() {
			numeroContas+= 1;
		}
		
		public Account(int numberBank, int accountNumber, String holder) {
			this.numberBank = numberBank;
			this.accountNumber = accountNumber;
			this.holder = holder;
			numeroContas++;
		}
		
		public Account(int numberBank, int accountNumber, String accountType, String holder, double initialDeposit) {
			this.numberBank = numberBank;
			this.accountNumber = accountNumber;
			this.holder = holder;
			this.accountType = accountType;
			deposit(initialDeposit);
			numeroContas++;
		}
		public int getNumberBank() {
			return numberBank;
		}
		
		public int getAccountNumber() {
			return accountNumber;
		}
		
		
		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public String getHolder() {
			return holder;
		}
		
		public void setHolder(String holder) {
			this.holder = holder;
		}
		
		public double getBalance() {
			return balance;
		}
		
		public abstract void deposit(double amount);
		
		public boolean withdraw(double amount) {
			if (amount <= balance) {
			balance -= amount;
			return true;
			}
			else {
				System.out.println("Saldo Insuficiente!");
				return false;
			}
		}
		
		public boolean transfer(Account accountTarget, double amount) {
			if (accountTarget.getAccountNumber() == accountNumber && amount <= balance) {
				this.balance -= amount;
				accountTarget.balance += amount;			
				return true;
			}
			else {
				if(accountTarget.getAccountNumber() != accountNumber) {
					System.out.println("Destinatário Inválido");
				}
				System.out.println("Saldo Insulficiente!");
				return false;
			}
		}

		public String total() {
			return ""  + numeroContas;
		}

		public String toString() {
			return " Número da Conta: "
					+ accountNumber
					+ "\n Titular da Conta: "
					+ holder
					+ "\n Saldo da conta: R$"
					+ String.format("%.2f", balance);
		}
		
	}