package com.example.advanced.trace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.advanced.strategy.ContextV1;
import com.example.advanced.strategy.Strategy;
import com.example.advanced.strategy.StrategyLogic1;
import com.example.advanced.strategy.StrategyLogic2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ContextV1Test {

	@Test
	void strategyV0() {
		logic1();
		logic2();
	}

	private void logic1() {
		long startTime = System.currentTimeMillis();
		// 비즈니스 로직 실행
		log.info("비즈니스 로직1 실행");
		// 비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}

	private void logic2() {
		long startTime = System.currentTimeMillis();
		// 비즈니스 로직 실행
		log.info("비즈니스 로직2 실행");
		// 비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}
	
	//전략패턴 적용
	//context에 원하는 Strategy구현체를 주입한다
	//클라이언트는 context를 실행한다
	
	@Test
	void staartegyV1() {
		//인터페이스는 생성자를 생성할수 없다. 그래서 인터페이스는 객체생성이안된다
		//부모인터페이스로 객체생성
		Strategy strategyLogic1 = new  StrategyLogic1();
		//클래스에 생성자가 명시적으로 선언되어 있을경우 선언된 생성자를 호출해서 객체를 생성해야한다.
		ContextV1 context1 = new ContextV1(strategyLogic1);
		context1.execute();
		
		Strategy strategyLogic2 = new StrategyLogic2();
		 ContextV1 context2 = new ContextV1(strategyLogic2);
		 context2.execute();
	}
	
	//전략패턴도 익명내부클래스를 사용할수 있다.
	@Test
	void staartegyV2() {
		Strategy strategyLogic1 = new Strategy() {
			
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		};
		log.info("strategyLogic1={}", strategyLogic1.getClass());
		ContextV1 contextV1 = new ContextV1(strategyLogic1);
		contextV1.execute();
		
		Strategy strategyLogic2 = new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		};
		log.info("strategyLogic2={}", strategyLogic2.getClass());
		ContextV1 context2 = new ContextV1(strategyLogic2);
		context2.execute();
	}

	//익명내부클래스를 변수에 담아두지말고 생성하면서 바로 전달해도된다
	@Test
	void strategyV3() {
		ContextV1 contextV1 = new ContextV1(new Strategy() {
			
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		});
		
		contextV1.execute();
		
		ContextV1 context2 = new ContextV1(new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		});
		context2.execute();
	}
	
	//익명내부 클래스를 람다로 변경할수잇따. 
	@Test
	void strategyV4() {
		ContextV1 contextV1 = new ContextV1(()->log.info("비즈니스로직1실행"));
		contextV1.execute();
		
		
		ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
		 context2.execute();
		
		
	}
}