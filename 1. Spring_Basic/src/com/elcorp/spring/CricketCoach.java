package com.elcorp.spring;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;

	//Create no-args constructor
	public CricketCoach() {
		System.out.println("Cricket Coach: inside no-args constructor");
	}
	
	//Generate setter method for service
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice helicopter shot daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
