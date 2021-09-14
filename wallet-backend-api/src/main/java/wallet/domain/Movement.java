package wallet.domain;

public class Movement {

	private Balance quantity;
	private String concept;
	private boolean isDeposit;

	public Balance getQuantity() {
		return quantity;
	}

	public void setQuantity(Balance quantity) {
		this.quantity = quantity;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public boolean isDeposit() {
		return isDeposit;
	}

	public void setDeposit(boolean isDeposit) {
		this.isDeposit = isDeposit;
	}

}
