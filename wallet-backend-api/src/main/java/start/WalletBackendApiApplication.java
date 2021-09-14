package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan({"auth.application", "auth.infrastructure", "shared.domain", "wallet.application", "wallet.infrastructure"})
@SpringBootApplication
public class WalletBackendApiApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(WalletBackendApiApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
