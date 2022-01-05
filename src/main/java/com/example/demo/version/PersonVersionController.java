package com.example.demo.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

	
	
	@GetMapping("/person/v1")
	public Personv1 getPersonv1()
	{
		return new Personv1("Amit Tiwari");
	
		
	}
	
	@GetMapping("/person/v2")
	public Personv2 getPersonv2()
	{
		return new Personv2(new Name("Amit", "Tiwari"));
		
	}
	
	
	
}
