package com.elcorp.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// No need component scan, use declared method only
//@ComponentScan("com.elcorp.annotations")
@PropertySource("classpath:sport.properties")
public class NoXMLConfiguration {

	// Define bean fortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Define bean swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
