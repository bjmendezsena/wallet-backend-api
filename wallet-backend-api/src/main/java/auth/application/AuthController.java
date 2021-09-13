package auth.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import auth.domain.LoginRequest;
import auth.domain.User;
import shared.RequestResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	RestTemplate template;

	@Autowired
	private AuthService service;

	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestResponse login(@RequestBody LoginRequest request) {
		User user = this.service.login(request);

		return new RequestResponse(user, true);

	}

	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestResponse register(@RequestBody User user) {

		this.service.register(user);

		return new RequestResponse("User has successfully registered", true);

	}

}
