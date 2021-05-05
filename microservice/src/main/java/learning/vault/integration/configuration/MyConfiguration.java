package learning.vault.integration.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("example")
public class MyConfiguration {
	String username;
	String password;
}
