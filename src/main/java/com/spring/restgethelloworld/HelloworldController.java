package com.spring.restgethelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	private static final String template = "Hello, %s!";

	@GetMapping("/helloworld")
	public Helloworld greeting(String name) {
		return new Helloworld(String.format(template, "World!!"));
	}
}