package auth.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.domain.AuthRepository;
import auth.domain.LoginRequest;
import auth.domain.User;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;

	public AuthService(AuthRepository authRepository) {
		this.authRepository = authRepository;
	}

	public User login(LoginRequest request) {
		return this.authRepository.login(request);

	}

	public boolean register(User user) {
		try {
			this.authRepository.register(user);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

}
