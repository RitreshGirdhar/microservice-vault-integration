package learning.vault.integration;

import learning.vault.integration.configuration.WeatherServiceConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.net.URISyntaxException;

@SpringBootApplication
@EnableConfigurationProperties(WeatherServiceConfiguration.class)
@EnableAutoConfiguration
public class MicroserviceApplication implements CommandLineRunner {

	public MicroserviceApplication(WeatherServiceConfiguration configuration) {
		this.configuration = configuration;
	}
	private final WeatherServiceConfiguration configuration;

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@Override public void run(String... args) throws Exception {
		System.out.println("   example.username is "+ configuration.getUsername());
		System.out.println("   example.password is "+ configuration.getPassword());
	}
}
