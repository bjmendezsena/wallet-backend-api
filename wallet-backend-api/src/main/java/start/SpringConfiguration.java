package start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan({"auth.application", "auth.infrastructure", "shared.exceptions"})
public class SpringConfiguration {

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
