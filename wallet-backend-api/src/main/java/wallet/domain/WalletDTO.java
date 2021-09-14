package wallet.domain;

import java.io.Serializable;

public class WalletDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String ownerId;
	private String date;
	private float quantity;
	private String account;
	private String concept;
	private boolean isDeposit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
