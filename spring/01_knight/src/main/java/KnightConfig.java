package com.alex.spring.knight;

import org.springframework.context.annotation.*;

@Configuration
public class KnightConfig {
  	@Bean
  	public Knight knight() {
    	return new BraveKnight(quest());
  	}
  
  	@Bean
  	public Quest quest() {
    	return new SlayDragonQuest(System.out);
  	}
}