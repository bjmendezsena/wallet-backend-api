package wallet.domain;

public class Balance {
	private String id;
	private String currentDate;
	private float quantity;

	public Balance(String id, String currentDate, float quantity) {
		super();
		this.id = id;
		this.currentDate = currentDate;
		this.quantity = quantity;
	}

	public Balance() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

}
