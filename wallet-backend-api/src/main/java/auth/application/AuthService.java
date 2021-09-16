package auth.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.domain.AuthRepository;
import auth.domain.LoginRequest;
import auth.domain.User;
import wallet.domain.Wallet;
import wallet.domain.WalletRepository;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private WalletRepository wRepository;

	public User login(LoginRequest request) {
		
		User user = this.authRepository.login(request);
		boolean haveAccount = false;
		
		if(user != null) {
			Wallet wallet = this.getUserWallet(user);
			
			if(wallet != null) {
				user.setWallet(wallet);
				haveAccount = true;
			}
			user.setHaveAccount(haveAccount);
		}
		return user;

	}

	public User register(User data) {
		try {
			User user = this.authRepository.register(data);
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	private Wallet getUserWallet(User user) {
		Wallet wallet = null;

		try {
			wallet = this.wRepository.getWalletByOwner(user.getDni());

		} catch (Exception e) {

		}

		return wallet;
	}

}
