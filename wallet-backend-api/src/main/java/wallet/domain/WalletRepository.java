package wallet.domain;

import java.util.List;

public interface WalletRepository {
	Wallet createWallet(Balance balance, String ownerId) throws RuntimeException;

	Wallet getWalletById(String id) throws RuntimeException;

	Wallet getWalletByOwner(String ownerId) throws RuntimeException;

	List<Movement> deposit(WalletDTO data) throws RuntimeException;

	List<Movement> withdrawals(WalletDTO data) throws RuntimeException;
	
	List<Movement> getMovements(String id) throws RuntimeException;

	Balance getCurrentBalance(String id) throws RuntimeException;

}
