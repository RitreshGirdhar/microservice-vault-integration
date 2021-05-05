package learning.vault.integration.controller;

import learning.vault.integration.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController(value = "/weather")
public class RestController {

	@Value("${test:1}")
	private String name;

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/")
	public ResponseEntity get() {
		return new ResponseEntity("Todays Weather is  " + weatherService.getWeather(), HttpStatus.OK);
	}

}
