package auth.domain;

public interface AuthRepository {

	User login(LoginRequest request);

	User register(User user);
	
	User getUserByDni(String dni);
}
