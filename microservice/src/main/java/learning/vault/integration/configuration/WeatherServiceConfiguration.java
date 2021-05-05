package learning.vault.integration.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("weather")
public class WeatherServiceConfiguration {
	String username;
	String password;
	String uri;
}
