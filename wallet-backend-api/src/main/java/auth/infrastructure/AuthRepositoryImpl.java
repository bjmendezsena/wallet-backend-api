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
	}

	@Override
	public User register(User user) throws RuntimeException {
		validateUser(user);

		user.setDni(user.getDni().toUpperCase());
		this.data.add(user);
		
		return user;

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

	@Override
	public User getUserByDni(String dni) {
		List<User> result = this.data.stream()
				.filter(user -> user.getDni() != null && user.getDni().equalsIgnoreCase(dni))
				.collect(Collectors.toList());
		
		if(result != null && result.size() > 0) {
			return result.get(0);
		}
		
		return null;
	}

}
