package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DemoApplicationTests {

	TestController testController = new TestController();

	@Test
	void contextLoads() {
	}

	@Test
	void shouldConfirmTestVersion() {
		String actual = testController.sayHello();
		Assertions.assertEquals("Hallo, ich bin die Testversion", actual);
	}

}
