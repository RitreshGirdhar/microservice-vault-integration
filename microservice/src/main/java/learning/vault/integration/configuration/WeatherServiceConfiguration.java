package learning.vault.integration.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@ConfigurationProperties("weather")
@RefreshScope
public class WeatherServiceConfiguration {
	String username;
	String password;
	String uri;
}
