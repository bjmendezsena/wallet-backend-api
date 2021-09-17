package auth.application;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import auth.domain.LoginRequest;
import auth.domain.User;
import auth.shared.TestHelpers;
import start.SpringConfiguration;

@AutoConfigureMockMvc
@SpringBootTest(classes = { SpringConfiguration.class })
@EnableWebMvc
public class AuthControllerTest {

	@Autowired
	MockMvc mock;

	@Test
	void loginTest() throws Exception {
		

		mock.perform(post("/auth/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(TestHelpers.asJsonString(new LoginRequest("test@test.com", "123456")))).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()));
	}

	@Test
	void registerTest() throws Exception {
		User user = TestHelpers.createUser();

		mock.perform(post("/auth/register").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(TestHelpers.asJsonString(user))).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()));
	}

}
