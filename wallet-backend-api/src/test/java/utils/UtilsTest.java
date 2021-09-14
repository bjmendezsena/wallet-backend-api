package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import start.SpringConfiguration;

@SpringBootTest(classes = { SpringConfiguration.class })
public class UtilsTest {

	@Test
	void getCurrentDateTest() {
		assertThat(Utils.getCurrentDate()).isNotNull();
	}
	
	@Test
	void generateSecureId() {
		assertThat(Utils.generateSecureId()).isNotNull();
	}
}
