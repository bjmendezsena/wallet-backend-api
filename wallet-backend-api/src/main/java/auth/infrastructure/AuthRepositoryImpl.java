package auth.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import auth.domain.AuthRepository;
import auth.domain.LoginRequest;
import auth.domain.User;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

	private List<User> data;

	@PostConstruct
	public void init() {
		this.data = new ArrayList<User>();
		this.data.add(new User("46471586V", "Lewis", "Mendez", "test@test.com", "123456" ));
		this.data.add(new User("46471585Q", "Leinor", "Mendez", "test2@test.com", "123456"));
		this.data.add(new User("46471585V", "Miguel", "Mendez", "test3@test.com", "123456"));
	}

	@Override
	public void register(User user) throws RuntimeException {
		validateUser(user);

		user.setDni(user.getDni().toUpperCase());
		this.data.add(user);

	}

	private void validateUser(User userToValidate) {

		for (User user : this.data) {
			if (user.getDni().equalsIgnoreCase(userToValidate.getDni())) {
				throw new RuntimeException("This user already exists in our database");
			}

			if (user.getEmail().equalsIgnoreCase(userToValidate.getEmail())) {
				throw new RuntimeException("There is already a user with this email");
			}
		}
	}

	@Override
	public User login(LoginRequest request) {
		List<User> result = this.data.stream().filter(user -> user.getEmail().equalsIgnoreCase(request.getEmail())
				&& user.getPassword().equals(request.getPassword())).collect(Collectors.toList());

		if (result.size() > 0) {
			return result.get(0);
		}

		throw new RuntimeException("Invalid credentials");
	}

}
