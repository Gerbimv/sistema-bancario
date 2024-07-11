package bank;

public abstract class Account {
		public static int numeroContas;
		private int numberBank;
		protected int number;
		private String holder;
		protected double balance;
		private String accountType;
		
		
		public Account() {
			numeroContas+= 1;
		}
		
		public Account(int numberBank, int number, String holder) {
			this.numberBank = numberBank;
			this.number = number;
			this.holder = holder;
			numeroContas+= 1;
		}
		
		public Account(int numberBank, int number, String accountType, String holder, double initialDeposit) {
			this.numberBank = numberBank;
			this.number = number;
			this.holder = holder;
			this.accountType = accountType;
			deposit(initialDeposit);
		}
		public int getNumberBank() {
			return numberBank;
		}
		
		public int getNumber() {
			return number;
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
			if (amount < balance) {
			balance -= amount;
			return true;
			}
			else {
				System.out.println("Saldo Insuficiente!");
				return false;
			}
		}

		public String total() {
			return ""  + numeroContas;
		}

		public String toString() {
			return " Número da Conta: "
					+ number
					+ "\n Titular da Conta: "
					+ holder
					+ "\n Saldo da conta: R$"
					+ String.format("%.2f", balance);
		}
		
	}