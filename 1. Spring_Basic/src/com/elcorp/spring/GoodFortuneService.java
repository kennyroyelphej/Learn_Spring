package com.elcorp.spring;

public class GoodFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Nothing is impossible for you";
	}

}
