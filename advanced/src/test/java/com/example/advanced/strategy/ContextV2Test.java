package com.example.advanced.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.filter.TypeExcludeFilters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ContextV2Test {

	@Test
	void strategyV1() {
		//따로 명시된 생성자가 없기때문에 기본생성자 호출
		ContextV2 contextV2 = new ContextV2();
		contextV2.execute(new StrategyLogic1());
		contextV2.execute(new StrategyLogic2());
	}
	
	@Test
	void strategyV2() {
		ContextV2 contextV2 = new ContextV2();
		contextV2.execute(new Strategy() {
			
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		});
		
		contextV2.execute(new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		});
	}
	
	@Test
	void strategyV3() {
		ContextV2 contextV2 = new ContextV2();
		contextV2.execute(()->log.info("비즈니스로직1 실행"));
		contextV2.execute(() -> log.info("비즈니스 로직2 실행"));
	}
	

}
