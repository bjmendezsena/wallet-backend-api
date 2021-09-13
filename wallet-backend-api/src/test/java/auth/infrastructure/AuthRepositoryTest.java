package auth.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import auth.domain.AuthRepository;
import auth.domain.LoginRequest;
import auth.domain.User;
import auth.shared.TestHelpers;
import start.SpringConfiguration;

@SpringBootTest(classes = { SpringConfiguration.class })
public class AuthRepositoryTest {

	@Autowired
	private AuthRepository authRepository;

	@Test
	void loginTest() {
		User userTest = TestHelpers.createUser();
		LoginRequest request = new LoginRequest(userTest.getEmail(), userTest.getPassword());
		authRepository = org.mockito.Mockito.mock(AuthRepositoryImpl.class);
		when(authRepository.login(request)).thenReturn(TestHelpers.createUser());
		User user = authRepository.login(request);

		assertThat(user.getEmail()).containsIgnoringCase(request.getEmail());
	}

	@Test
	void loginFailedTest() {
		String expected = "Invalid credentials";
		String result = "";
		try {
			authRepository.login(new LoginRequest("tes@test.com", "123456"));

		} catch (Exception e) {
			result = e.getMessage();
		}
		assertThat(result).containsIgnoringCase(expected);

	}

	@Test
	void registerTest() {
		boolean isAdded;
		try {

			authRepository.register(TestHelpers.createUser());
			isAdded = true;

		} catch (Exception e) {
			isAdded = false;
		}
		assertThat(isAdded).isTrue();

	}

	@Test
	void registerFailedIfUserExistTest() {

		String expected = "This user already exists in our database";
		String result = "";

		try {

			authRepository.register(TestHelpers.createUser());

		} catch (Exception e) {
			result = e.getMessage();
		}
		assertThat(result).containsIgnoringCase(expected);

	}

	@Test
	void registerFailedIfEmailExistTest() {

		String expected = "There is already a user with this email";
		String result = "";

		try {
			User user = TestHelpers.createUser();

			user.setEmail("test@test.com");

			authRepository.register(user);

		} catch (Exception e) {
			result = e.getMessage();
		}
		assertThat(result).containsIgnoringCase(expected);

	}


}
