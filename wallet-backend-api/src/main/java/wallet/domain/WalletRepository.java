package wallet.domain;


public interface WalletRepository {
	Wallet createWallet(WalletDTO data) throws RuntimeException;

	Wallet getWalletById(String id) throws RuntimeException;

	Wallet getWalletByOwner(String ownerId) throws RuntimeException;

	MovementDto deposit(WalletDTO data) throws RuntimeException;

	MovementDto withdrawals(WalletDTO data) throws RuntimeException;
	
	MovementDto getMovements(String id) throws RuntimeException;

	Balance getCurrentBalance(String id) throws RuntimeException;

}
