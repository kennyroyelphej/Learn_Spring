package com.elcorp.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// IOC and DI Construct Injection
		Coach coach = context.getBean("myCoach",Coach.class);
		System.out.println(coach.getDailyWorkout() + ", " + coach.getDailyFortune());
		
		//DI Setter Injection
		Coach circket = context.getBean("myCricketCoach",CricketCoach.class);
		System.out.println(circket.getDailyWorkout() + ", " + circket.getDailyFortune());
		
		//Literal value injection
		System.out.println(((CricketCoach) circket).getEmailAddress());
		System.out.println(((CricketCoach) circket).getTeam());
		
		context.close();
	}

}
