package com.elcorp.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationBeanLifecycle {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycleApplicationContext.xml");
		
		Coach coach = context.getBean("myCoach",Coach.class);
		System.out.println(coach.getDailyWorkout());
		
		context.close();
				
	}

}
