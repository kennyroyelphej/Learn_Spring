package com.elcorp.annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {
			"Be careful who you trust. Salt and sugar look the same.",
			"Every new beginning comes from some other beginning's end.",
			"I never dreamed about success. I worked for it."
	};
	Random random = new Random();

	@Override
	public String getFortune() {
		int index = random.nextInt(fortunes.length);
		return fortunes[index];
	}

}
