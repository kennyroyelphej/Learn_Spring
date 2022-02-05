package com.elcorp.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplicationNoXML {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NoXMLConfiguration.class);
		
		// Get Bean from container
		Coach swim = context.getBean("swimCoach",Coach.class);
		System.out.println("My daily workout: "+swim.getDailyWorkout());
		System.out.println("My daily fortune: "+swim.getDailyFortune());
		System.out.println("Information: "+((SwimCoach) swim).getEmail() + " " + ((SwimCoach) swim).getTeam());
		context.close();
	}
	
}
