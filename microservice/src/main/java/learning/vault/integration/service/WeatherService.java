package learning.vault.integration.service;

import learning.vault.integration.configuration.WeatherServiceConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RefreshScope
public class WeatherService {

	@Autowired
	private WeatherServiceConfiguration weatherServiceConfiguration;

	public String getWeather() {
		// Http call to weather service using username password
		log.info("invoking "+weatherServiceConfiguration.getUri() +" with username::"+ weatherServiceConfiguration.getUsername());
		return "Sunny";
	}


}
