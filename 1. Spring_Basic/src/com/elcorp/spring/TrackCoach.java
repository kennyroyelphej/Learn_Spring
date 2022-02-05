package com.elcorp.spring;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Breathe in Breathe out";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
	
	public void onBeanInit() {
		System.out.println("TrackCoach: Bean Initialized");
	}
	
	public void onBeanDestroy() {
		System.out.println("TrackCoach: Bean Destroyed");
	}

}
