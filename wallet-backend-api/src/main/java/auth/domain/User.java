package auth.domain;


import wallet.domain.Wallet;

public class User {

	private String dni;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private Wallet wallet;
	private boolean haveAccount;

	

	public User(String dni, String name, String lastName, String email, String password) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public User() {

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public boolean isHaveAccount() {
		return haveAccount;
	}

	public void setHaveAccount(boolean haveAccount) {
		this.haveAccount = haveAccount;
	}

}
