package auth.domain;

public interface AuthRepository {

	User login(LoginRequest request);

	void register(User user);
}
