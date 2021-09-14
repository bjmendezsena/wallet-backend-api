package wallet.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utils.Utils;
import wallet.domain.Balance;
import wallet.domain.Movement;
import wallet.domain.Wallet;
import wallet.domain.WalletDTO;
import wallet.domain.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;

	public Wallet createNewWallet(WalletDTO data) {

		String dni = data.getOwnerId();

		if (dni == null || dni.length() == 0) {
			throw new RuntimeException("It is mandatory to inform the user's ID");
		}

		Balance balance = new Balance();
		balance.setCurrentDate(Utils.getCurrentDate());
		balance.setQuantity(data.getQuantity());
		balance.setId(String.valueOf(System.currentTimeMillis()));

		return this.walletRepository.createWallet(balance, data.getOwnerId());
	}

	public List<Movement> deposit(WalletDTO data) throws RuntimeException {
		if (data.getQuantity() <= 0) {
			throw new RuntimeException("Deposit cannot be less than 1");
		}
		

		data.setDeposit(true);

		return this.walletRepository.deposit(data);
	}

	public List<Movement> withdrawals(WalletDTO data) throws RuntimeException {
		data.setDeposit(false);

		return this.walletRepository.withdrawals(data);
	}
	
	public Wallet getWalletById(String id) {
		return this.walletRepository.getWalletById(id);
	}
	
	public List<Movement> getMovementsByWallet(String id) {
		return this.walletRepository.getMovements(id);
	}

}
