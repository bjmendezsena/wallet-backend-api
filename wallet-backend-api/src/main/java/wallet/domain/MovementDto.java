package wallet.domain;

import java.io.Serializable;
import java.util.List;

public class MovementDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Balance currentBalance;
	private String date;
	private List<Movement> movements;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public Balance getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Balance currentBalance) {
		this.currentBalance = currentBalance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
