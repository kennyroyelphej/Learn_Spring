package com.elcorp.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplication {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get Bean from container
		Coach tennis = context.getBean("tennisCoach",Coach.class);
//		Coach tennis = context.getBean("thatSillyCoach",Coach.class);
		System.out.println("My daily workout: "+tennis.getDailyWorkout());
		System.out.println("My daily fortune: "+tennis.getDailyFortune());
		
		Coach tennisAssist = context.getBean("tennisCoach",Coach.class);
		System.out.println("My daily workout: "+tennisAssist.getDailyWorkout());
		System.out.println("My daily fortune: "+tennisAssist.getDailyFortune());
		
		boolean beanCheck = (tennis == tennisAssist);
		System.out.println("\nPointing same bean: " + beanCheck);	
		System.out.println("Memory loaction for coachA: " + tennis);
		System.out.println("Memory loaction for coachB: " + tennisAssist);
		
		context.close();
		
	}

}
