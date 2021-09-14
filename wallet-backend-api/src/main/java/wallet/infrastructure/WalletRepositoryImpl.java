package wallet.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import utils.Utils;
import wallet.domain.Balance;
import wallet.domain.Movement;
import wallet.domain.Wallet;
import wallet.domain.WalletDTO;
import wallet.domain.WalletRepository;

@Repository
public class WalletRepositoryImpl implements WalletRepository {

	private List<Wallet> data;

	@PostConstruct
	public void init() {
		this.data = new ArrayList<Wallet>();

		this.data.add(new Wallet(Utils.generateSecureId(),
				new Balance(Utils.generateSecureId(), Utils.getCurrentDate(), 100), "0001","666666666"));
		this.data.add(new Wallet(Utils.generateSecureId(),
				new Balance(Utils.generateSecureId(), Utils.getCurrentDate(), 10), "0002","46471586V"));
		this.data.add(new Wallet(Utils.generateSecureId(),
				new Balance(Utils.generateSecureId(), Utils.getCurrentDate(), 150), "0003", "46471588V"));
	}

	@Override
	public Wallet createWallet(Balance balance, String ownerId) {

		Wallet newWallet = new Wallet();

		String accountNumber = String.valueOf(Utils.generateSecureId());

		newWallet.setAccountNumber(accountNumber);
		newWallet.setCurrentBalance(balance);
		newWallet.setId(Utils.generateSecureId());
		newWallet.setOwnerid(ownerId);
		Movement movement = new Movement();
		movement.setConcept("Initial balance");
		movement.setDeposit(true);
		movement.setQuantity(balance);
		newWallet.getMovements().add(movement);

		this.data.add(newWallet);

		return newWallet;
	}

	@Override
	public List<Movement> deposit(WalletDTO walletDto) {

		walletDto.setDate(Utils.getCurrentDate());

		Wallet wallet = this.getWallet(walletDto.getId());

		Movement movement = this.getMovement(walletDto);
		wallet.getMovements().add(wallet.getMovements().size(), movement);

		Balance currentBalance = new Balance(Utils.generateSecureId(), movement.getQuantity().getCurrentDate(),
				wallet.getCurrentBalance().getQuantity() + walletDto.getQuantity());

		wallet.setCurrentBalance(currentBalance);

		this.data.set(this.data.indexOf(wallet), wallet);

		return wallet.getMovements();
	}

	@Override
	public List<Movement> withdrawals(WalletDTO walletDto) {
		walletDto.setDate(Utils.getCurrentDate());
		Wallet wallet = this.getWallet(walletDto.getId());

		Movement movement = getMovement(walletDto);

		Balance currentBalance = wallet.getCurrentBalance();

		currentBalance.setCurrentDate(movement.getQuantity().getCurrentDate());

		float currentQuantity = currentBalance.getQuantity() - walletDto.getQuantity();

		if (currentQuantity < 0) {
			throw new RuntimeException("You do not have enough balance to make this move");
		}

		currentBalance.setQuantity(currentBalance.getQuantity() - walletDto.getQuantity());

		wallet.setCurrentBalance(currentBalance);
		wallet.getMovements().add(wallet.getMovements().size(), movement);

		this.data.set(this.data.indexOf(wallet), wallet);

		return wallet.getMovements();
	}

	@Override
	public Wallet getWalletById(String id) {
		Wallet result = this.getWallet(id);

		return result;

	}

	@Override
	public Balance getCurrentBalance(String id) {
		Wallet result = this.getWallet(id);

		return result.getCurrentBalance();
	}

	private Movement getMovement(WalletDTO data) {
		Balance balance = new Balance(Utils.generateSecureId(), data.getDate(), data.getQuantity());

		Movement movement = new Movement();
		movement.setConcept(data.getConcept());
		movement.setDeposit(data.isDeposit());
		movement.setQuantity(balance);

		return movement;
	}

	@Override
	public Wallet getWalletByOwner(String ownerId){
		List<Wallet> result = this.data.stream().filter(wallet -> wallet.getOwnerid().equalsIgnoreCase(ownerId))
				.collect(Collectors.toList());

		if (result.size() == 0) {
			throw new RuntimeException("This user does not have any wallet");
		}

		return result.get(0);
	}

	private Wallet getWallet(String id) {
		List<Wallet> result = this.data.stream().filter(wallet -> wallet.getId().equalsIgnoreCase(id))
				.collect(Collectors.toList());

		if (result.size() == 0) {
			throw new RuntimeException("There is no wallet with this id");
		}

		return result.get(0);
	}

	@Override
	public List<Movement> getMovements(String id) throws RuntimeException {
		Wallet wallet = this.getWallet(id);

		if (wallet == null) {
			throw new RuntimeException("There is no wallet with this id");
		}

		return wallet.getMovements();
	}

}
