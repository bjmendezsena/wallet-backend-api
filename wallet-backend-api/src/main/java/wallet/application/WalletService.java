package wallet.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.domain.AuthRepository;
import utils.Utils;
import wallet.domain.Balance;
import wallet.domain.Movement;
import wallet.domain.MovementDto;
import wallet.domain.Wallet;
import wallet.domain.WalletDTO;
import wallet.domain.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private AuthRepository authRepository;

	public Wallet createNewWallet(WalletDTO data) {

		String dni = data.getOwnerId();

		if (dni == null || dni.length() == 0) {
			throw new RuntimeException("DNI is required");
		}
		


		if(this.authRepository.getUserByDni(dni) == null) {
			throw new RuntimeException("This user does not exist in the database");
		}

		return this.walletRepository.createWallet(data);
	}

	public MovementDto deposit(WalletDTO data) throws RuntimeException {
		if (data.getQuantity() <= 0) {
			throw new RuntimeException("Deposit cannot be less than 1");
		}

		data.setDeposit(true);

		return this.walletRepository.deposit(data);
	}

	public MovementDto withdrawals(WalletDTO data) throws RuntimeException {
		data.setDeposit(false);

		return this.walletRepository.withdrawals(data);
	}

	public Wallet getWalletById(String id) {
		return this.walletRepository.getWalletById(id);
	}

	public MovementDto getMovementsByWallet(String id) {
		return this.walletRepository.getMovements(id);
	}

	public Wallet getWalletByDni(String dni) {
		return this.walletRepository.getWalletByOwner(dni);
	}
}
