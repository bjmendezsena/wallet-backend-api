package wallet.domain;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

	private String id;
	private String ownerid;
	private Balance currentBalance;
	private String accountNumber;
	private List<Movement> movements;

	public Wallet(String id, Balance balance, String accountNumber) {
		super();
		this.id = id;
		this.currentBalance = balance;
		this.accountNumber = accountNumber;
		this.movements = new ArrayList<Movement>();
	}

	public Wallet() {
		this.movements = new ArrayList<Movement>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public Balance getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Balance balance) {
		this.currentBalance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

}
