package br.com.udemy_microsservices;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private static final AtomicLong counter = new AtomicLong();//Essa variavél com esse tipo vai mokar um ID
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Word")String name) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
