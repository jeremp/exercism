
/**
 *
 * @author jpasseron
 */
class BankAccount {

	private long balance = 0;
	private boolean isOpen = false ;

	public BankAccount() {
		isOpen = true ;
	}

	public void open() {

	}

	public long getBalance() {
		return this.balance;
	}

	public void deposit(int i) throws BankAccountActionInvalidException {
		this.balance+=i ;
	}

	public void withdraw(int i) throws BankAccountActionInvalidException {
		if(balance==0){
			throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
		}else if(i>balance){
			throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
		}
		this.balance-=i ;
	}

	public void close() {
		isOpen = false ;
	}

}
