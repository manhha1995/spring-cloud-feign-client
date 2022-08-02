package com.feign.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
	properties = {"httpbin=http://localhost:8761"})
class ExampleApplicationTests {

	@Autowired
	WebTestClient webTestClient;
	
	@Test
	public void contextLoaded() throws Exception {
	}
}
