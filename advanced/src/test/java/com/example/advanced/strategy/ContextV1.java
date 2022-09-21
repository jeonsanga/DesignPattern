package com.example.advanced.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

//필드에 전략을 보관하는 방식
@Slf4j
public class ContextV1 {
	//변하지않는 로직을 가지고 있는 템플릿 역할을 하는 코드이다.
	//strategy를 통해 일부 전략이 변경된다고 생각하면된다
	//전략패턴의 핵심은 ContextV1은 Strategy인터페이스에만 의존한다는 점이다
	//덕분에 Strategy의 구현체를 변경하거나 새로 만들어도 ContextV1코드에는 영향을 주지 않는다
	
	@Autowired
	private Strategy strategy;
	
	
	 public ContextV1(Strategy strategy) {
		 this.strategy = strategy;
	}
	
	public void execute() {
		long startTime = System.currentTimeMillis();
		// 비즈니스 로직 실행
		strategy.call(); // 위임
		// 비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}
}
