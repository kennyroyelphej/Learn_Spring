package com.elcorp.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationBeanScope {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		
		Coach coachA = context.getBean("myCoach",Coach.class);
		Coach coachB = context.getBean("myCoach",Coach.class);
		
		boolean beanCheck = (coachA == coachB);
		System.out.println("Pointing same bean: " + beanCheck);	
		System.out.println("Memory loaction for coachA: " + coachA);
		System.out.println("Memory loaction for coachB: " + coachB);
		
		context.close();
				
	}

}
