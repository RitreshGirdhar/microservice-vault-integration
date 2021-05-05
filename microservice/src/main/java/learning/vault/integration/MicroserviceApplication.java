package learning.vault.integration;

import learning.vault.integration.configuration.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableConfigurationProperties(MyConfiguration.class)
@EnableAutoConfiguration
public class MicroserviceApplication implements CommandLineRunner {

	public MicroserviceApplication(MyConfiguration configuration) {
		this.configuration = configuration;
	}
	private final MyConfiguration configuration;

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(MicroserviceApplication.class, args);
//		VaultTemplate vaultTemplate = new VaultTemplate(VaultEndpoint.from(new URI("http://localhost:8200")), new TokenAuthentication("myroot"));
//		VaultResponse read= vaultTemplate.read("secret/data/gs-vault-config");
//		System.out.println(read.getData());
	}

//	@Autowired
//	private Environment env;
//
//	@Value("${example.password:1}")
//	String password;
//
//	@PostConstruct
//	private void postConstruct() {
//		System.out.println("My password is: " + password);
//		System.out.println(env.getProperty("example.password"));
//	}

	@Override public void run(String... args) throws Exception {
		System.out.println("   example.username is "+ configuration.getUsername());
		System.out.println("   example.password is "+ configuration.getPassword());
	}
}
