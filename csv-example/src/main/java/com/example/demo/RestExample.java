package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping; // import the spring lib for mapping
import org.springframework.web.bind.annotation.RestController; //  import the spring lib for controllers

@RestController // create the controller
public class RestExample {
	
	private CsvParser parser;
	public RestExample(CsvParser parser) {
		this.parser = parser;
	}
	
	@GetMapping("/housing-stats") // create the mapping
	public String testEndpoint() {
		return parser.doAThing();
	}

}
