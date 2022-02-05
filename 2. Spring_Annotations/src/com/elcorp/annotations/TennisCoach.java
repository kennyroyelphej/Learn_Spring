package com.elcorp.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Component("thatSillyCoach")
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	//Field Injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//	// Constructor Injection
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	// Default Constructor
	public TennisCoach() { }
	
	@Override
	public String getDailyWorkout() {
		return "Practice your strokes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
//	// Setter Injection
//	@Autowired
//	public void setFortuneSerivce(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
//	// Autowired matters not method name
//	@Autowired
//	public void randomMethodInjection(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
//	// Removed @ Java 11 to be added manually
//	@PostConstruct 
//	public void onBeanInit() {
//		System.out.println("TennisCoach: Bean Initialized");
//	}
	
//	// Removed @ Java 11 to be added manually	
//	@PreDestroy
//	public void onBeanDestroy() {
//		System.out.println("TennisCoach: Bean Destroyed");
//	}

}
