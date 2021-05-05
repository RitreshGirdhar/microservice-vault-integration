package learning.vault.integration.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Value("${test:1}")
	private String name;

	@RequestMapping(value = "/")
	public ResponseEntity get() {
		return new ResponseEntity("Hello " + name, HttpStatus.OK);
	}

}
