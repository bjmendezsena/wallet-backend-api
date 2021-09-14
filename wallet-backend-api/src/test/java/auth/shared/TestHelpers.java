package auth.shared;

import com.fasterxml.jackson.databind.ObjectMapper;

import auth.domain.User;
import utils.Utils;
import wallet.domain.Balance;
import wallet.domain.Movement;
import wallet.domain.Wallet;

public class TestHelpers {

	public static User createUser() {
		return new User("666", "test", "test", "testing@testing.com", "123456");
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
