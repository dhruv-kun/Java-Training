
public class TransactionThread extends Thread {
	private Account acc;
	private TransactionType type;
	private String name;
	private double amt;
	public TransactionThread(Account acc, TransactionType type, String name, double amt) {
		this.acc = acc;
		this.type = type;
		this.name = name;
		this.amt = amt;
	}
	
	@Override
	public void run() {
		if (type == TransactionType.CREDIT)
			acc.deposit(name, amt);
		else if (type == TransactionType.DEBIT)
			acc.withdraw(name, amt);
	}
	
}
