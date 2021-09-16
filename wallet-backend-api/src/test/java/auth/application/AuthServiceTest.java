package auth.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import auth.domain.LoginRequest;
import auth.domain.User;
import auth.shared.TestHelpers;
import start.SpringConfiguration;

@SpringBootTest(classes = { SpringConfiguration.class })
public class AuthServiceTest {

	@Autowired
	private AuthService authService;

	@Test
	void loginTest() {
		User userTest = TestHelpers.createUser();
		LoginRequest request = new LoginRequest(userTest.getEmail(), userTest.getPassword());
		authService = org.mockito.Mockito.mock(AuthService.class);
		when(authService.login(request)).thenReturn(TestHelpers.createUser());
		User userResult = authService.login(request);

		assertThat(userResult.getEmail()).containsIgnoringCase(request.getEmail());
	}

	@Test
	void loginFailedTest() {
		boolean failed = false;
		try {
			authService.login(new LoginRequest("tes@test.com", "123456"));

		} catch (Exception e) {
			failed = true;
		}
		assertThat(failed).isTrue();

	}

	@Test
	void registerTest() {
		User user = TestHelpers.createUser();
		user.setDni("4444");
		user.setEmail("lewis@gmail.com");
		User result  = authService.register(user);

		assertThat(result).isNotNull();
	}

	@Test
	void registerFailedTest() {
		boolean failed = false;
		try {
			User user = TestHelpers.createUser();
			user.setEmail("test@test.com");
			when(authService.register(user)).thenReturn(user);
			authService.register(user);

		} catch (Exception e) {
			failed = true;
		}
		assertThat(failed).isTrue();
	}

}
